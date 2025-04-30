package dp.lps

/**
 * Computes the length of the Longest Palindromic Subsequence (LPS) in a given string.
 *
 * The LPS is the longest sequence that appears in the same order forward and backward.
 * This class provides both a dynamic programming (bottom-up) and a DFS with memoization approach.
 *
 * See: [Longest Palindromic Subsequence](https://en.wikipedia.org/wiki/Longest_palindromic_subsequence)
 */
class LongestPalindromicSubsequence {

    /**
     * Computes the LPS using bottom-up dynamic programming.
     *
     * @param s The input string.
     * @return The length of the longest palindromic subsequence.
     */
    fun lps(s: String): Int {
        val n = s.length
        val dp = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            dp[i][i] = 1
        }
        for (i in n - 1 downTo 0) {
            for (j in i + 1 until n) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2
                } else {
                    dp[i][j] = maxOf(dp[i + 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[0][n - 1]
    }

    /**
     * Computes the LPS using DFS with memoization.
     *
     * @param s The input string.
     * @return The length of the longest palindromic subsequence.
     */
    fun lpsDfs(s: String): Int {
        val memo = mutableMapOf<Pair<Int, Int>, Int>()

        fun dfs(left: Int, right: Int): Int {
            if (left > right) return 0
            if (left == right) return 1
            val key = left to right
            if (key in memo) return memo[key]!!

            val result = if (s[left] == s[right]) {
                dfs(left + 1, right - 1) + 2
            } else {
                maxOf(dfs(left + 1, right), dfs(left, right - 1))
            }
            memo[key] = result
            return result
        }

        return dfs(0, s.lastIndex)
    }
}