package primes

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