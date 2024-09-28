package lists

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SkipListUnitTest {
    private lateinit var skipList: SkipList<Int>

    @BeforeEach
    fun setUp() {
        skipList = SkipList()
    }

    @Test
    fun testAdd() {
        assertTrue(skipList.add(5))
        assertTrue(skipList.add(10))
        assertTrue(skipList.add(3))
        assertTrue(skipList.add(7))

        assertEquals(4, skipList.size())
        assertTrue(skipList.contains(5))
        assertTrue(skipList.contains(10))
        assertTrue(skipList.contains(3))
        assertTrue(skipList.contains(7))
    }

    @Test
    fun testRemove() {
        skipList.add(5)
        skipList.add(10)
        skipList.add(3)
        skipList.add(7)

        assertTrue(skipList.remove(5))
        assertEquals(3, skipList.size())
        assertFalse(skipList.contains(5))

        assertTrue(skipList.remove(10))
        assertTrue(skipList.remove(3))
        assertTrue(skipList.remove(7))
        assertEquals(0, skipList.size())
        assertFalse(skipList.contains(10))
        assertFalse(skipList.contains(3))
        assertFalse(skipList.contains(7))
    }

    @Test
    fun testContains() {
        skipList.add(1)
        skipList.add(2)
        skipList.add(3)
        assertTrue(skipList.contains(1))
        assertTrue(skipList.contains(2))
        assertTrue(skipList.contains(3))
        assertFalse(skipList.contains(4))
    }

    @Test
    fun testSize() {
        assertEquals(0, skipList.size())
        skipList.add(1)
        skipList.add(2)
        assertEquals(2, skipList.size())
    }

    @Test
    fun testClear() {
        skipList.add(1)
        skipList.add(2)
        skipList.add(3)
        skipList.clear()
        assertEquals(0, skipList.size())
        assertFalse(skipList.contains(1))
        assertFalse(skipList.contains(2))
        assertFalse(skipList.contains(3))
    }

    @Test
    fun testValidate() {
        skipList.add(10)
        skipList.add(20)
        skipList.add(30)
        assertTrue(skipList.validate())

        skipList.add(25)
        skipList.remove(20)
        assertTrue(skipList.validate())
    }
}