package dp.edit_distance

/**
 * Computes the Edit Distance (Levenshtein Distance) between two strings using dynamic programming.
 *
 * The Edit Distance is the minimum number of operations (insert, delete, substitute)
 * required to convert one string into another.
 *
 * See: [Edit Distance - Levenshtein Distance](https://en.wikipedia.org/wiki/Levenshtein_distance)
 */
class EditDistance {

    /**
     * Calculates the edit distance between two strings.
     *
     * @param word1 The first string.
     * @param word2 The second string.
     * @return The minimum number of operations required to convert word1 to word2.
     */
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (i in 0..m) dp[i][0] = i
        for (j in 0..n) dp[0][j] = j

        for (i in 1..m) {
            for (j in 1..n) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = 1 + minOf(
                        dp[i - 1][j],     // delete
                        dp[i][j - 1],     // insert
                        dp[i - 1][j - 1]  // replace
                    )
                }
            }
        }

        return dp[m][n]
    }
}