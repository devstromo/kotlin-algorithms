package stacks

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ArrayStackUnitTest {
    @Test
    fun `Test Push and Peek`() {
        val stack = ArrayStack<Int>()
        stack.push(1)
        stack.push(2)
        assertEquals(2, stack.peek())
    }

    @Test
    fun `Test Pop and Size`() {
        val stack = ArrayStack<Int>()
        stack.push(1)
        stack.push(2)
        assertEquals(2, stack.pop())
        assertEquals(1, stack.size())
    }

    @Test
    fun `Test Pop Empty Stack`() {
        val stack = ArrayStack<Int>()
        assertThrows(NoSuchElementException::class.java) { stack.pop() }
    }

    @Test
    fun `Test Peek Empty Stack`() {
        val stack = ArrayStack<Int>()
        assertThrows(NoSuchElementException::class.java) { stack.peek() }
    }

    @Test
    fun `Test Remove Element`() {
        val stack = ArrayStack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)
        assertTrue(stack.remove(2))
        assertFalse(stack.remove(4))
        assertEquals(2, stack.size())
    }

    @Test
    fun `Test Clear Stack`() {
        val stack = ArrayStack<Int>()
        stack.push(1)
        stack.push(2)
        stack.clear()
        assertEquals(0, stack.size())
        assertThrows(NoSuchElementException::class.java) { stack.peek() }
    }

    @Test
    fun `Test Contains`() {
        val stack = ArrayStack<Int>()
        stack.push(1)
        stack.push(2)
        assertTrue(stack.contains(1))
        assertFalse(stack.contains(3))
    }

    @Test
    fun `Test ToCollection`() {
        val stack = ArrayStack<Int>()
        stack.push(1)
        stack.push(2)
        stack.push(3)

        val collection = stack.toCollection()
        val expected = setOf(1, 2, 3)

        assertEquals(expected, collection.toSet())
    }

    @Test
    fun `Test ToString`() {
        val stack = ArrayStack<Int>()
        stack.push(1)
        stack.push(2)
        assertEquals("2, 1, ", stack.toString())
    }
}