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

    @Test
    fun `Test fast exponentiation with modulo`() {
        // Positive exponent
        assertEquals(1, solution.fastRecursiveModulo(2, 0, 1000))
        assertEquals(2, solution.fastRecursiveModulo(2, 1, 1000))
        assertEquals(4, solution.fastRecursiveModulo(2, 2, 1000))
        assertEquals(8, solution.fastRecursiveModulo(2, 3, 1000))
        assertEquals(16, solution.fastRecursiveModulo(2, 4, 1000))

        // Negative base
        assertEquals(1, solution.fastRecursiveModulo(-2, 0, 1000))
        assertEquals(-2 % 1000, solution.fastRecursiveModulo(-2, 1, 1000))
        assertEquals(4, solution.fastRecursiveModulo(-2, 2, 1000))
        assertEquals(-8 % 1000, solution.fastRecursiveModulo(-2, 3, 1000))
        assertEquals(16, solution.fastRecursiveModulo(-2, 4, 1000))

        // Larger numbers
        assertEquals(24, solution.fastRecursiveModulo(2, 10, 1000))
        assertEquals(49, solution.fastRecursiveModulo(3, 10, 1000))
        assertEquals(0, solution.fastRecursiveModulo(10, 9, 10))

        // One as base
        assertEquals(1, solution.fastRecursiveModulo(1, 100, 1000))
        assertEquals(1, solution.fastRecursiveModulo(1, 0, 1000))
        assertEquals(1, solution.fastRecursiveModulo(1, 1, 1000))

        // Zero as base
        assertEquals(0, solution.fastRecursiveModulo(0, 1, 1000))
        assertEquals(0, solution.fastRecursiveModulo(0, 5, 1000))
        assertEquals(0, solution.fastRecursiveModulo(0, 100, 1000))
    }

    @Test
    fun `Test iterative exponentiation`() {
        // Positive exponent
        assertEquals(1, solution.iterative(2, 0))
        assertEquals(2, solution.iterative(2, 1))
        assertEquals(4, solution.iterative(2, 2))
        assertEquals(8, solution.iterative(2, 3))
        assertEquals(16, solution.iterative(2, 4))

        // Negative base
        assertEquals(1, solution.iterative(-2, 0))
        assertEquals(-2, solution.iterative(-2, 1))
        assertEquals(4, solution.iterative(-2, 2))
        assertEquals(-8, solution.iterative(-2, 3))
        assertEquals(16, solution.iterative(-2, 4))

        // Larger numbers
        assertEquals(1024, solution.iterative(2, 10))
        assertEquals(59049, solution.iterative(3, 10))
        assertEquals(1000000000, solution.iterative(10, 9))

        // One as base
        assertEquals(1, solution.iterative(1, 100))
        assertEquals(1, solution.iterative(1, 0))
        assertEquals(1, solution.iterative(1, 1))

        // Zero as base
        assertEquals(0, solution.iterative(0, 1))
        assertEquals(0, solution.iterative(0, 5))
        assertEquals(0, solution.iterative(0, 100))
    }

    @Test
    fun `Test exponentiation by squaring iterative`() {
        // Positive exponent
        assertEquals(1, solution.exponentiationBySquaringIterative(2, 0))
        assertEquals(2, solution.exponentiationBySquaringIterative(2, 1))
        assertEquals(4, solution.exponentiationBySquaringIterative(2, 2))
        assertEquals(8, solution.exponentiationBySquaringIterative(2, 3))
        assertEquals(16, solution.exponentiationBySquaringIterative(2, 4))

        // Negative base
        assertEquals(1, solution.exponentiationBySquaringIterative(-2, 0))
        assertEquals(-2, solution.exponentiationBySquaringIterative(-2, 1))
        assertEquals(4, solution.exponentiationBySquaringIterative(-2, 2))
        assertEquals(-8, solution.exponentiationBySquaringIterative(-2, 3))
        assertEquals(16, solution.exponentiationBySquaringIterative(-2, 4))

        // Larger numbers
        assertEquals(1024, solution.exponentiationBySquaringIterative(2, 10))
        assertEquals(59049, solution.exponentiationBySquaringIterative(3, 10))
        assertEquals(1000000000, solution.exponentiationBySquaringIterative(10, 9))

        // One as base
        assertEquals(1, solution.exponentiationBySquaringIterative(1, 100))
        assertEquals(1, solution.exponentiationBySquaringIterative(1, 0))
        assertEquals(1, solution.exponentiationBySquaringIterative(1, 1))

        // Zero as base
        assertEquals(0, solution.exponentiationBySquaringIterative(0, 1))
        assertEquals(0, solution.exponentiationBySquaringIterative(0, 5))
        assertEquals(0, solution.exponentiationBySquaringIterative(0, 100))
    }
}