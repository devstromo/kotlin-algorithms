package maths

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
    exp: Int,
    mod: Int
): Long {
    var result = 1L
    var b = base % mod
    var e = exp
    while (e > 0) {
        if ((e and 1) == 1) {
            result = (result * b) % mod
        }
        e = e shr 1
        b = (b * b) % mod
    }
    return result
}