package dp.palindromic_subsequence

/**
 * A class to solve the Longest Palindromic Subsequence problem using Dynamic Programming.
 *
 * This algorithm finds the length of the longest subsequence in a given string that is a palindrome.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 *
 * See: [Longest Palindromic Subsequence](https://www.geeksforgeeks.org/dsa/longest-palindromic-subsequence-dp-12/)
 */
class PalindromicSubsequence {

    /**
     * Returns the length of the longest palindromic subsequence in the input string.
     *
     * @param s the input string
     * @return the length of the longest palindromic subsequence
     */
    fun longestPalindromeSubseq(s: String): Int {
        val n = s.length
        if (n == 0) return 0

        val dp = Array(n) { IntArray(n) }

        for (i in n - 1 downTo 0) {
            dp[i][i] = 1
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

    fun longestPalindromeSubseqLCS(s: String): Int {
        val reveredString = s.reversed()
        return lcs(s, reveredString)
    }

    private fun lcs(text1: String, text2: String): Int {
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
}
