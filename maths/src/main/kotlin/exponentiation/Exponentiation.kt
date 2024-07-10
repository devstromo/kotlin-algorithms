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

    /**
     * Performs exponentiation of a base to a power using an optimized recursive approach.
     *
     * This method calculates `base` raised to the power of `exponent` recursively using the fast exponentiation method.
     *
     * @param base The base value.
     * @param exponent The exponent value.
     * @return The result of `base` raised to the power of `exponent`.
     */
    fun fastRecursive(base: Int, exponent: Int): Int {
        return when (exponent) {
            0 -> 1
            1 -> base
            else -> {
                val resultOnHalfExponent = fastRecursive(base, exponent / 2)
                if ((exponent % 2) == 0)
                    resultOnHalfExponent * resultOnHalfExponent
                else
                    resultOnHalfExponent * resultOnHalfExponent * base
            }
        }
    }

    /**
     * Performs exponentiation of a base to a power using an optimized recursive approach with modulo operation.
     *
     * This method calculates `base` raised to the power of `exponent` modulo `mod` recursively using the fast exponentiation method.
     *
     * @param base The base value.
     * @param exponent The exponent value.
     * @param mod The modulo value.
     * @return The result of `base` raised to the power of `exponent` modulo `mod`.
     */
    fun fastRecursiveModulo(base: Int, exponent: Int, mod: Int): Int {
        return when (exponent) {
            0 -> 1
            1 -> base % mod
            else -> {
                val resultOnHalfExponent = fastRecursiveModulo(base, exponent / 2, mod)
                if ((exponent % 2) == 0)
                    (resultOnHalfExponent * resultOnHalfExponent) % mod
                else
                    ((resultOnHalfExponent * resultOnHalfExponent) % mod * base) % mod
            }
        }
    }

    /**
     * Performs exponentiation of a base to a power using an iterative approach.
     *
     * @param base The base value.
     * @param exponent The exponent value.
     * @return The result of `base` raised to the power of `exponent`.
     */
    fun iterative(base: Int, exponent: Int): Int {
        var result = 1
        for (i in 1..exponent) {
            result *= base
        }
        return result
    }
}