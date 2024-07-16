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

    @Test
    fun `Test reverse with regular string StringBuilder`() {
        val input = "hello"
        val expected = "olleh"
        val result = reverseUsingStringBuilder(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with single character StringBuilder`() {
        val input = "a"
        val expected = "a"
        val result = reverseUsingStringBuilder(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with empty string StringBuilder`() {
        val input = ""
        val expected = ""
        val result = reverseUsingStringBuilder(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with palindrome StringBuilder`() {
        val input = "madam"
        val expected = "madam"
        val result = reverseUsingStringBuilder(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with special characters StringBuilder`() {
        val input = "a!b@c#d\$"
        val expected = "\$d#c@b!a"
        val result = reverseUsingStringBuilder(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with numbers StringBuilder`() {
        val input = "12345"
        val expected = "54321"
        val result = reverseUsingStringBuilder(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with regular string StringBuilder Reverse`() {
        val input = "hello"
        val expected = "olleh"
        val result = reverseUsingStringBuilderReverse(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with single character StringBuilder Reverse`() {
        val input = "a"
        val expected = "a"
        val result = reverseUsingStringBuilderReverse(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with empty string StringBuilder Reverse`() {
        val input = ""
        val expected = ""
        val result = reverseUsingStringBuilderReverse(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with palindrome StringBuilder Reverse`() {
        val input = "madam"
        val expected = "madam"
        val result = reverseUsingStringBuilderReverse(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with special characters StringBuilder Reverse`() {
        val input = "a!b@c#d\$"
        val expected = "\$d#c@b!a"
        val result = reverseUsingStringBuilderReverse(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with numbers StringBuilder Reverse`() {
        val input = "12345"
        val expected = "54321"
        val result = reverseUsingStringBuilderReverse(input)
        assertEquals(expected, result)
    }
}