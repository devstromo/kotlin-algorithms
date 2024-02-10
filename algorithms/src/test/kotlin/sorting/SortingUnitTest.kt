package sorting

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import sorting.bubble.BubbleSort
import sorting.insertion.InsertionSort
import sorting.selection.SelectionSort
import sorting.shell.ShellSort

class SortingUnitTest {

    private val bubbleSort = BubbleSort()
    private val selectionSort = SelectionSort()
    private val insertionSort = InsertionSort()
    private val shellSort = ShellSort()

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

    @Test
    fun `Test Selection Sort with randomly ordered array`() {
        val array = intArrayOf(64, 25, 12, 22, 11)
        val expected = intArrayOf(11, 12, 22, 25, 64)

        assertArrayEquals(
            expected,
            selectionSort.sort(array),
            "The sorted array does not match the expected output."
        )
    }

    @Test
    fun `Test Selection Sort with already sorted array`() {
        val array = intArrayOf(11, 12, 22, 25, 64)
        val expected = intArrayOf(11, 12, 22, 25, 64)
        assertArrayEquals(expected, selectionSort.sort(array), "The sorted array should remain unchanged.")
    }

    @Test
    fun `Test Insertion Sort with randomly ordered array`() {
        val array = intArrayOf(5, 3, 4, 1, 2)
        val expected = intArrayOf(1, 2, 3, 4, 5)
        assertArrayEquals(expected, insertionSort.sort(array), "The array should be sorted in ascending order.")
    }

    @Test
    fun `Test Insertion Sort with already sorted array`() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        val expected = intArrayOf(1, 2, 3, 4, 5)
        assertArrayEquals(expected, insertionSort.sort(array), "The sorted array should remain unchanged.")
    }

    @Test
    fun `Test Shell Sort with randomly ordered array`() {
        val array = intArrayOf(9, 8, 3, 7, 5, 6, 4, 1)
        val expected = intArrayOf(1, 3, 4, 5, 6, 7, 8, 9)
        assertArrayEquals(expected, shellSort.sort(array), "The array should be sorted in ascending order.")
    }

    @Test
    fun `Test Shell Sort with negative and positive numbers`() {
        val array = intArrayOf(-31, 45, 0, -11, 8, -65, 69)
        val expected = intArrayOf(-65, -31, -11, 0, 8, 45, 69)
        assertArrayEquals(
            expected,
            shellSort.sort(array),
            "The array should be sorted in ascending order with negative and positive numbers."
        )
    }
}