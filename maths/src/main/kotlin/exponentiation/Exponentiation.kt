package exponentiation

class Exponentiation {
    /**
     * Performs exponentiation of a base to a power using recursion.
     *
     * This method calculates `base` raised to the power of `exponent` recursively.
     *
     * @param base The base value.
     * @param exponent The exponent value.
     * @return The result of `base` raised to the power of `exponent`.
     */
    fun recursive(base: Int, exponent: Int): Int {
        return when (exponent) {
            0 -> 1
            1 -> base
            else -> recursive(base, exponent - 1) * base
        }
    }
}