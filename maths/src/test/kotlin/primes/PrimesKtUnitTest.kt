package primes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PrimesKtUnitTest {

    @Test
    fun testIsPrime() {
        // Known primes
        assertTrue(isPrimeSieve(2), "2 should be prime")
        assertTrue(isPrimeSieve(3), "3 should be prime")
        assertTrue(isPrimeSieve(5), "5 should be prime")
        assertTrue(isPrimeSieve(7), "7 should be prime")
        assertTrue(isPrimeSieve(11), "11 should be prime")
        assertTrue(isPrimeSieve(13), "13 should be prime")
        assertTrue(isPrimeSieve(17), "17 should be prime")
        assertTrue(isPrimeSieve(19), "19 should be prime")
        assertTrue(isPrimeSieve(23), "23 should be prime")
        assertTrue(isPrimeSieve(29), "29 should be prime")
        assertTrue(isPrimeSieve(31), "31 should be prime")

        // Known non-primes
        assertFalse(isPrimeSieve(0))
        assertFalse(isPrimeSieve(1))
        assertFalse(isPrimeSieve(4))
        assertFalse(isPrimeSieve(6))
        assertFalse(isPrimeSieve(8))
        assertFalse(isPrimeSieve(9))
        assertFalse(isPrimeSieve(10))
        assertFalse(isPrimeSieve(12))
        assertFalse(isPrimeSieve(14))
        assertFalse(isPrimeSieve(15))
        assertFalse(isPrimeSieve(16))
        assertFalse(isPrimeSieve(18))
        assertFalse(isPrimeSieve(20))
        assertFalse(isPrimeSieve(21))
        assertFalse(isPrimeSieve(22))
        assertFalse(isPrimeSieve(24))
        assertFalse(isPrimeSieve(25))

        // Edge cases
        assertFalse(isPrimeSieve(-1))
    }
}