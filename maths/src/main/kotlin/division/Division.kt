package division

/**
 * Performs division of two long integers.
 *
 * This method returns the quotient of the division of `a` by `b` using the standard division operator.
 *
 * @param a The dividend.
 * @param b The divisor.
 * @return The quotient of `a` divided by `b`.
 *
 * @throws ArithmeticException if `b` is zero.
 */
fun division(a: Long, b: Long): Long {
    return a / b
}

/**
 * Performs division of two long integers using a loop-based approach.
 *
 * This method calculates the quotient of `a` divided by `b` by repeatedly subtracting the absolute value of `b` from the absolute value of `a` until the absolute value of `a` is less than the absolute value of `b`.
 * It handles negative numbers by adjusting the sign of the result accordingly.
 *
 * @param a The dividend.
 * @param b The divisor.
 * @return The quotient of `a` divided by `b`.
 *
 * @throws ArithmeticException if `b` is zero.
 */
fun divisionWithLoop(a: Long, b: Long): Long {
    require(b != 0L) { "Divisor cannot be zero." }

    val absA = kotlin.math.abs(a)
    val absB = kotlin.math.abs(b)

    var temp = absA
    var result = 0L
    while (temp >= absB) {
        temp -= absB
        result++
    }

    return if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
        -result
    } else {
        result
    }
}