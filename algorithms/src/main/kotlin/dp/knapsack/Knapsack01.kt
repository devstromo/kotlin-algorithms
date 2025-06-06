package dp.knapsack

/**
 * Solves the 0/1 Knapsack problem using dynamic programming.
 *
 * Given weights and values of `n` items, put these items in a knapsack of capacity `W` to get the maximum total value.
 * Each item can be included or excluded only once.
 *
 * See: [Knapsack problem](https://en.wikipedia.org/wiki/Knapsack_problem)
 */
class Knapsack01 {

    /**
     * Computes the maximum value that can be obtained with the given weights and values under the capacity limit.
     *
     * @param weights An array of item weights.
     * @param values An array of item values.
     * @param capacity The maximum weight capacity of the knapsack.
     * @return The maximum value achievable.
     */
    fun maxKnapsackValue(weights: IntArray, values: IntArray, capacity: Int): Int {
        val n = weights.size
        val dp = Array(n + 1) { IntArray(capacity + 1) }

        for (i in 1..n) {
            for (w in 0..capacity) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = maxOf(
                        dp[i - 1][w],
                        values[i - 1] + dp[i - 1][w - weights[i - 1]]
                    )
                } else {
                    dp[i][w] = dp[i - 1][w]
                }
            }
        }

        return dp[n][capacity]
    }
}