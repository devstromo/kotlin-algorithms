package lists

import base.IList

class CircularLinkedList<T> : IList<T> {

    private var size = 0
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private class Node<T>(var value: T) {
        var next: Node<T>? = null
    }

    /**
     * Adds a new value to the circular linked list.
     * If the list is empty, the head and tail will point to the same node, and that node will point to itself.
     */
    override fun add(value: T): Boolean {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
            tail = newNode
            tail?.next = head // Circular link
        } else {
            tail?.next = newNode
            tail = newNode
            tail?.next = head // Circular link
        }
        size++
        return true
    }

    /**
     * Removes the first occurrence of the specified value from the circular linked list.
     */
    override fun remove(value: T): Boolean {
        if (head == null) return false // List is empty

        var current = head
        var prev: Node<T>? = null

        do {
            if (current?.value == value) {
                if (prev == null) {
                    // Removing head
                    if (head == tail) {
                        // Single element in list
                        head = null
                        tail = null
                    } else {
                        head = head?.next
                        tail?.next = head // Maintain circular link
                    }
                } else {
                    if (current != null) {
                        prev.next = current.next
                    }
                    if (current == tail) {
                        tail = prev // Update tail if removed node is the tail
                    }
                }
                size--
                return true
            }
            prev = current
            current = current?.next
        } while (current != head)

        return false
    }

    /**
     * Clears the entire circular linked list.
     */
    override fun clear() {
        head = null
        tail = null
        size = 0
    }

    /**
     * Checks whether the list contains the specified value.
     */
    override fun contains(value: T): Boolean {
        if (head == null) return false // List is empty

        var current = head
        do {
            if (current?.value == value) return true
            current = current?.next
        } while (current != head)

        return false
    }

    /**
     * Returns the size of the circular linked list.
     */
    override fun size(): Int {
        return size
    }

    /**
     * Validates the internal structure of the circular linked list.
     * It checks whether the last node points back to the head, maintaining the circular link.
     */
    override fun validate(): Boolean {
        if (size == 0) {
            return head == null && tail == null
        }

        if (tail?.next != head) return false

        var count = 0
        var current = head
        do {
            count++
            current = current?.next
        } while (current != head && count <= size)

        return count == size
    }

    /**
     * Returns a string representation of the circular linked list.
     */
    override fun toString(): String {
        if (head == null) return "[]"

        val builder = StringBuilder("[")
        var current = head
        do {
            builder.append(current?.value).append(", ")
            current = current?.next
        } while (current != head)

        builder.setLength(builder.length - 2) // Remove the last comma and space
        builder.append("]")
        return builder.toString()
    }
}
