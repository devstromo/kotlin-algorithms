package combinatorial.backtracking

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class PermutationsUnitTest {
    private val permutations = Permutations()

    @Test
    fun `Test Generate Permutations with Three Elements`() {
        val input = listOf(1, 2, 3)
        val expected = listOf(
            listOf(1, 2, 3), listOf(1, 3, 2),
            listOf(2, 1, 3), listOf(2, 3, 1),
            listOf(3, 1, 2), listOf(3, 2, 1)
        )
        val result = permutations.generatePermutations(input)
        assertContentEquals(expected, result)
    }

    @Test
    fun `Test Generate Permutations with Two Elements`() {
        val input = listOf(1, 2)
        val expected = listOf(
            listOf(1, 2), listOf(2, 1)
        )
        val result = permutations.generatePermutations(input)
        assertContentEquals(expected, result)
    }

    @Test
    fun `Test Generate Permutations with Empty List`() {
        val input = emptyList<Int>()
        val expected = listOf(emptyList<Int>())
        val result = permutations.generatePermutations(input)
        assertContentEquals(expected, result)
    }

    @Test
    fun `Test Generate Permutations with Single Element`() {
        val input = listOf(42)
        val expected = listOf(listOf(42))
        val result = permutations.generatePermutations(input)
        assertContentEquals(expected, result)
    }
}