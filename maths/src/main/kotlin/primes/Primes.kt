package primes

import kotlin.math.sqrt

/**
 * Checks if a number is prime using a classic approach.
 *
 * This method checks for primality by testing divisibility from 2 up to (but not including) the number itself.
 * If any number in this range divides the input number without a remainder, the number is not prime.
 *
 * @param n The number to check for primality.
 * @return `true` if the number is prime, `false` otherwise.
 *
 * @complexity The time complexity of this method is O(n), where n is the input number.
 */
fun isPrimeClassic(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2..<n) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}

/**
 * Checks if a number is prime using an optimized approach.
 *
 * This method checks for primality by testing divisibility from 2 up to the square root of the number.
 * If any number in this range divides the input number without a remainder, the number is not prime.
 *
 * @param n The number to check for primality.
 * @return `true` if the number is prime, `false` otherwise.
 *
 * @complexity The time complexity of this method is O(sqrt(n)), where n is the input number.
 */
fun isPrimeOptimized(n: Int): Boolean {
    if (n <= 1) return false
    val end = sqrt(n.toDouble()).toInt()
    for (i in 2..end) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}


/**
 * Checks if a number is prime using the Sieve of Eratosthenes algorithm.
 *
 * This function first generates a list of primes up to the given number using the Sieve of Eratosthenes.
 * It then checks the primality of the given number by looking up this list.
 *
 * @param n The number to check for primality.
 * @return `true` if the number is prime, `false` otherwise.
 */
fun isPrimeSieve(n: Int): Boolean {
    if (n <= 1) return false

    // Generate list of primes up to n using the Sieve of Eratosthenes
    val isPrime = BooleanArray(n + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..n) {
        if (isPrime[i]) {
            for (j in 2 * i..n step i) {
                isPrime[j] = false
            }
        }
    }

    return isPrime[n]
}