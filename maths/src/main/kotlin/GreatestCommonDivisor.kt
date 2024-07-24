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
