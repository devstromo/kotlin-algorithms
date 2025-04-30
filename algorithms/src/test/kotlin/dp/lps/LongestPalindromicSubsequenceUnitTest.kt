package dp.lps

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LongestPalindromicSubsequenceUnitTest {
    private val solver = LongestPalindromicSubsequence()

    @Test
    fun `Test LPS DP with palindrome`() {
        val input = "bbbab"
        val expected = 4 // "bbbb"
        val result = solver.lps(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test LPS DP with unique chars`() {
        val input = "abc"
        val expected = 1
        val result = solver.lps(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test LPS DP with full palindrome`() {
        val input = "racecar"
        val expected = 7
        val result = solver.lps(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test LPS DFS with memoization`() {
        val input = "bbbab"
        val expected = 4
        val result = solver.lpsDfs(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test LPS DFS with unique chars`() {
        val input = "abc"
        val expected = 1
        val result = solver.lpsDfs(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test LPS DFS with full palindrome`() {
        val input = "racecar"
        val expected = 7
        val result = solver.lpsDfs(input)
        assertEquals(expected, result)
    }
}