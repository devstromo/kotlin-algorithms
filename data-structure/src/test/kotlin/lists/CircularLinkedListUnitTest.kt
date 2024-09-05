package lists

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CircularLinkedListUnitTest {
    private lateinit var circularLinkedList: CircularLinkedList<Int>

    @BeforeEach
    fun setUp() {
        circularLinkedList = CircularLinkedList()
    }

    @Test
    fun testAdd() {
        assertTrue(circularLinkedList.add(1))
        assertTrue(circularLinkedList.add(2))
        assertTrue(circularLinkedList.add(3))
        assertEquals(3, circularLinkedList.size())
        assertTrue(circularLinkedList.contains(1))
        assertTrue(circularLinkedList.contains(2))
        assertTrue(circularLinkedList.contains(3))
    }

    @Test
    fun testRemove() {
        circularLinkedList.add(1)
        circularLinkedList.add(2)
        circularLinkedList.add(3)

        assertTrue(circularLinkedList.remove(2))
        assertEquals(2, circularLinkedList.size())
        assertFalse(circularLinkedList.contains(2))

        assertTrue(circularLinkedList.remove(1))
        assertTrue(circularLinkedList.remove(3))
        assertEquals(0, circularLinkedList.size())
        assertFalse(circularLinkedList.contains(1))
        assertFalse(circularLinkedList.contains(3))
    }

    @Test
    fun testRemoveHead() {
        circularLinkedList.add(1)
        circularLinkedList.add(2)
        circularLinkedList.add(3)

        assertTrue(circularLinkedList.remove(1)) // Remove head
        assertEquals(2, circularLinkedList.size())
        assertFalse(circularLinkedList.contains(1))
        assertTrue(circularLinkedList.contains(2))
        assertTrue(circularLinkedList.contains(3))
    }

    @Test
    fun testRemoveTail() {
        circularLinkedList.add(1)
        circularLinkedList.add(2)
        circularLinkedList.add(3)

        assertTrue(circularLinkedList.remove(3)) // Remove tail
        assertEquals(2, circularLinkedList.size())
        assertFalse(circularLinkedList.contains(3))
        assertTrue(circularLinkedList.contains(1))
        assertTrue(circularLinkedList.contains(2))
    }

    @Test
    fun testClear() {
        circularLinkedList.add(1)
        circularLinkedList.add(2)
        circularLinkedList.add(3)

        circularLinkedList.clear()
        assertEquals(0, circularLinkedList.size())
        assertFalse(circularLinkedList.contains(1))
        assertFalse(circularLinkedList.contains(2))
        assertFalse(circularLinkedList.contains(3))
    }

    @Test
    fun testContains() {
        circularLinkedList.add(1)
        circularLinkedList.add(2)
        circularLinkedList.add(3)

        assertTrue(circularLinkedList.contains(1))
        assertTrue(circularLinkedList.contains(2))
        assertTrue(circularLinkedList.contains(3))
        assertFalse(circularLinkedList.contains(4))
    }

    @Test
    fun testSize() {
        assertEquals(0, circularLinkedList.size())

        circularLinkedList.add(1)
        assertEquals(1, circularLinkedList.size())

        circularLinkedList.add(2)
        assertEquals(2, circularLinkedList.size())

        circularLinkedList.remove(1)
        assertEquals(1, circularLinkedList.size())
    }

    @Test
    fun testValidate() {
        // Empty list
        assertTrue(circularLinkedList.validate())

        // Add elements
        circularLinkedList.add(1)
        circularLinkedList.add(2)
        circularLinkedList.add(3)

        assertTrue(circularLinkedList.validate())

        // Remove elements and check validation
        circularLinkedList.remove(2)
        assertTrue(circularLinkedList.validate())

        circularLinkedList.clear()
        assertTrue(circularLinkedList.validate())
    }

    @Test
    fun testRemoveFromEmptyList() {
        assertFalse(circularLinkedList.remove(1))
        assertEquals(0, circularLinkedList.size())
    }

    @Test
    fun testToString() {
        circularLinkedList.add(1)
        circularLinkedList.add(2)
        circularLinkedList.add(3)

        val expected = "[1, 2, 3]"
        assertEquals(expected, circularLinkedList.toString())
    }
}