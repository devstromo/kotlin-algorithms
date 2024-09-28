package trees.heaps

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MinHeapUnitTest {

    private lateinit var minHeap: MinHeap<Int>

    @BeforeEach
    fun setUp() {
        minHeap = MinHeap()
    }

    @Test
    fun testInsert() {
        minHeap.insert(10)
        minHeap.insert(20)
        minHeap.insert(5)
        minHeap.insert(30)
        minHeap.insert(2)

        assertEquals(5, minHeap.size())
        assertTrue(minHeap.find(10))
        assertTrue(minHeap.find(20))
        assertTrue(minHeap.find(5))
        assertTrue(minHeap.find(30))
        assertTrue(minHeap.find(2))

        assertFalse(minHeap.find(50))
    }

    @Test
    fun testRemove() {
        minHeap.insert(10)
        minHeap.insert(20)
        minHeap.insert(5)
        minHeap.insert(30)
        minHeap.insert(2)

        assertTrue(minHeap.remove(20))
        assertEquals(4, minHeap.size())
        assertFalse(minHeap.find(20))

        assertTrue(minHeap.remove(2))
        assertEquals(3, minHeap.size())
        assertFalse(minHeap.find(2))

        assertTrue(minHeap.remove(10))
        assertTrue(minHeap.remove(5))
        assertTrue(minHeap.remove(30))
        assertEquals(0, minHeap.size())
    }

    @Test
    fun testFind() {
        minHeap.insert(1)
        minHeap.insert(2)
        minHeap.insert(3)
        assertTrue(minHeap.find(1))
        assertTrue(minHeap.find(2))
        assertTrue(minHeap.find(3))
        assertFalse(minHeap.find(4))
    }

    @Test
    fun testSize() {
        assertEquals(0, minHeap.size())
        minHeap.insert(1)
        minHeap.insert(2)
        assertEquals(2, minHeap.size())
    }

    @Test
    fun testHeight() {
        minHeap.insert(10)
        minHeap.insert(20)
        minHeap.insert(30)
        assertEquals(2, minHeap.height())

        minHeap.insert(5)
        minHeap.insert(2)
        assertEquals(3, minHeap.height())
    }
}