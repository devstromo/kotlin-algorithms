package dp.lis

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LongestIncreasingSubsequenceUnitTest {
    private val longestIncreasingSubsequence = LongestIncreasingSubsequence()

    @Test
    @DisplayName("Longest Increasing Subsequence")
    fun testLongestIncreasingSubsequence() {
        assertEquals(6, longestIncreasingSubsequence.lis(intArrayOf(10, 22, 9, 33, 21, 50, 41, 60, 80)))
        assertEquals(5, longestIncreasingSubsequence.lis(intArrayOf(3, 4, 5, 10, 2, 15)))
        assertEquals(1, longestIncreasingSubsequence.lis(intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)))
    }

}