package sequences.fast_slow_pointers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FastSlowPointersUnitTest {
    private val fastSlowPointers = FastSlowPointers()

    @Test
    fun testHasCycleWhenCycleExists() {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node2

        assertTrue(fastSlowPointers.hasCycle(node1))
    }

    @Test
    fun testHasCycleWhenNoCycle() {
        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)

        node1.next = node2
        node2.next = node3
        node3.next = node4

        assertFalse(fastSlowPointers.hasCycle(node1))
    }

    @Test
    fun testHasCycleWhenEmptyList() {
        assertFalse(fastSlowPointers.hasCycle(null))
    }

    @Test
    fun testHasCycleSingleElementNoCycle() {
        val node1 = ListNode(1)

        assertFalse(fastSlowPointers.hasCycle(node1))
    }

    @Test
    fun testHasCycleSingleElementWithCycle() {
        val node1 = ListNode(1)
        node1.next = node1

        assertTrue(fastSlowPointers.hasCycle(node1))
    }
}