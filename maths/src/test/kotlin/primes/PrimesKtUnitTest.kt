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
    fun `Test IsPrime using optimized classical approach`() {
        assertTrue(isPrimeOptimized(2))
        assertTrue(isPrimeOptimized(3))
        assertTrue(isPrimeOptimized(5))
        assertTrue(isPrimeOptimized(7))
        assertTrue(isPrimeOptimized(11))
        assertTrue(isPrimeOptimized(13))
        assertTrue(isPrimeOptimized(17))
        assertTrue(isPrimeOptimized(19))
        assertTrue(isPrimeOptimized(23))
        assertTrue(isPrimeOptimized(29))
        assertTrue(isPrimeOptimized(31))

        assertFalse(isPrimeOptimized(0))
        assertFalse(isPrimeOptimized(1))
        assertFalse(isPrimeOptimized(4))
        assertFalse(isPrimeOptimized(6))
        assertFalse(isPrimeOptimized(8))
        assertFalse(isPrimeOptimized(9))
        assertFalse(isPrimeOptimized(10))
        assertFalse(isPrimeOptimized(12))
        assertFalse(isPrimeOptimized(14))
        assertFalse(isPrimeOptimized(15))
        assertFalse(isPrimeOptimized(16))
        assertFalse(isPrimeOptimized(18))
        assertFalse(isPrimeOptimized(20))
        assertFalse(isPrimeOptimized(21))
        assertFalse(isPrimeOptimized(22))
        assertFalse(isPrimeOptimized(24))
        assertFalse(isPrimeOptimized(25))

        assertFalse(isPrimeOptimized(-1))
    }

    @Test
    fun `Test IsPrime using 6n+1 or 6n-1 approach`() {
        assertTrue(isPrimeOptimizedSecondApproach(2))
        assertTrue(isPrimeOptimizedSecondApproach(3))
        assertTrue(isPrimeOptimizedSecondApproach(5))
        assertTrue(isPrimeOptimizedSecondApproach(7))
        assertTrue(isPrimeOptimizedSecondApproach(11))
        assertTrue(isPrimeOptimizedSecondApproach(13))
        assertTrue(isPrimeOptimizedSecondApproach(17))
        assertTrue(isPrimeOptimizedSecondApproach(19))
        assertTrue(isPrimeOptimizedSecondApproach(23))
        assertTrue(isPrimeOptimizedSecondApproach(29))
        assertTrue(isPrimeOptimizedSecondApproach(31))

        assertFalse(isPrimeOptimizedSecondApproach(0))
        assertFalse(isPrimeOptimizedSecondApproach(1))
        assertFalse(isPrimeOptimizedSecondApproach(4))
        assertFalse(isPrimeOptimizedSecondApproach(6))
        assertFalse(isPrimeOptimizedSecondApproach(8))
        assertFalse(isPrimeOptimizedSecondApproach(9))
        assertFalse(isPrimeOptimizedSecondApproach(10))
        assertFalse(isPrimeOptimizedSecondApproach(12))
        assertFalse(isPrimeOptimizedSecondApproach(14))
        assertFalse(isPrimeOptimizedSecondApproach(15))
        assertFalse(isPrimeOptimizedSecondApproach(16))
        assertFalse(isPrimeOptimizedSecondApproach(18))
        assertFalse(isPrimeOptimizedSecondApproach(20))
        assertFalse(isPrimeOptimizedSecondApproach(21))
        assertFalse(isPrimeOptimizedSecondApproach(22))
        assertFalse(isPrimeOptimizedSecondApproach(24))
        assertFalse(isPrimeOptimizedSecondApproach(25))

        assertFalse(isPrimeOptimizedSecondApproach(-1))
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

    @Test
    fun `Test IsPrime using the Fermat's Primality Test`() {
        assertFalse(isPrimeFermat(0, 5))
        assertFalse(isPrimeFermat(1, 5))
        assertFalse(isPrimeFermat(4, 5))
        assertTrue(isPrimeFermat(2, 5))
        assertTrue(isPrimeFermat(3, 5))
        assertTrue(isPrimeFermat(5, 5))
        assertTrue(isPrimeFermat(11, 5))
        assertTrue(isPrimeFermat(13, 5))
        assertTrue(isPrimeFermat(17, 5))
        assertTrue(isPrimeFermat(19, 5))
        assertFalse(isPrimeFermat(6, 5))
        assertFalse(isPrimeFermat(9, 5))
        assertFalse(isPrimeFermat(15, 5))
        assertFalse(isPrimeFermat(21, 5))
        assertFalse(isPrimeFermat(25, 5))
        assertTrue(isPrimeFermat(10007, 5))
        assertFalse(isPrimeFermat(10005, 5))
    }
}