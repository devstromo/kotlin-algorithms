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
}