package strings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StringTransformsKtUnitTest {
    @Test
    fun `Test reverse with regular string`() {
        val input = "hello"
        val expected = "olleh"
        val result = reverseUsingStringConcat(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with single character`() {
        val input = "a"
        val expected = "a"
        val result = reverseUsingStringConcat(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with empty string`() {
        val input = ""
        val expected = ""
        val result = reverseUsingStringConcat(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with palindrome`() {
        val input = "madam"
        val expected = "madam"
        val result = reverseUsingStringConcat(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with special characters`() {
        val input = "a!b@c#d\$"
        val expected = "\$d#c@b!a"
        val result = reverseUsingStringConcat(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with numbers`() {
        val input = "12345"
        val expected = "54321"
        val result = reverseUsingStringConcat(input)
        assertEquals(expected, result)
    }
}