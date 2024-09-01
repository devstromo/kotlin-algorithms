package base

interface IList<T> {

    fun add(value: T): Boolean

    fun remove(value: T): Boolean

    fun clear()

    fun contains(value: T): Boolean

    fun size(): Int

    fun validate(): Boolean
}
