package queues

import base.IQueue

class LinkedQueue<T> : IQueue<T> {
    private data class Node<T>(val value: T, var next: Node<T>? = null)

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var _size = 0

    override fun offer(value: T): Boolean {
        val newNode = Node(value)
        if (tail == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
        _size++
        return true
    }

    override fun poll(): T? {
        if (head == null) return null
        val value = head?.value
        head = head?.next
        if (head == null) {
            tail = null
        }
        _size--
        return value
    }

    override fun peek(): T? {
        return head?.value
    }

    override fun remove(value: T): Boolean {
        if (head == null) return false

        if (head?.value == value) {
            head = head?.next
            if (head == null) {
                tail = null
            }
            _size--
            return true
        }

        var current = head
        while (current?.next != null) {
            if (current.next?.value == value) {
                current.next = current.next?.next
                if (current.next == null) {
                    tail = current
                }
                _size--
                return true
            }
            current = current.next
        }

        return false
    }

    override fun clear() {
        head = null
        tail = null
        _size = 0
    }

    override fun contains(value: T): Boolean {
        var current = head
        while (current != null) {
            if (current.value == value) return true
            current = current.next
        }
        return false
    }

    override fun size(): Int {
        return _size
    }

    override fun validate(): Boolean {
        var count = 0
        var current = head
        while (current != null) {
            count++
            current = current.next
        }
        return count == _size
    }
}
