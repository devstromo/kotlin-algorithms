package maths

import kotlin.math.abs

/**
 * Computes (base^exp) % mod using iterative method to perform modular exponentiation.
 *
 * @param base the base number
 * @param exp  the exponent
 * @param mod  the modulo
 * @return (base ^ exp) % mod
 */
fun power(
    base: Long,
    exp: Long,
    mod: Long
): Long {
    var result = 1L
    var b = base % mod
    var e = exp
    while (e > 0) {
        if ((e and 1) == 1L) {
            result = (result * b) % mod
        }
        e = e shr 1
        b = (b * b) % mod
    }
    return result
}

/**
 * Computes the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
 *
 * The GCD of two integers is the largest positive integer that divides both numbers without leaving a remainder.
 * This function works for both positive and negative integers.
 *
 * @param a the first integer
 * @param b the second integer
 * @return the greatest common divisor of `a` and `b`
 *
 */
fun gcd(a: Int, b: Int): Int {
    val absA = abs(a)
    val absB = abs(b)
    return if (absA < absB) {
        gcd(absB, absA)
    } else if (absB == 0) {
        absA
    } else {
        gcd(absB, absA % absB)
    }
}