package dp.subset_sum

/**
 * Solves the Subset Sum problem using dynamic programming.
 *
 * Given a list of integers and a target sum, this algorithm determines
 * whether any subset of the numbers can sum up exactly to the target.
 *
 * See: [Subset Sum Problem](https://en.wikipedia.org/wiki/Subset_sum_problem)
 */
class SubsetSum {

    /**
     * Determines if there is a subset of nums that sums to the target.
     *
     * @param nums The list of integers.
     * @param target The target sum.
     * @return True if a subset sums to target, false otherwise.
     */
    fun canAchieveTarget(nums: IntArray, target: Int): Boolean {
        val n = nums.size
        val dp = Array(n + 1) { BooleanArray(target + 1) }

        for (i in 0..n) {
            dp[i][0] = true // Zero sum is always achievable (by empty subset)
        }

        for (i in 1..n) {
            for (sum in 1..target) {
                if (sum < nums[i - 1]) {
                    dp[i][sum] = dp[i - 1][sum]
                } else {
                    dp[i][sum] = dp[i - 1][sum] || dp[i - 1][sum - nums[i - 1]]
                }
            }
        }

        return dp[n][target]
    }
}
