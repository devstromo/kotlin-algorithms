package strings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StringTransformsKtUnitTest {
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

    @Test
    fun `Test reverse with regular string using swap`() {
        val input = "hello"
        val expected = "olleh"
        val result = reverseUsingSwaps(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with single character using swap`() {
        val input = "a"
        val expected = "a"
        val result = reverseUsingSwaps(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with empty string using swap`() {
        val input = ""
        val expected = ""
        val result = reverseUsingSwaps(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with palindrome using swap`() {
        val input = "madam"
        val expected = "madam"
        val result = reverseUsingSwaps(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with special characters using swap`() {
        val input = "a!b@c#d\$"
        val expected = "\$d#c@b!a"
        val result = reverseUsingSwaps(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with numbers using swap`() {
        val input = "12345"
        val expected = "54321"
        val result = reverseUsingSwaps(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with regular string using XOR`() {
        val input = "hello"
        val expected = "olleh"
        val result = reverseUsingXOR(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with single character using XOR`() {
        val input = "a"
        val expected = "a"
        val result = reverseUsingXOR(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with empty string using XOR`() {
        val input = ""
        val expected = ""
        val result = reverseUsingXOR(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with palindrome using XOR`() {
        val input = "madam"
        val expected = "madam"
        val result = reverseUsingXOR(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with special characters using XOR`() {
        val input = "a!b@c#d\$"
        val expected = "\$d#c@b!a"
        val result = reverseUsingXOR(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse with numbers using XOR`() {
        val input = "12345"
        val expected = "54321"
        val result = reverseUsingXOR(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words by char with regular sentence`() {
        val input = "hello world"
        val expected = "world hello"
        val result = reverseWordsByCharUsingAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words by char with single word`() {
        val input = "hello"
        val expected = "hello"
        val result = reverseWordsByCharUsingAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words by char with multiple spaces`() {
        val input = "hello   world"
        val expected = "world   hello"
        val result = reverseWordsByCharUsingAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words by char with empty string`() {
        val input = ""
        val expected = ""
        val result = reverseWordsByCharUsingAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words by char with special characters`() {
        val input = "hello@world"
        val expected = "hello@world"
        val result = reverseWordsByCharUsingAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words by char with leading and trailing spaces`() {
        val input = "  hello world  "
        val expected = "  world hello  "
        val result = reverseWordsByCharUsingAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words with regular sentence`() {
        val input = "hello world"
        val expected = "world hello"
        val result = reverseWordsUsingStringTokenizerWithAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words with single word`() {
        val input = "hello"
        val expected = "hello"
        val result = reverseWordsUsingStringTokenizerWithAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words with multiple spaces`() {
        val input = "hello   world"
        val expected = "world hello"
        val result = reverseWordsUsingStringTokenizerWithAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words with empty string`() {
        val input = ""
        val expected = ""
        val result = reverseWordsUsingStringTokenizerWithAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words with special characters`() {
        val input = "hello@world"
        val expected = "hello@world"
        val result = reverseWordsUsingStringTokenizerWithAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words with leading and trailing spaces`() {
        val input = "  hello world  "
        val expected = "world hello"
        val result = reverseWordsUsingStringTokenizerWithAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words using split with regular sentence`() {
        val input = "hello world"
        val expected = "world hello"
        val result = reverseWordsUsingSplitWithAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words using split with single word`() {
        val input = "hello"
        val expected = "hello"
        val result = reverseWordsUsingSplitWithAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words using split with multiple spaces`() {
        val input = "hello   world"
        val expected = "world hello"
        val result = reverseWordsUsingSplitWithAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words using split with empty string`() {
        val input = ""
        val expected = ""
        val result = reverseWordsUsingSplitWithAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words using split with special characters`() {
        val input = "hello@world"
        val expected = "hello@world"
        val result = reverseWordsUsingSplitWithAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words using split with leading and trailing spaces`() {
        val input = "  hello world  "
        val expected = "world hello"
        val result = reverseWordsUsingSplitWithAdditionalStorage(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words in place with regular sentence`() {
        val input = "hello world"
        val expected = "world hello"
        val result = reverseWordsInPlace(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words in place with single word`() {
        val input = "hello"
        val expected = "hello"
        val result = reverseWordsInPlace(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words in place with multiple spaces`() {
        val input = "hello   world"
        val expected = "world   hello"
        val result = reverseWordsInPlace(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words in place with empty string`() {
        val input = ""
        val expected = ""
        val result = reverseWordsInPlace(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words in place with special characters`() {
        val input = "hello@world"
        val expected = "hello@world"
        val result = reverseWordsInPlace(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test reverse words in place with leading and trailing spaces`() {
        val input = "  hello world  "
        val expected = "  world hello  "
        val result = reverseWordsInPlace(input)
        assertEquals(expected, result)
    }

    @Test
    fun `Test palindrome with regular palindrome`() {
        val input = "madam"
        val result = isPalindromeWithAdditionalStorage(input)
        assertTrue(result)
    }

    @Test
    fun `Test palindrome with single character`() {
        val input = "a"
        val result = isPalindromeWithAdditionalStorage(input)
        assertTrue(result)
    }

    @Test
    fun `Test palindrome with empty string`() {
        val input = ""
        val result = isPalindromeWithAdditionalStorage(input)
        assertTrue(result)
    }

    @Test
    fun `Test palindrome with non-palindrome string`() {
        val input = "hello"
        val result = isPalindromeWithAdditionalStorage(input)
        assertFalse(result)
    }

    @Test
    fun `Test palindrome with special characters`() {
        val input = "A man, a plan, a canal, Panama".replace("[^A-Za-z]".toRegex(), "").toLowerCase()
        val result = isPalindromeWithAdditionalStorage(input)
        assertTrue(result)
    }

    @Test
    fun `Test palindrome with numbers`() {
        val input = "12321"
        val result = isPalindromeWithAdditionalStorage(input)
        assertTrue(result)
    }

    @Test
    fun `Test palindrome with mixed case`() {
        val input = "MadAm"
        val result = isPalindromeWithAdditionalStorage(input)
        assertFalse(result)
    }
}