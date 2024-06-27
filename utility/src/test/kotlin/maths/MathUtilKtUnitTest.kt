package maths

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MathUtilKtUnitTest {
    @Test
    fun `Test power mod function`() {
        assertEquals(1L, power(2, 0, 1000))
        assertEquals(2L, power(2, 1, 1000))
        assertEquals(4L, power(2, 2, 1000))
        assertEquals(8L, power(2, 3, 1000))
        assertEquals(16L, power(2, 4, 1000))
        assertEquals(9765625L, power(5, 10, 1000000007))
        assertEquals(1024L, power(2, 10, 1000000007))
        assertEquals(1L, power(1000, 0, 1000000007))
        assertEquals(4L, power(2, 10, 6))
        assertEquals(3L, power(3, 7, 4))
        assertEquals(1L, power(2, 20, 3))
        assertEquals(0L, power(0, 10, 1000))
        assertEquals(1L, power(1000, 0, 1000))
        assertEquals(1L, power(0, 0, 1000))
    }


    @Test
    fun `Test Gcd`() {
        assertEquals(1, gcd(1, 1))
        assertEquals(1, gcd(2, 3))
        assertEquals(2, gcd(4, 2))
        assertEquals(3, gcd(9, 6))
        assertEquals(5, gcd(10, 5))
        assertEquals(1, gcd(-2, 3))
        assertEquals(2, gcd(4, -2))
        assertEquals(3, gcd(-9, 6))
        assertEquals(5, gcd(10, -5))
        assertEquals(10, gcd(10, 0))
        assertEquals(10, gcd(0, 10))
        assertEquals(0, gcd(0, 0))
        assertEquals(1000000, gcd(1000000, 0))
        assertEquals(500000, gcd(1000000, 500000))
        assertEquals(1, gcd(1234567, 890123))
    }
}