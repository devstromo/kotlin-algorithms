package sequences.fast_slow_pointers

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * This class provides a method to detect cycles in a linked list
 * using the two-pointer technique, also known as the fast and slow pointers approach.
 */
class FastSlowPointers {

    /**
     * Determines if the given linked list contains a cycle.
     *
     * This method uses two pointers: a slow pointer that moves one step at a time,
     * and a fast pointer that moves two steps at a time. If there is a cycle in the list,
     * the fast pointer will eventually meet the slow pointer, indicating the presence of a cycle.
     *
     * @param head the head of the linked list to be checked for a cycle.
     * @return `true` if the linked list contains a cycle, `false` otherwise.
     */
    fun hasCycle(head: ListNode?): Boolean {
        var slow: ListNode? = head
        var fast: ListNode? = head

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next
            fast = fast.next!!.next

            if (slow == fast) {
                return true
            }
        }
        return false
    }
}