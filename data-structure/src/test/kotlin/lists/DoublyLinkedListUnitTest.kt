package lists

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DoublyLinkedListUnitTest {
    private lateinit var doublyLinkedList: DoublyLinkedList<Int>

    @BeforeEach
    fun setUp() {
        doublyLinkedList = DoublyLinkedList()
    }

    @Test
    fun testAdd() {
        assertTrue(doublyLinkedList.add(1))
        assertTrue(doublyLinkedList.add(2))
        assertEquals(2, doublyLinkedList.size())
        assertTrue(doublyLinkedList.contains(1))
        assertTrue(doublyLinkedList.contains(2))
    }

    @Test
    fun testRemoveValue() {
        doublyLinkedList.add(1)
        doublyLinkedList.add(2)
        doublyLinkedList.add(3)

        assertTrue(doublyLinkedList.remove(2))
        assertEquals(2, doublyLinkedList.size())
        assertFalse(doublyLinkedList.contains(2))

        assertTrue(doublyLinkedList.remove(1))
        assertTrue(doublyLinkedList.remove(3))
        assertEquals(0, doublyLinkedList.size())
        assertFalse(doublyLinkedList.contains(1))
        assertFalse(doublyLinkedList.contains(3))

        // Trying to remove a non-existent element
        assertFalse(doublyLinkedList.remove(4))
    }

    @Test
    fun testRemoveValueFromHeadAndTail() {
        doublyLinkedList.add(1)
        doublyLinkedList.add(2)
        doublyLinkedList.add(3)

        // Remove head
        assertTrue(doublyLinkedList.remove(1))
        assertEquals(2, doublyLinkedList.size())
        assertFalse(doublyLinkedList.contains(1))

        // Remove tail
        assertTrue(doublyLinkedList.remove(3))
        assertEquals(1, doublyLinkedList.size())
        assertFalse(doublyLinkedList.contains(3))
    }

    @Test
    fun testContains() {
        doublyLinkedList.add(1)
        doublyLinkedList.add(2)

        assertTrue(doublyLinkedList.contains(1))
        assertTrue(doublyLinkedList.contains(2))
        assertFalse(doublyLinkedList.contains(3))
    }

    @Test
    fun testClear() {
        doublyLinkedList.add(1)
        doublyLinkedList.add(2)
        doublyLinkedList.add(3)

        doublyLinkedList.clear()
        assertEquals(0, doublyLinkedList.size())
        assertFalse(doublyLinkedList.contains(1))
        assertFalse(doublyLinkedList.contains(2))
        assertFalse(doublyLinkedList.contains(3))
    }

    @Test
    fun testValidate() {
        doublyLinkedList.add(1)
        doublyLinkedList.add(2)
        doublyLinkedList.add(3)

        assertTrue(doublyLinkedList.validate())

        doublyLinkedList.remove(2)
        assertTrue(doublyLinkedList.validate())

        doublyLinkedList.clear()
        assertTrue(doublyLinkedList.validate())
    }

    @Test
    fun testToString() {
        doublyLinkedList.add(1)
        doublyLinkedList.add(2)
        doublyLinkedList.add(3)

        val expected = "1, 2, 3, "
        assertEquals(expected, doublyLinkedList.toString())
    }

    @Test
    fun testRemoveFromEmptyList() {
        assertFalse(doublyLinkedList.remove(1))
        assertEquals(0, doublyLinkedList.size())
    }

    @Test
    fun testEdgeCases() {
        // Removing from an empty list
        assertFalse(doublyLinkedList.remove(1))

        // Adding and removing single element
        doublyLinkedList.add(10)
        assertTrue(doublyLinkedList.contains(10))
        assertTrue(doublyLinkedList.remove(10))
        assertFalse(doublyLinkedList.contains(10))
        assertEquals(0, doublyLinkedList.size())

        // Removing head
        doublyLinkedList.add(5)
        doublyLinkedList.add(6)
        doublyLinkedList.add(7)
        assertTrue(doublyLinkedList.remove(5))
        assertEquals(2, doublyLinkedList.size())
    }
}