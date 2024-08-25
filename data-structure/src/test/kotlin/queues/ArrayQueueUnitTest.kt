package queues

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ArrayQueueUnitTest {

    @Test
    fun `test offer and poll`() {
        val queue = ArrayQueue<Int>()

        assertTrue(queue.offer(1))
        assertTrue(queue.offer(2))
        assertTrue(queue.offer(3))

        assertEquals(1, queue.poll())
        assertEquals(2, queue.poll())
        assertEquals(3, queue.poll())
        assertNull(queue.poll()) // Queue should be empty
    }

    @Test
    fun `test peek`() {
        val queue = ArrayQueue<Int>()

        assertNull(queue.peek()) // Queue is empty

        queue.offer(1)
        queue.offer(2)

        assertEquals(1, queue.peek()) // Should return the first element
    }

    @Test
    fun `test remove`() {
        val queue = ArrayQueue<Int>()

        queue.offer(1)
        queue.offer(2)
        queue.offer(3)

        assertTrue(queue.remove(2))
        assertFalse(queue.remove(4)) // Element 4 does not exist in the queue

        assertEquals(1, queue.poll())
        assertEquals(3, queue.poll())
        assertNull(queue.poll()) // Queue should be empty
    }

    @Test
    fun `test clear`() {
        val queue = ArrayQueue<Int>()

        queue.offer(1)
        queue.offer(2)
        queue.offer(3)

        queue.clear()

        assertNull(queue.peek()) // Queue should be empty
        assertEquals(0, queue.size()) // Size should be 0
    }

    @Test
    fun `test contains`() {
        val queue = ArrayQueue<Int>()

        queue.offer(1)
        queue.offer(2)

        assertTrue(queue.contains(1))
        assertFalse(queue.contains(3)) // Element 3 does not exist in the queue
    }

    @Test
    fun `test size`() {
        val queue = ArrayQueue<Int>()

        assertEquals(0, queue.size())

        queue.offer(1)
        queue.offer(2)
        queue.offer(3)

        assertEquals(3, queue.size())

        queue.poll()
        assertEquals(2, queue.size())
    }

    @Test
    fun `test validate`() {
        val queue = ArrayQueue<Int>()

        assertTrue(queue.validate()) // Empty queue is valid

        queue.offer(1)
        queue.offer(2)
        queue.offer(3)

        assertTrue(queue.validate()) // Queue should be valid after operations

        queue.poll()
        queue.poll()
        assertTrue(queue.validate()) // Queue should still be valid after some elements are removed
    }

    @Test
    fun `test toString`() {
        val queue = ArrayQueue<Int>()

        queue.offer(1)
        queue.offer(2)
        queue.offer(3)

        assertEquals("3, 2, 1, ", queue.toString())
    }
}