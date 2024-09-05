package lists

import base.IList

class SinglyLinkedList<T> : IList<T> {

    private var size = 0
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override fun add(value: T): Boolean {
        return add(Node(value))
    }

    override fun remove(value: T): Boolean {
        var prev: Node<T>? = null
        var node = head

        // Find the node
        while (node != null && node.value != value) {
            prev = node
            node = node.next
        }

        if (node == null) return false

        // Update the tail, if needed
        if (node == tail) {
            tail = prev
            prev?.next = null
        }

        val next = node.next
        when {
            prev != null && next != null -> prev.next = next
            prev != null && next == null -> prev.next = null
            prev == null && next != null -> head = next // Node is the head
            else -> head = null
        }

        size--
        return true
    }

    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    override fun contains(value: T): Boolean {
        var node = head
        while (node != null) {
            if (node.value == value) return true
            node = node.next
        }
        return false
    }

    override fun size(): Int {
        return size
    }

    override fun validate(): Boolean {
        val keys = mutableSetOf<T>()
        val node = head
        if (node != null) {
            keys.add(node.value)

            var child = node.next
            while (child != null) {
                if (!validate(child, keys)) return false
                child = child.next
            }
        }
        return keys.size == size
    }

    private fun validate(node: Node<T>, keys: MutableSet<T>): Boolean {
        if (node.value == null) return false

        keys.add(node.value)

        val child = node.next
        if (child == null && node != tail) {
            return false
        }
        return true
    }

    override fun toString(): String {
        val builder = StringBuilder()
        var node = head
        while (node != null) {
            builder.append(node.value).append(", ")
            node = node.next
        }
        return builder.toString()
    }

    private class Node<T>(val value: T) {
        var next: Node<T>? = null

        override fun toString(): String {
            return "value=$value next=${next?.value ?: "NULL"}"
        }
    }

    private fun add(node: Node<T>): Boolean {
        if (head == null) {
            head = node
            tail = node
        } else {
            val prev = tail
            prev?.next = node
            tail = node
        }
        size++
        return true
    }
}
