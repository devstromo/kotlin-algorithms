package queues

import base.IQueue

class ArrayQueue<T> : IQueue<T> {

    companion object {
        private const val MINIMUM_SIZE = 1024
    }

    private var list: MutableList<T?> = MutableList(MINIMUM_SIZE) { null }
    private var lastIndex = 0
    private var firstIndex = 0

    override fun offer(value: T): Boolean {
        if (size() >= list.size) {
            grow(size())
        }

        list[lastIndex % list.size] = value
        lastIndex++
        return true
    }

    override fun poll(): T? {
        val size = lastIndex - firstIndex
        if (size < 0) return null

        val t = list[firstIndex % list.size]
        list[firstIndex % list.size] = null
        firstIndex++

        val newSize = lastIndex - firstIndex
        if (newSize <= 0) {
            // Removed last element
            lastIndex = 0
            firstIndex = 0
        }

        val shrinkSize = list.size shr 1
        if (shrinkSize >= MINIMUM_SIZE && newSize < shrinkSize) {
            shrink()
        }

        return t
    }

    override fun peek(): T? {
        return list[firstIndex % list.size]
    }

    override fun remove(value: T): Boolean {
        for (i in list.indices) {
            val obj = list[i]
            // if obj is null, it should return false (not NPE)
            if (value == obj) return remove(i)
        }
        return false
    }

    private fun remove(index: Int): Boolean {
        if (index < 0 || index >= list.size) return false
        if (index == firstIndex) return (poll() != null)

        val adjIndex = index % list.size
        val adjLastIndex = (lastIndex - 1) % list.size
        if (adjIndex != adjLastIndex) {
            // Shift the list down one spot
            for (i in index until (list.size - 1)) {
                list[i] = list[i + 1]
            }
            if (adjLastIndex < firstIndex) {
                // Wrapped around list
                list[list.size - 1] = list[0]
                for (i in 0 until (firstIndex - 1)) {
                    list[i] = list[i + 1]
                }
            }
        }
        list[adjLastIndex] = null

        val shrinkSize = list.size shr 1
        if (shrinkSize >= MINIMUM_SIZE && size() < shrinkSize) {
            shrink()
        }

        lastIndex--
        return true
    }

    private fun grow(size: Int) {
        val growSize = size + (size shl 1)
        val temp: MutableList<T?> = MutableList(growSize) { null }

        // Since the list can wrap around, make sure you grab the first chunk
        val adjLast = lastIndex % list.size
        if (adjLast in 1..firstIndex) {
            // Copy the first chunk to the end of the new list
            for (i in 0 until adjLast) {
                temp[temp.size - list.size + i] = list[i]
            }
        }

        // Copy the remaining part of the old list to the beginning of the new list
        for (i in firstIndex until list.size) {
            temp[i - firstIndex] = list[i]
        }

        list = temp
        lastIndex -= firstIndex
        firstIndex = 0
    }

    // Shrink the list by 50% and rearrange to make sequential
    private fun shrink() {
        val shrinkSize = list.size shr 1
        val temp: MutableList<T?> = MutableList(shrinkSize) { null }

        // Since the list can wrap around, make sure you grab the first chunk
        val adjLast = lastIndex % list.size
        val endIndex = if (lastIndex > list.size) list.size else lastIndex

        if (adjLast <= firstIndex) {
            // Copy first chunk
            for (i in 0 until adjLast) {
                temp[temp.size - firstIndex + i] = list[i]
            }
        }
        // Copy the remaining
        for (i in firstIndex until endIndex) {
            temp[i - firstIndex] = list[i]
        }

        list = temp
        lastIndex -= firstIndex
        firstIndex = 0
    }

    override fun clear() {
        for (i in list.indices) {
            list[i] = null
        }
        firstIndex = 0
        lastIndex = 0
    }

    override fun contains(value: T): Boolean {
        for (i in list.indices) {
            val obj = list[i]
            // if obj is null, it should return false (not NPE)
            if (value == obj) return true
        }
        return false
    }

    override fun validate(): Boolean {
        if (size() == 0) return true

        var localSize = 0
        var realFirst = firstIndex
        if (firstIndex > list.size) realFirst = firstIndex % list.size
        var realLast = lastIndex
        if (lastIndex > list.size) realLast = lastIndex % list.size
        for (i in list.indices) {
            val t = list[i]
            if (realFirst == realLast ||
                (realFirst < realLast && i in realFirst until realLast) ||
                (realLast < realFirst && (i < realLast || i >= realFirst))
            ) {
                if (t == null) return false
                localSize++
            } else {
                if (t != null) return false
            }
        }
        return localSize == size()
    }

    override fun size(): Int {
        return lastIndex - firstIndex
    }

    override fun toString(): String {
        val builder = StringBuilder()
        for (i in lastIndex - 1 downTo firstIndex) {
            builder.append(list[i % list.size]).append(", ")
        }
        return builder.toString()
    }
}
