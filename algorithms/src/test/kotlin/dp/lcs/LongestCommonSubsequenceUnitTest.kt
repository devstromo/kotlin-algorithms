package dp.lcs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LongestCommonSubsequenceUnitTest {
    private val lcsSolver = LongestCommonSubsequence()

    @Test
    fun `Test common subsequence`() {
        val text1 = "abcde"
        val text2 = "ace"
        val expected = 3  // "ace"
        val result = lcsSolver.lcs(text1, text2)
        assertEquals(expected, result)
    }

    @Test
    fun `Test no common subsequence`() {
        val text1 = "abc"
        val text2 = "def"
        val expected = 0
        val result = lcsSolver.lcs(text1, text2)
        assertEquals(expected, result)
    }

    @Test
    fun `Test one empty string`() {
        val text1 = "abc"
        val text2 = ""
        val expected = 0
        val result = lcsSolver.lcs(text1, text2)
        assertEquals(expected, result)
    }

    @Test
    fun `Test both empty strings`() {
        val text1 = ""
        val text2 = ""
        val expected = 0
        val result = lcsSolver.lcs(text1, text2)
        assertEquals(expected, result)
    }

    @Test
    fun `Test identical strings`() {
        val text1 = "longest"
        val text2 = "longest"
        val expected = 7
        val result = lcsSolver.lcs(text1, text2)
        assertEquals(expected, result)
    }
}