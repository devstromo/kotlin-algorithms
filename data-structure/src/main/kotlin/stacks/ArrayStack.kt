package stacks

import base.IStack

class ArrayStack<T> : IStack<T> {

    companion object {
        private const val MINIMUM_SIZE = 1024
    }

    private var array: Array<Any?> = arrayOfNulls<Any?>(MINIMUM_SIZE)
    private var size = 0

    override fun push(value: T): Boolean {
        if (size >= array.size) grow()
        array[size++] = value
        return true
    }

    override fun pop(): T {
        if (size <= 0) throw NoSuchElementException()

        @Suppress("UNCHECKED_CAST")
        val value = array[--size] as T
        array[size] = null

        val shrinkSize = array.size shr 1
        if (shrinkSize >= MINIMUM_SIZE && size < shrinkSize) shrink()

        return value
    }

    override fun peek(): T {
        if (size <= 0) throw NoSuchElementException()

        @Suppress("UNCHECKED_CAST")
        return array[size - 1] as T
    }

    override fun remove(value: T): Boolean {
        for (i in 0 until size) {
            @Suppress("UNCHECKED_CAST")
            val obj = array[i] as T
            if (obj == value) {
                return remove(i)
            }
        }
        return false
    }

    override fun clear() {
        size = 0
    }

    override fun contains(value: T): Boolean {
        for (i in 0 until size) {
            @Suppress("UNCHECKED_CAST")
            val obj = array[i] as T
            if (obj == value) return true
        }
        return false
    }

    override fun size(): Int = size

    override fun validate(): Boolean {
        var localSize = 0
        for (i in array.indices) {
            val t = array[i]
            if (i < size) {
                if (t == null) return false
                localSize++
            } else {
                if (t != null) return false
            }
        }
        return localSize == size
    }

    override fun toCollection(): Collection<T> {
        @Suppress("UNCHECKED_CAST")
        return array.copyOfRange(0, size).filterNotNull() as Collection<T>
    }

    override fun toString(): String {
        val builder = StringBuilder()
        for (i in size - 1 downTo 0) {
            builder.append(array[i]).append(", ")
        }
        return builder.toString()
    }

    private fun remove(index: Int): Boolean {
        if (index != size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1)
        }
        array[--size] = null

        val shrinkSize = array.size shr 1
        if (shrinkSize >= MINIMUM_SIZE && size < shrinkSize) shrink()

        return true
    }

    // Grow the array by 50%
    private fun grow() {
        val growSize = size + (size shl 1)
        array = array.copyOf(growSize)
    }

    // Shrink the array by 50%
    private fun shrink() {
        val shrinkSize = array.size shr 1
        array = array.copyOf(shrinkSize)
    }
}
