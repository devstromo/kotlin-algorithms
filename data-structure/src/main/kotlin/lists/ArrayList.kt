package lists

import base.IList

class ArrayList<T> : IList<T> {
    companion object {
        private const val MINIMUM_SIZE = 1024
    }

    private var size = 0
    private var array: Array<Any?> = arrayOfNulls(MINIMUM_SIZE)

    override fun add(value: T): Boolean {
        return add(size, value)
    }

    override fun remove(value: T): Boolean {
        for (i in 0 until size) {
            val obj = array[i]
            if (obj == value) {
                remove(i)
                return true
            }
        }
        return false
    }

    override fun clear() {
        size = 0
        array = arrayOfNulls(MINIMUM_SIZE)
    }


    override fun contains(value: T): Boolean {
        for (i in 0 until size) {
            val obj = array[i]
            if (obj == value) return true
        }
        return false
    }


    override fun size(): Int {
        return size
    }


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

    fun set(index: Int, value: T): T? {
        if (index < 0 || index >= size) return null
        @Suppress("UNCHECKED_CAST")
        val t = array[index] as T?
        array[index] = value
        return t
    }

    fun get(index: Int): T? {
        if (index < 0 || index >= size) return null
        @Suppress("UNCHECKED_CAST")
        return array[index] as T?
    }

    private fun remove(index: Int): T? {
        if (index < 0 || index >= size) return null

        @Suppress("UNCHECKED_CAST")
        val t = array[index] as T?
        if (index != --size) {
            System.arraycopy(array, index + 1, array, index, size - index)
        }
        array[size] = null

        val shrinkSize = array.size / 2
        if (shrinkSize >= MINIMUM_SIZE && size < shrinkSize) {
            shrink()
        }

        return t
    }

    private fun grow() {
        val growSize = size + (size * 2)
        array = array.copyOf(growSize)
    }

    private fun shrink() {
        val shrinkSize = array.size / 2
        array = array.copyOf(shrinkSize)
    }


    private fun add(index: Int, value: T): Boolean {
        if (size >= array.size) {
            grow()
        }
        if (index == size) {
            array[size] = value
        } else {
            // Shift the array down one spot
            System.arraycopy(array, index, array, index + 1, size - index)
            array[index] = value
        }
        size++
        return true
    }
}