package gcd

import kotlin.math.abs


/**
 * Computes the greatest common divisor (GCD) of two numbers using recursion.
 *
 * @param a The first number.
 * @param b The second number.
 * @return The GCD of the two numbers.
 */
fun gcdRecursive(a: Long, b: Long): Long {
    val absA = abs(a)
    val absB = abs(b)
    return if (absA == 0L) absB else gcdRecursive(absB % absA, absA)
}

/**
 * Computes the greatest common divisor (GCD) of two numbers using Euclid's algorithm.
 *
 * This implementation subtracts the smaller number from the larger one until both numbers are equal.
 *
 * @param x The first number.
 * @param y The second number.
 * @return The GCD of the two numbers.
 *
 * Time complexity: O(max(x, y)) in the worst case, although it is usually much faster.
 */
fun gcdEuclides(x: Long, y: Long): Long {
    var greater = abs(x)
    var smaller = abs(y)
    if (smaller == 0L) return greater
    if (greater == 0L) return smaller

    if (smaller > greater) {
        greater = smaller.also { smaller = greater }
    }

    while (true) {
        if (smaller == greater) {
            return smaller
        }

        greater -= smaller
        if (smaller > greater) {
            smaller = greater.also { greater = smaller }
        }
    }
}


/**
 * Computes the greatest common divisor (GCD) of two numbers using the Binary GCD algorithm.
 *
 * This implementation uses bitwise operations to compute the GCD.
 *
 * @param x The first number.
 * @param y The second number.
 * @return The GCD of the two numbers.
 *
 * Time complexity: O(log(min(x, y))).
 */
fun gcdUsingBinaryAlgorithm(x: Long, y: Long): Long {
    var a = abs(x)
    var b = abs(y)

    // GCD(0, b) == b; GCD(a, 0) == a, GCD(0, 0) == 0
    if (a == 0L) return b
    if (b == 0L) return a

    // Finding common factors of 2
    var shift = 0
    while (((a or b) and 1) == 0L) {
        a = a shr 1
        b = b shr 1
        shift++
    }

    // Dividing a by 2 until odd
    while ((a and 1) == 0L) {
        a = a shr 1
    }

    do {
        // Dividing b by 2 until odd
        while ((b and 1) == 0L) {
            b = b shr 1
        }

        // Now a and b are both odd. Swap if necessary so a <= b,
        // then set b = b - a (which is even).
        if (a > b) {
            val temp = a
            a = b
            b = temp
        }
        b -= a
    } while (b != 0L)

    // Restore common factors of 2
    return a shl shift
}
