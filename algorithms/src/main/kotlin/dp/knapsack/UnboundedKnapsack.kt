package dp.knapsack

/**
 * Solves the Unbounded Knapsack problem using dynamic programming.
 *
 * Unlike the 0/1 Knapsack problem, in this version each item can be chosen multiple times.
 *
 * See: [Unbounded Knapsack Problem](https://en.wikipedia.org/wiki/Knapsack_problem#Dynamic_programming_in-advance_algorithm)
 */
class UnboundedKnapsack {

    /**
     * Computes the maximum value that can be obtained with the given weights and values under the capacity limit,
     * with infinite supply of each item.
     *
     * @param weights An array of item weights.
     * @param values An array of item values.
     * @param capacity The maximum weight capacity of the knapsack.
     * @return The maximum value achievable.
     */
    fun maxKnapsackValue(weights: IntArray, values: IntArray, capacity: Int): Int {
        val dp = IntArray(capacity + 1)

        for (w in 0..capacity) {
            for (i in weights.indices) {
                if (weights[i] <= w) {
                    dp[w] = maxOf(dp[w], dp[w - weights[i]] + values[i])
                }
            }
        }

        return dp[capacity]
    }
}