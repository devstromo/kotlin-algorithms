package primes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PrimesKtUnitTest {

    @Test
    fun `Test IsPrime using classical approach`() {
        assertTrue(isPrimeClassic(2))
        assertTrue(isPrimeClassic(3))
        assertTrue(isPrimeClassic(5))
        assertTrue(isPrimeClassic(7))
        assertTrue(isPrimeClassic(11))
        assertTrue(isPrimeClassic(13))
        assertTrue(isPrimeClassic(17))
        assertTrue(isPrimeClassic(19))
        assertTrue(isPrimeClassic(23))
        assertTrue(isPrimeClassic(29))
        assertTrue(isPrimeClassic(31))

        assertFalse(isPrimeClassic(0))
        assertFalse(isPrimeClassic(1))
        assertFalse(isPrimeClassic(4))
        assertFalse(isPrimeClassic(6))
        assertFalse(isPrimeClassic(8))
        assertFalse(isPrimeClassic(9))
        assertFalse(isPrimeClassic(10))
        assertFalse(isPrimeClassic(12))
        assertFalse(isPrimeClassic(14))
        assertFalse(isPrimeClassic(15))
        assertFalse(isPrimeClassic(16))
        assertFalse(isPrimeClassic(18))
        assertFalse(isPrimeClassic(20))
        assertFalse(isPrimeClassic(21))
        assertFalse(isPrimeClassic(22))
        assertFalse(isPrimeClassic(24))
        assertFalse(isPrimeClassic(25))

        assertFalse(isPrimeClassic(-1))
    }

    @Test
    fun `Test IsPrime using the Sieve of Eratosthenes`() {
        assertTrue(isPrimeSieve(2))
        assertTrue(isPrimeSieve(3))
        assertTrue(isPrimeSieve(5))
        assertTrue(isPrimeSieve(7))
        assertTrue(isPrimeSieve(11))
        assertTrue(isPrimeSieve(13))
        assertTrue(isPrimeSieve(17))
        assertTrue(isPrimeSieve(19))
        assertTrue(isPrimeSieve(23))
        assertTrue(isPrimeSieve(29))
        assertTrue(isPrimeSieve(31))

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

        assertFalse(isPrimeSieve(-1))
    }
}