package division

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DivisionKtUnitTest {
    @Test
    fun `Test division`() {
        assertEquals(1, division(5, 5))
        assertEquals(1, division(6, 5))
        assertEquals(2, division(10, 5))
        assertEquals(1, division(10, 8))
    }

    @Test
    fun `Test division using loop`() {
        // Positive numbers
        assertEquals(1, divisionWithLoop(5, 5))
        assertEquals(1, divisionWithLoop(6, 5))
        assertEquals(2, divisionWithLoop(10, 5))
        assertEquals(1, divisionWithLoop(10, 8))

        // Negative dividend
        assertEquals(-1, divisionWithLoop(-5, 5))
        assertEquals(-1, divisionWithLoop(-6, 5))
        assertEquals(-2, divisionWithLoop(-10, 5))
        assertEquals(-1, divisionWithLoop(-10, 8))

        // Negative divisor
        assertEquals(-1, divisionWithLoop(5, -5))
        assertEquals(-1, divisionWithLoop(6, -5))
        assertEquals(-2, divisionWithLoop(10, -5))
        assertEquals(-1, divisionWithLoop(10, -8))

        // Both negative
        assertEquals(1, divisionWithLoop(-5, -5))
        assertEquals(1, divisionWithLoop(-6, -5))
        assertEquals(2, divisionWithLoop(-10, -5))
        assertEquals(1, divisionWithLoop(-10, -8))

        // Zero dividend
        assertEquals(0, divisionWithLoop(0, 5))
        assertEquals(0, divisionWithLoop(0, -5))

        // Zero divisor
        assertThrows<IllegalArgumentException> { divisionWithLoop(5, 0) }

        // Large numbers
        assertEquals(5000000000, divisionWithLoop(10000000000, 2))
        assertEquals(2500000000, divisionWithLoop(10000000000, 4))
    }

    @Test
    fun `Test division using recursion`() {
        // Positive numbers
        assertEquals(1, divisionRecursive(5, 5))
        assertEquals(1, divisionRecursive(6, 5))
        assertEquals(2, divisionRecursive(10, 5))
        assertEquals(1, divisionRecursive(10, 8))

        // Negative dividend
        assertEquals(-1, divisionRecursive(-5, 5))
        assertEquals(-1, divisionRecursive(-6, 5))
        assertEquals(-2, divisionRecursive(-10, 5))
        assertEquals(-1, divisionRecursive(-10, 8))

        // Negative divisor
        assertEquals(-1, divisionRecursive(5, -5))
        assertEquals(-1, divisionRecursive(6, -5))
        assertEquals(-2, divisionRecursive(10, -5))
        assertEquals(-1, divisionRecursive(10, -8))

        // Both negative
        assertEquals(1, divisionRecursive(-5, -5))
        assertEquals(1, divisionRecursive(-6, -5))
        assertEquals(2, divisionRecursive(-10, -5))
        assertEquals(1, divisionRecursive(-10, -8))

        // Zero dividend
        assertEquals(0, divisionRecursive(0, 5))
        assertEquals(0, divisionRecursive(0, -5))

        // Zero divisor
        assertThrows<IllegalArgumentException> { divisionRecursive(5, 0) }
    }

    @Test
    fun `Test division using multiplication`() {
        // Positive numbers
        assertEquals(1, divisionUsingMultiplication(5, 5))
        assertEquals(1, divisionUsingMultiplication(6, 5))
        assertEquals(2, divisionUsingMultiplication(10, 5))
        assertEquals(1, divisionUsingMultiplication(10, 8))

        // Negative dividend
        assertEquals(-1, divisionUsingMultiplication(-5, 5))
        assertEquals(-1, divisionUsingMultiplication(-6, 5))
        assertEquals(-2, divisionUsingMultiplication(-10, 5))
        assertEquals(-1, divisionUsingMultiplication(-10, 8))

        // Negative divisor
        assertEquals(-1, divisionUsingMultiplication(5, -5))
        assertEquals(-1, divisionUsingMultiplication(6, -5))
        assertEquals(-2, divisionUsingMultiplication(10, -5))
        assertEquals(-1, divisionUsingMultiplication(10, -8))

        // Both negative
        assertEquals(1, divisionUsingMultiplication(-5, -5))
        assertEquals(1, divisionUsingMultiplication(-6, -5))
        assertEquals(2, divisionUsingMultiplication(-10, -5))
        assertEquals(1, divisionUsingMultiplication(-10, -8))

        // Zero dividend
        assertEquals(0, divisionUsingMultiplication(0, 5))
        assertEquals(0, divisionUsingMultiplication(0, -5))

        // Zero divisor
        assertThrows<IllegalArgumentException> { divisionUsingMultiplication(5, 0) }
    }


    @Test
    fun `Test division using shift`() {
        // Positive numbers
        assertEquals(1, divisionUsingShift(5, 5))
        assertEquals(1, divisionUsingShift(6, 5))
        assertEquals(2, divisionUsingShift(10, 5))
        assertEquals(1, divisionUsingShift(10, 8))

        // Negative dividend
        assertEquals(-1, divisionUsingShift(-5, 5))
        assertEquals(-1, divisionUsingShift(-6, 5))
        assertEquals(-2, divisionUsingShift(-10, 5))
        assertEquals(-1, divisionUsingShift(-10, 8))

        // Negative divisor
        assertEquals(-1, divisionUsingShift(5, -5))
        assertEquals(-1, divisionUsingShift(6, -5))
        assertEquals(-2, divisionUsingShift(10, -5))
        assertEquals(-1, divisionUsingShift(10, -8))

        // Both negative
        assertEquals(1, divisionUsingShift(-5, -5))
        assertEquals(1, divisionUsingShift(-6, -5))
        assertEquals(2, divisionUsingShift(-10, -5))
        assertEquals(1, divisionUsingShift(-10, -8))

        // Zero dividend
        assertEquals(0, divisionUsingShift(0, 5))
        assertEquals(0, divisionUsingShift(0, -5))

        // Zero divisor
        assertThrows<IllegalArgumentException> { divisionUsingShift(5, 0) }

    }
}