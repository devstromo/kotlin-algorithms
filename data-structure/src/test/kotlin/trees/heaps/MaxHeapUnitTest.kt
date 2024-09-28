package trees.heaps

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MaxHeapUnitTest {

    private lateinit var maxHeap: MaxHeap<Int>

    @BeforeEach
    fun setUp() {
        maxHeap = MaxHeap()
    }

    @Test
    fun testInsert() {
        maxHeap.insert(10)
        maxHeap.insert(20)
        maxHeap.insert(5)
        maxHeap.insert(30)
        maxHeap.insert(2)

        assertEquals(5, maxHeap.size())
        assertTrue(maxHeap.find(10))
        assertTrue(maxHeap.find(20))
        assertTrue(maxHeap.find(5))
        assertTrue(maxHeap.find(30))
        assertTrue(maxHeap.find(2))

        assertFalse(maxHeap.find(50))
    }

    @Test
    fun testRemove() {
        maxHeap.insert(10)
        maxHeap.insert(20)
        maxHeap.insert(5)
        maxHeap.insert(30)
        maxHeap.insert(2)

        assertTrue(maxHeap.remove(20))
        assertEquals(4, maxHeap.size())
        assertFalse(maxHeap.find(20))

        assertTrue(maxHeap.remove(2))
        assertEquals(3, maxHeap.size())
        assertFalse(maxHeap.find(2))

        assertTrue(maxHeap.remove(10))
        assertTrue(maxHeap.remove(5))
        assertTrue(maxHeap.remove(30))
        assertEquals(0, maxHeap.size())
    }

    @Test
    fun testFind() {
        maxHeap.insert(1)
        maxHeap.insert(2)
        maxHeap.insert(3)
        assertTrue(maxHeap.find(1))
        assertTrue(maxHeap.find(2))
        assertTrue(maxHeap.find(3))
        assertFalse(maxHeap.find(4))
    }

    @Test
    fun testSize() {
        assertEquals(0, maxHeap.size())
        maxHeap.insert(1)
        maxHeap.insert(2)
        assertEquals(2, maxHeap.size())
    }

    @Test
    fun testHeight() {
        maxHeap.insert(10)
        maxHeap.insert(20)
        maxHeap.insert(30)
        assertEquals(2, maxHeap.height())

        maxHeap.insert(5)
        maxHeap.insert(2)
        assertEquals(3, maxHeap.height())
    }

}