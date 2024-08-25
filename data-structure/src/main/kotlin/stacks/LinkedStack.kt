package stacks

import base.IStack

class LinkedStack<T> : IStack<T> {

    private var top: Node<T>? = null
    private var size = 0

    override fun push(value: T): Boolean {
        return push(Node(value))
    }

    private fun push(node: Node<T>): Boolean {
        if (top == null) {
            top = node
        } else {
            val oldTop = top
            top = node
            top!!.below = oldTop
            oldTop!!.above = top
        }
        size++
        return true
    }

    override fun pop(): T {
        top?.let { nodeToRemove ->
            top = nodeToRemove.below
            top?.above = null

            val value = nodeToRemove.value
            size--
            return value
        } ?: throw NoSuchElementException()
    }

    override fun peek(): T {
        return top?.value ?: throw NoSuchElementException()
    }

    fun get(index: Int): T? {
        var current = top
        for (i in 0 until index) {
            current = current?.below
            if (current == null) break
        }
        return current?.value
    }

    override fun remove(value: T): Boolean {
        var node = top
        while (node != null && node.value != value) {
            node = node.below
        }
        return node?.let { remove(it) } ?: false
    }

    private fun remove(node: Node<T>): Boolean {
        val above = node.above
        val below = node.below

        when {
            above != null && below != null -> {
                above.below = below
                below.above = above
            }

            above != null && below == null -> {
                above.below = null
            }

            above == null && below != null -> {
                below.above = null
                top = below
            }

            else -> {
                top = null
            }
        }
        size--
        return true
    }

    override fun clear() {
        top = null
        size = 0
    }

    override fun contains(value: T): Boolean {
        var node = top
        while (node != null) {
            if (node.value == value) return true
            node = node.below
        }
        return false
    }

    override fun size(): Int = size

    override fun validate(): Boolean {
        val keys = mutableSetOf<T>()
        var node = top
        node?.let {
            keys.add(it.value)
            if (it.above != null) return false
            var child = it.below
            while (child != null) {
                if (!validate(child, keys)) return false
                child = child.below
            }
        }
        return keys.size == size
    }

    private fun validate(node: Node<T>, keys: MutableSet<T>): Boolean {
        if (node.value == null) return false
        keys.add(node.value)

        val child = node.below
        if (child != null && child.above != node) return false
        return true
    }

    override fun toCollection(): Collection<T> {
        val result = mutableListOf<T>()
        var node = top
        while (node != null) {
            result.add(node.value)
            node = node.below
        }
        return result
    }

    override fun toString(): String {
        val builder = StringBuilder()
        var node = top
        while (node != null) {
            builder.append(node.value).append(", ")
            node = node.below
        }
        return builder.toString()
    }

    private class Node<T>(val value: T) {
        var above: Node<T>? = null
        var below: Node<T>? = null

        override fun toString(): String {
            return "value=$value above=${above?.value ?: "NULL"} below=${below?.value ?: "NULL"}"
        }
    }
}
