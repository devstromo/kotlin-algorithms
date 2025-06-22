package dp.catalan_numbers

/**
 * A class to compute Catalan numbers using dynamic programming.
 *
 * Catalan numbers appear in many combinatorial problems such as:
 * - Counting valid parentheses combinations
 * - Counting the number of unique BSTs
 * - Triangulating polygons
 *
 * See: [Catalan number](https://en.wikipedia.org/wiki/Catalan_number)
 */
class CatalanNumber {

    /**
     * Computes the nth Catalan number using bottom-up dynamic programming.
     *
     * @param n The index of the Catalan number to compute.
     * @return The nth Catalan number.
     */
    fun catalan(n: Int): Long {
        val dp = LongArray(n + 1)
        dp[0] = 1L

        for (i in 1..n) {
            for (j in 0 until i) {
                dp[i] += dp[j] * dp[i - 1 - j]
            }
        }

        return dp[n]
    }
}
