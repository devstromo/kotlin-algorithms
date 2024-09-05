package lists

import base.IList

class DoublyLinkedList<T> : IList<T> {

    private var size = 0
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override fun add(value: T): Boolean {
        return add(Node(value))
    }

    override fun remove(value: T): Boolean {
        // Find the node
        var node = head
        while (node != null && node.value != value) {
            node = node.next
        }

        if (node == null) return false

        // Update the tail if needed
        if (node == tail) {
            tail = node.prev
        }

        val prev = node.prev
        val next = node.next

        when {
            prev != null && next != null -> {
                prev.next = next
                next.prev = prev
            }

            prev != null && next == null -> {
                prev.next = null
            }

            prev == null && next != null -> {
                next.prev = null
                head = next // Node is the head
            }

            else -> head = null // prev == null && next == null
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
            if (node.prev != null) return false

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
        if (child != null) {
            if (child.prev != node) return false
        } else {
            if (node != tail) return false
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
        var prev: Node<T>? = null
        var next: Node<T>? = null

        override fun toString(): String {
            return "value=$value previous=${prev?.value ?: "NULL"} next=${next?.value ?: "NULL"}"
        }
    }

    private fun add(node: Node<T>): Boolean {
        if (head == null) {
            head = node
            tail = node
        } else {
            val prev = tail
            prev?.next = node
            node.prev = prev
            tail = node
        }
        size++
        return true
    }

}
