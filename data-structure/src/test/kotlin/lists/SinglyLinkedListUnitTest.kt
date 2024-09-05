package lists

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SinglyLinkedListUnitTest {
    private lateinit var singlyLinkedList: SinglyLinkedList<Int>

    @BeforeEach
    fun setUp() {
        singlyLinkedList = SinglyLinkedList()
    }

    @Test
    fun testAdd() {
        assertTrue(singlyLinkedList.add(1))
        assertTrue(singlyLinkedList.add(2))
        assertEquals(2, singlyLinkedList.size())
        assertTrue(singlyLinkedList.contains(1))
        assertTrue(singlyLinkedList.contains(2))
    }

    @Test
    fun testRemoveValue() {
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        assertTrue(singlyLinkedList.remove(2))
        assertEquals(2, singlyLinkedList.size())
        assertFalse(singlyLinkedList.contains(2))

        assertTrue(singlyLinkedList.remove(1))
        assertTrue(singlyLinkedList.remove(3))
        assertEquals(0, singlyLinkedList.size())
        assertFalse(singlyLinkedList.contains(1))
        assertFalse(singlyLinkedList.contains(3))

        // Trying to remove a non-existent element
        assertFalse(singlyLinkedList.remove(4))
    }

    @Test
    fun testRemoveValueFromHeadAndTail() {
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        // Remove head
        assertTrue(singlyLinkedList.remove(1))
        assertEquals(2, singlyLinkedList.size())
        assertFalse(singlyLinkedList.contains(1))

        // Remove tail
        assertTrue(singlyLinkedList.remove(3))
        assertEquals(1, singlyLinkedList.size())
        assertFalse(singlyLinkedList.contains(3))
    }

    @Test
    fun testContains() {
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)

        assertTrue(singlyLinkedList.contains(1))
        assertTrue(singlyLinkedList.contains(2))
        assertFalse(singlyLinkedList.contains(3))
    }

    @Test
    fun testClear() {
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        singlyLinkedList.clear()
        assertEquals(0, singlyLinkedList.size())
        assertFalse(singlyLinkedList.contains(1))
        assertFalse(singlyLinkedList.contains(2))
        assertFalse(singlyLinkedList.contains(3))
    }

    @Test
    fun testValidate() {
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        assertTrue(singlyLinkedList.validate())

        singlyLinkedList.remove(2)
        assertTrue(singlyLinkedList.validate())

        singlyLinkedList.clear()
        assertTrue(singlyLinkedList.validate())
    }

    @Test
    fun testToString() {
        singlyLinkedList.add(1)
        singlyLinkedList.add(2)
        singlyLinkedList.add(3)

        val expected = "1, 2, 3, "
        assertEquals(expected, singlyLinkedList.toString())
    }

    @Test
    fun testRemoveFromEmptyList() {
        assertFalse(singlyLinkedList.remove(1))
        assertEquals(0, singlyLinkedList.size())
    }

    @Test
    fun testEdgeCases() {
        // Removing from an empty list
        assertFalse(singlyLinkedList.remove(1))

        // Adding and removing single element
        singlyLinkedList.add(10)
        assertTrue(singlyLinkedList.contains(10))
        assertTrue(singlyLinkedList.remove(10))
        assertFalse(singlyLinkedList.contains(10))
        assertEquals(0, singlyLinkedList.size())

        // Removing head
        singlyLinkedList.add(5)
        singlyLinkedList.add(6)
        singlyLinkedList.add(7)
        assertTrue(singlyLinkedList.remove(5))
        assertEquals(2, singlyLinkedList.size())
    }
}