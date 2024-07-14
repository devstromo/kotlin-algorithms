package permutations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PermutationsKtUnitTest {

    @Test
    fun `Test string permutations`() {
        val result = permutations("abc")
        val expected = arrayOf("abc", "acb", "bac", "bca", "cab", "cba")
        assertArrayEquals(expected, result)

        val result2 = permutations("ab")
        val expected2 = arrayOf("ab", "ba")
        assertArrayEquals(expected2, result2)

        val result3 = permutations("a")
        val expected3 = arrayOf("a")
        assertArrayEquals(expected3, result3)

        val result4 = permutations("")
        val expected4 = emptyArray<String>()
        assertArrayEquals(expected4, result4)
    }

    @Test
    fun `Test number permutations`() {
        val numbers = arrayOf(1, 2, 3)
        val result = getAllPermutations(numbers)
        val expected = listOf(
            listOf(1, 2, 3),
            listOf(1, 3, 2),
            listOf(2, 1, 3),
            listOf(2, 3, 1),
            listOf(3, 1, 2),
            listOf(3, 2, 1)
        )
        assertTrue(result.containsAll(expected) && expected.containsAll(result))

        val numbers2 = arrayOf(1, 2)
        val result2 = getAllPermutations(numbers2)
        val expected2 = listOf(
            listOf(1, 2),
            listOf(2, 1)
        )
        assertTrue(result2.containsAll(expected2) && expected2.containsAll(result2))

        val numbers3 = arrayOf(1)
        val result3 = getAllPermutations(numbers3)
        val expected3 = listOf(
            listOf(1)
        )
        assertTrue(result3.containsAll(expected3) && expected3.containsAll(result3))

        val numbers4 = arrayOf<Int>()
        val result4 = getAllPermutations(numbers4)
        val expected4 = listOf<List<Int>>()
        assertTrue(result4.containsAll(expected4))
    }
}

