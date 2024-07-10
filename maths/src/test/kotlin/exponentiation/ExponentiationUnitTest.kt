package exponentiation

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ExponentiationUnitTest {
    private val solution = Exponentiation()

    @Test
    fun `Test exponentiation with positive exponent`() {
        assertEquals(1, solution.recursive(2, 0))
        assertEquals(2, solution.recursive(2, 1))
        assertEquals(4, solution.recursive(2, 2))
        assertEquals(8, solution.recursive(2, 3))
        assertEquals(16, solution.recursive(2, 4))
        assertEquals(1, solution.recursive(-2, 0))
        assertEquals(-2, solution.recursive(-2, 1))
        assertEquals(4, solution.recursive(-2, 2))
        assertEquals(-8, solution.recursive(-2, 3))
        assertEquals(16, solution.recursive(-2, 4))
        assertEquals(1024, solution.recursive(2, 10))
        assertEquals(59049, solution.recursive(3, 10))
        assertEquals(1000000000, solution.recursive(10, 9))
        assertEquals(1, solution.recursive(1, 100))
        assertEquals(1, solution.recursive(1, 0))
        assertEquals(1, solution.recursive(1, 1))
        assertEquals(0, solution.recursive(0, 1))
        assertEquals(0, solution.recursive(0, 5))
        assertEquals(0, solution.recursive(0, 100))
    }

    @Test
    fun `Test fast exponentiation`() {
        // Positive exponent
        assertEquals(1, solution.fastRecursive(2, 0))
        assertEquals(2, solution.fastRecursive(2, 1))
        assertEquals(4, solution.fastRecursive(2, 2))
        assertEquals(8, solution.fastRecursive(2, 3))
        assertEquals(16, solution.fastRecursive(2, 4))

        // Negative base
        assertEquals(1, solution.fastRecursive(-2, 0))
        assertEquals(-2, solution.fastRecursive(-2, 1))
        assertEquals(4, solution.fastRecursive(-2, 2))
        assertEquals(-8, solution.fastRecursive(-2, 3))
        assertEquals(16, solution.fastRecursive(-2, 4))

        // Larger numbers
        assertEquals(1024, solution.fastRecursive(2, 10))
        assertEquals(59049, solution.fastRecursive(3, 10))
        assertEquals(1000000000, solution.fastRecursive(10, 9))

        // One as base
        assertEquals(1, solution.fastRecursive(1, 100))
        assertEquals(1, solution.fastRecursive(1, 0))
        assertEquals(1, solution.fastRecursive(1, 1))

        // Zero as base
        assertEquals(0, solution.fastRecursive(0, 1))
        assertEquals(0, solution.fastRecursive(0, 5))
        assertEquals(0, solution.fastRecursive(0, 100))
    }
}