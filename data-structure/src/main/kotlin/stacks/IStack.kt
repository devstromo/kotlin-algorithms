package stacks

interface IStack<T> {

    fun push(value: T): Boolean

    fun pop(): T

    fun peek(): T

    fun remove(value: T): Boolean

    fun clear()

    fun contains(value: T): Boolean

    fun size(): Int

    fun validate(): Boolean

    fun toCollection(): Collection<T>
}