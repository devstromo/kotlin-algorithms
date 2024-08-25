package stacks

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LinkedStackUnitTest {

    private lateinit var stack: LinkedStack<Int>

    @BeforeEach
    fun setUp() {
        stack = LinkedStack()
    }

    @Test
    fun `test push and pop`() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertEquals(3, stack.pop())
        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())
        assertThrows(NoSuchElementException::class.java) { stack.pop() }
    }

    @Test
    fun `test peek`() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertEquals(3, stack.peek())
        stack.pop()
        assertEquals(2, stack.peek())
        stack.pop()
        assertEquals(1, stack.peek())
        stack.pop()
        assertThrows(NoSuchElementException::class.java) { stack.peek() }
    }

    @Test
    fun `test remove`() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertTrue(stack.remove(2))
        assertFalse(stack.remove(4))
        assertEquals(listOf(3, 1), stack.toCollection())
    }

    @Test
    fun `test contains`() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertTrue(stack.contains(2))
        assertFalse(stack.contains(4))
    }

    @Test
    fun `test clear`() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        stack.clear()
        assertEquals(0, stack.size())
        assertFalse(stack.contains(1))
        assertFalse(stack.contains(2))
        assertFalse(stack.contains(3))
    }

    @Test
    fun `test size`() {
        assertEquals(0, stack.size())

        stack.push(1)
        stack.push(2)
        stack.push(3)
        assertEquals(3, stack.size())

        stack.pop()
        assertEquals(2, stack.size())
    }

    @Test
    fun `test validate`() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertTrue(stack.validate())

        stack.pop()
        assertTrue(stack.validate())

        stack.clear()
        assertTrue(stack.validate())
    }

    @Test
    fun `test toCollection`() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        val collection = stack.toCollection()
        assertEquals(listOf(3, 2, 1), collection)
    }

    @Test
    fun `test toString`() {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        assertEquals("3, 2, 1, ", stack.toString())
    }
}