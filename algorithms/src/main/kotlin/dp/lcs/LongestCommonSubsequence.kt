package dp.lcs

/**
 * Implements the Longest Common Subsequence (LCS) algorithm using dynamic programming.
 *
 * The LCS problem finds the length of the longest subsequence common to two sequences.
 *
 * See: [Longest Common Subsequence](https://en.wikipedia.org/wiki/Longest_common_subsequence_problem)
 */
class LongestCommonSubsequence {
    /**
     * Finds the length of the longest common subsequence between two strings.
     *
     * @param text1 The first string.
     * @param text2 The second string.
     * @return The length of the longest common subsequence.
     */
    fun lcs(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (i in 1..m) {
            for (j in 1..n) {
                if (text1[i - 1] == text2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }

        return dp[m][n]
    }

    fun lcsString(text1: String, text2: String): String {
        val m = text1.length
        val n = text2.length
        val dp = Array(m + 1) { IntArray(n + 1) }

        // Build the DP table
        for (i in 1..m) {
            for (j in 1..n) {
                if (text1[i - 1] == text2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }

        // Backtrack to build the LCS string
        val lcs = StringBuilder()
        var i = m
        var j = n

        while (i > 0 && j > 0) {
            when {
                text1[i - 1] == text2[j - 1] -> {
                    lcs.append(text1[i - 1])
                    i--
                    j--
                }
                dp[i - 1][j] > dp[i][j - 1] -> i--
                else -> j--
            }
        }

        return lcs.reverse().toString()
    }
}