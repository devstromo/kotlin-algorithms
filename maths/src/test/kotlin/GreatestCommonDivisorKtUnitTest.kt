import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GreatestCommonDivisorKtUnitTest {
    @Test
    fun `Test GCD using recursion with positive numbers`() {
        val a = 48L
        val b = 18L
        val expected = 6L
        val result = gcdRecursive(a, b)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using recursion with one number being zero`() {
        val a = 0L
        val b = 18L
        val expected = 18L
        val result = gcdRecursive(a, b)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using recursion with negative numbers`() {
        val a = -48L
        val b = 18L
        val expected = 6L
        val result = gcdRecursive(a, b)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using recursion with both numbers being zero`() {
        val a = 0L
        val b = 0L
        val expected = 0L
        val result = gcdRecursive(a, b)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using recursion with large numbers`() {
        val a = 1234567890L
        val b = 9876543210L
        val expected = 90L
        val result = gcdRecursive(a, b)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using recursion with one negative and one positive number`() {
        val a = -48L
        val b = -18L
        val expected = 6L
        val result = gcdRecursive(a, b)
        assertEquals(expected, result)
    }
}
