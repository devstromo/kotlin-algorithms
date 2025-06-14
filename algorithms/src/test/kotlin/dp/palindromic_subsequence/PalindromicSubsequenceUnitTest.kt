package dp.palindromic_subsequence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PalindromicSubsequenceUnitTest {
    private val solver = PalindromicSubsequence()

    @Test
    fun `Test longestPalindromeSubseq with simple case`() {
        val input = "bbbab"
        val expected = 4 // "bbbb"
        assertEquals(expected, solver.longestPalindromeSubseq(input))
    }

    @Test
    fun `Test longestPalindromeSubseq with full palindrome`() {
        val input = "racecar"
        val expected = 7
        assertEquals(expected, solver.longestPalindromeSubseq(input))
    }

    @Test
    fun `Test longestPalindromeSubseq with no repeated characters`() {
        val input = "abcde"
        val expected = 1
        assertEquals(expected, solver.longestPalindromeSubseq(input))
    }

    @Test
    fun `Test longestPalindromeSubseq with empty string`() {
        val input = ""
        val expected = 0
        assertEquals(expected, solver.longestPalindromeSubseq(input))
    }

    @Test
    fun `Test longestPalindromeSubseq with one character`() {
        val input = "z"
        val expected = 1
        assertEquals(expected, solver.longestPalindromeSubseq(input))
    }

    @Test
    fun `Test longestPalindromeSubseq with even length palindrome`() {
        val input = "abccba"
        val expected = 6
        assertEquals(expected, solver.longestPalindromeSubseq(input))
    }


    @Test
    fun `Test longestPalindromeSubseqLCS with simple case`() {
        val input = "bbbab"
        val expected = 4
        assertEquals(expected, solver.longestPalindromeSubseqLCS(input))
    }

    @Test
    fun `Test longestPalindromeSubseqLCS with full palindrome`() {
        val input = "racecar"
        val expected = 7
        assertEquals(expected, solver.longestPalindromeSubseqLCS(input))
    }

    @Test
    fun `Test longestPalindromeSubseqLCS with no repeated characters`() {
        val input = "abcde"
        val expected = 1
        assertEquals(expected, solver.longestPalindromeSubseqLCS(input))
    }

    @Test
    fun `Test longestPalindromeSubseqLCS with empty string`() {
        val input = ""
        val expected = 0
        assertEquals(expected, solver.longestPalindromeSubseqLCS(input))
    }

    @Test
    fun `Test longestPalindromeSubseqLCS with one character`() {
        val input = "z"
        val expected = 1
        assertEquals(expected, solver.longestPalindromeSubseqLCS(input))
    }

    @Test
    fun `Test longestPalindromeSubseqLCS with even length palindrome`() {
        val input = "abccba"
        val expected = 6
        assertEquals(expected, solver.longestPalindromeSubseqLCS(input))
    }

}