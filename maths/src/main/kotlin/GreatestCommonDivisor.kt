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