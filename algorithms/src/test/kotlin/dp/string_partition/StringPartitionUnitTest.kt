package dp.string_partition

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StringPartitionUnitTest {

    private val solver = StringPartition()

    @Test
    fun `Test min cuts for simple palindrome`() {
        val input = "aab"
        val expected = 1 // "aa" | "b"
        assertEquals(expected, solver.minPalindromeCuts(input))
    }

    @Test
    fun `Test no cuts for full palindrome`() {
        val input = "racecar"
        val expected = 0
        assertEquals(expected, solver.minPalindromeCuts(input))
    }

    @Test
    fun `Test single character`() {
        val input = "a"
        val expected = 0
        assertEquals(expected, solver.minPalindromeCuts(input))
    }

    @Test
    fun `Test empty string`() {
        val input = ""
        val expected = 0
        assertEquals(expected, solver.minPalindromeCuts(input))
    }

    @Test
    fun `Test multiple cuts`() {
        val input = "ababbbabbababa"
        val expected = 3
        assertEquals(expected, solver.minPalindromeCuts(input))
    }
}