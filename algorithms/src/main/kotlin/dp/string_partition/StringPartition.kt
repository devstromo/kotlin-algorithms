package dp.string_partition

/**
 * Solves the String Partition problem using dynamic programming.
 *
 * This version finds the minimum number of cuts needed to partition
 * a string such that every substring is a palindrome.
 *
 * See: [Palindrome Partitioning](https://www.naukri.com/code360/library/palindrome-partitioning)
 */
class StringPartition {
    /**
     * Calculates the minimum cuts needed to partition the string into palindromes.
     *
     * @param s The input string.
     * @return The minimum number of cuts.
     */
    fun minPalindromeCuts(s: String): Int {
        val n = s.length
        if (n == 0) return 0

        val isPalindrome = Array(n) { BooleanArray(n) }
        val cuts = IntArray(n) { it } // worst case: cut before every char

        for (end in 0 until n) {
            for (start in 0..end) {
                if (s[start] == s[end] && (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true
                    cuts[end] = if (start == 0) 0 else minOf(cuts[end], cuts[start - 1] + 1)
                }
            }
        }

        return cuts[n - 1]
    }
}