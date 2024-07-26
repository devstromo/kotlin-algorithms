package gcd

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


    @Test
    fun `Test GCD using Euclid's algorithm with positive numbers`() {
        val x = 48L
        val y = 18L
        val expected = 6L
        val result = gcdEuclides(x, y)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using Euclid's algorithm with one number being zero`() {
        val x = 0L
        val y = 18L
        val expected = 18L
        val result = gcdEuclides(x, y)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using Euclid's algorithm with negative numbers`() {
        val x = -48L
        val y = 18L
        val expected = 6L
        val result = gcdEuclides(x, y)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using Euclid's algorithm with both numbers being zero`() {
        val x = 0L
        val y = 0L
        val expected = 0L
        val result = gcdEuclides(x, y)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using Euclid's algorithm with large numbers`() {
        val x = 1234567890L
        val y = 9876543210L
        val expected = 90L
        val result = gcdEuclides(x, y)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using Euclid's algorithm with one negative and one positive number`() {
        val x = -48L
        val y = -18L
        val expected = 6L
        val result = gcdEuclides(x, y)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using Binary GCD algorithm with positive numbers`() {
        val x = 48L
        val y = 18L
        val expected = 6L
        val result = gcdUsingBinaryAlgorithm(x, y)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using Binary GCD algorithm with one number being zero`() {
        val x = 0L
        val y = 18L
        val expected = 18L
        val result = gcdUsingBinaryAlgorithm(x, y)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using Binary GCD algorithm with negative numbers`() {
        val x = -48L
        val y = 18L
        val expected = 6L
        val result = gcdUsingBinaryAlgorithm(x, y)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using Binary GCD algorithm with both numbers being zero`() {
        val x = 0L
        val y = 0L
        val expected = 0L
        val result = gcdUsingBinaryAlgorithm(x, y)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using Binary GCD algorithm with large numbers`() {
        val x = 1234567890L
        val y = 9876543210L
        val expected = 90L
        val result = gcdUsingBinaryAlgorithm(x, y)
        assertEquals(expected, result)
    }

    @Test
    fun `Test GCD using Binary GCD algorithm with one negative and one positive number`() {
        val x = -48L
        val y = -18L
        val expected = 6L
        val result = gcdUsingBinaryAlgorithm(x, y)
        assertEquals(expected, result)
    }
}
