package queues

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LinkedQueueUnitTest {
    private lateinit var queue: LinkedQueue<Int>

    @BeforeEach
    fun setUp() {
        queue = LinkedQueue()
    }

    @Test
    fun `Test offer and size`() {
        assertTrue(queue.offer(1))
        assertTrue(queue.offer(2))
        assertTrue(queue.offer(3))
        assertEquals(3, queue.size())
    }

    @Test
    fun `Test poll from empty queue`() {
        assertNull(queue.poll())
    }

    @Test
    fun `Test offer and poll`() {
        queue.offer(1)
        queue.offer(2)
        queue.offer(3)
        assertEquals(1, queue.poll())
        assertEquals(2, queue.poll())
        assertEquals(3, queue.poll())
        assertNull(queue.poll())
    }

    @Test
    fun `Test peek`() {
        queue.offer(1)
        queue.offer(2)
        queue.offer(3)
        assertEquals(1, queue.peek())
        assertEquals(1, queue.peek()) // Peek should not remove the element
        assertEquals(3, queue.size()) // Size should remain the same
    }

    @Test
    fun `Test remove existing element`() {
        queue.offer(1)
        queue.offer(2)
        queue.offer(3)
        assertTrue(queue.remove(2))
        assertFalse(queue.contains(2))
        assertEquals(2, queue.size())
    }

    @Test
    fun `Test remove non-existing element`() {
        queue.offer(1)
        queue.offer(2)
        queue.offer(3)
        assertFalse(queue.remove(4))
        assertEquals(3, queue.size())
    }

    @Test
    fun `Test clear`() {
        queue.offer(1)
        queue.offer(2)
        queue.offer(3)
        queue.clear()
        assertEquals(0, queue.size())
        assertNull(queue.peek())
    }

    @Test
    fun `Test contains`() {
        queue.offer(1)
        queue.offer(2)
        queue.offer(3)
        assertTrue(queue.contains(2))
        assertFalse(queue.contains(4))
    }

    @Test
    fun `Test validate`() {
        queue.offer(1)
        queue.offer(2)
        queue.offer(3)
        assertTrue(queue.validate())
        queue.remove(2)
        assertTrue(queue.validate())
    }

    @Test
    fun `Test poll until empty`() {
        queue.offer(1)
        queue.offer(2)
        queue.offer(3)
        queue.poll()
        queue.poll()
        queue.poll()
        assertNull(queue.poll())
        assertEquals(0, queue.size())
    }

    @Test
    fun `Test offer null value`() {
        val queueWithNulls = LinkedQueue<Int?>()
        assertTrue(queueWithNulls.offer(null))
        assertTrue(queueWithNulls.offer(1))
        assertEquals(null, queueWithNulls.poll())
        assertEquals(1, queueWithNulls.poll())
    }
}