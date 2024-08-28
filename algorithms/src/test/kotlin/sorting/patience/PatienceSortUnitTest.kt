package sorting.patience

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PatienceSortUnitTest {
    private val patienceSort = PatienceSort()

    @Test
    fun `Test Patience Sort`() {
        val input1 = intArrayOf(4, 3, 5, 1, 2)
        val expected1 = intArrayOf(1, 2, 3, 4, 5)
        assertArrayEquals(expected1, patienceSort.sort(input1))

        val input2 = intArrayOf(3, 6, 7, 5, 2, 4, 1)
        val expected2 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        assertArrayEquals(expected2, patienceSort.sort(input2))

        val input3 = intArrayOf(1, 2, 3, 4, 5)
        val expected3 = intArrayOf(1, 2, 3, 4, 5)
        assertArrayEquals(expected3, patienceSort.sort(input3))

        val input4 = intArrayOf(5, 4, 3, 2, 1)
        val expected4 = intArrayOf(1, 2, 3, 4, 5)
        assertArrayEquals(expected4, patienceSort.sort(input4))

        val input5 = intArrayOf()
        val expected5 = intArrayOf()
        assertArrayEquals(expected5, patienceSort.sort(input5))
    }
}