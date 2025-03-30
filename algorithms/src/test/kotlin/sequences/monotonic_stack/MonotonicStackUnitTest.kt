package sequences.monotonic_stack

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MonotonicStackUnitTest {
    private val solution = MonotonicStack()

    @Test
    fun `Test next greater for general input`() {
        val input = intArrayOf(2, 1, 2, 4, 3)
        val expected = intArrayOf(4, 2, 4, -1, -1)
        assertArrayEquals(expected, solution.monotonicStack(input))
    }

    @Test
    fun `Test next greater when all decreasing`() {
        val input = intArrayOf(5, 4, 3, 2, 1)
        val expected = intArrayOf(-1, -1, -1, -1, -1)
        assertArrayEquals(expected, solution.monotonicStack(input))
    }

    @Test
    fun `Test next greater when all increasing`() {
        val input = intArrayOf(1, 2, 3, 4, 5)
        val expected = intArrayOf(2, 3, 4, 5, -1)
        assertArrayEquals(expected, solution.monotonicStack(input))
    }

    @Test
    fun `Test next greater with same elements`() {
        val input = intArrayOf(3, 3, 3, 3)
        val expected = intArrayOf(-1, -1, -1, -1)
        assertArrayEquals(expected, solution.monotonicStack(input))
    }

    @Test
    fun `Test next greater with single element`() {
        val input = intArrayOf(1)
        val expected = intArrayOf(-1)
        assertArrayEquals(expected, solution.monotonicStack(input))
    }

    @Test
    fun `Test next greater with empty array`() {
        val input = intArrayOf()
        val expected = intArrayOf()
        assertArrayEquals(expected, solution.monotonicStack(input))
    }
}