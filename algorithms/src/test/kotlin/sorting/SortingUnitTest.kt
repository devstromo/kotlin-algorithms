package sorting

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import sorting.bubble.BubbleSort

class SortingUnitTest {

    private val bubbleSort = BubbleSort()

    @Test
    fun `Test Bubble Sort with randomly ordered array`() {
        val array = intArrayOf(4, 3, 5, 2, 1)
        val expected = intArrayOf(1, 2, 3, 4, 5)

        assertArrayEquals(
            expected,
            bubbleSort.sort(array),
            "The sorted array does not match the expected output."
        )
    }

    @Test
    fun `Test Bubble Sort with already sorted array`() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        val expected = intArrayOf(1, 2, 3, 4, 5)
        assertArrayEquals(expected, bubbleSort.sort(array), "The sorted array should remain unchanged.")
    }
}