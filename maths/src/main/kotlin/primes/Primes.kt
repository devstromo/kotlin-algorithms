package primes

import maths.gcd
import maths.power
import kotlin.math.sqrt
import kotlin.random.Random

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
 * Checks if a number is prime using an optimized approach.
 *
 * This method first handles small numbers and even numbers efficiently. For numbers greater than 3,
 * it checks divisibility starting from 5 up to the square root of the number, stepping by 6.
 * This takes advantage of the fact that any prime number greater than 3 can be written in the form of 6k ± 1.
 * If any number in this range divides the input number without a remainder, the number is not prime.
 *
 * @param n The number to check for primality.
 * @return `true` if the number is prime, `false` otherwise.
 *
 * @complexity The time complexity of this method is O(sqrt(n)), where n is the input number.
 */
fun isPrimeOptimizedSecondApproach(n: Int): Boolean {
    if (n <= 1) return false
    if (n == 2 || n == 3) return true
    if (n % 2 == 0 || n % 3 == 0) return false
    val end = sqrt(n.toDouble()).toInt() + 1
    for (i in 5 until end step 6) {
        if (n % i == 0 || n % (i + 2) == 0) {
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

/**
 * Checks if a number is prime using the Fermat primality test.
 *
 * This function uses the Fermat primality test to check if a number is prime.
 * It tries `k` times to test if `n` is a prime number.
 *
 * @param n the number to check for primality
 * @param k the number of iterations to perform the test
 * @return `true` if `n` is probably prime, `false` otherwise
 *
 */
fun isPrimeFermat(n: Int, k: Int): Boolean {
    // Corner cases
    if (n <= 1 || n == 4) return false
    if (n <= 3) return true

    var attempts = k
    while (attempts > 0) {
        // Pick a random number in [2..n-2]
        // Above corner cases make sure that n > 4
        val a = 2 + Random.nextInt(n - 4)

        // Checking if a and n are co-prime
        if (gcd(n, a) != 1) return false

        // Fermat's little theorem
        if (power(a.toLong(), (n - 1).toLong(), n.toLong()) != 1L) return false

        attempts--
    }

    return true
}

/**
 * Performs the Miller-Rabin primality test on a given number.
 *
 * The Miller-Rabin test is a probabilistic algorithm to determine if a number is a probable prime.
 * It can provide certainty up to the given number of iterations (`k`). Higher values of `k` increase
 * the likelihood of correctness, but no iteration is completely deterministic.
 *
 * The algorithm is based on the property that for a composite number `n`, there is a non-trivial witness
 * `a` such that `a^d % n` is neither 1 nor `n-1` for certain values of `d`. The test runs `k` iterations
 * with different values of `a` to verify this property.
 *
 * The time complexity of the Miller-Rabin primality test is O(k * log^3(n)), where `k` is the number of
 * iterations and `n` is the number being tested.
 *
 * @param n The number to be tested for primality.
 * @param k The number of iterations to perform. Higher values increase the accuracy of the test.
 * @return `true` if the number is a probable prime, `false` otherwise.
 */
fun millerRabinTest(n: Long, k: Int = 5): Boolean {
    if (n <= 1) return false
    if (n <= 3) return true
    if (n % 2 == 0L || n % 3 == 0L) return false

    // Write n - 1 as 2^r * d
    var r = 0
    var d = n - 1
    while (d % 2 == 0L) {
        d /= 2
        r += 1
    }

    // Witness loop
    repeat(k) {
        val a = Random.nextLong(2, n - 2)
        var x = power(a, d, n)
        if (x == 1L || x == n - 1) return@repeat

        var i = 0
        while (i < r - 1) {
            x = power(x, 2, n)
            if (x == n - 1) return@repeat
            i += 1
        }

        return false
    }

    return true
}