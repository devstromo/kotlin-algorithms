package sorting

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import sorting.bubble.BubbleSort
import sorting.counting.CountingSort
import sorting.heapsort.Heapsort
import sorting.insertion.InsertionSort
import sorting.merge.MergeSort
import sorting.quicksort.QuickSort
import sorting.radix.RadixSort
import sorting.selection.SelectionSort
import sorting.shell.ShellSort

class SortingUnitTest {

    private val bubbleSort = BubbleSort()
    private val selectionSort = SelectionSort()
    private val insertionSort = InsertionSort()
    private val shellSort = ShellSort()
    private val radixSort = RadixSort()
    private val mergeSort = MergeSort()
    private val quickSort = QuickSort()
    private val countingSort = CountingSort()
    private val heapSort = Heapsort()

    @Test
    fun `Test Bubble Sort with randomly ordered array`() {
        val array = intArrayOf(4, 3, 5, 2, 1)
        val expected = intArrayOf(1, 2, 3, 4, 5)

        assertArrayEquals(
            expected, bubbleSort.sort(array), "The sorted array does not match the expected output."
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
            expected, selectionSort.sort(array), "The sorted array does not match the expected output."
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

    @Test
    fun `Test Radix Sort with randomly ordered array`() {
        val array = intArrayOf(170, 45, 75, 90, 802, 24, 2, 66)
        val expected = intArrayOf(2, 24, 45, 66, 75, 90, 170, 802)
        assertArrayEquals(expected, radixSort.sort(array), "The array should be sorted in ascending order.")
    }

    @Test
    fun `Test Radix Sort with zero and large numbers`() {
        val array = intArrayOf(0, 1000000, 500, 113, 26)
        val expected = intArrayOf(0, 26, 113, 500, 1000000)
        assertArrayEquals(
            expected,
            radixSort.sort(array),
            "The array should be sorted in ascending order with zero and large numbers included."
        )
    }

    @Test
    fun `Test Merge Sort with randomly ordered array`() {
        val array = intArrayOf(38, 27, 43, 3, 9, 82, 10)
        val expected = intArrayOf(3, 9, 10, 27, 38, 43, 82)
        assertArrayEquals(expected, mergeSort.sort(array), "The array should be sorted in ascending order.")
    }

    @Test
    fun `Test Merge Sort with negative, positive, and zero values`() {
        val array = intArrayOf(-3, 0, -5, 8, 4, -2)
        val expected = intArrayOf(-5, -3, -2, 0, 4, 8)
        assertArrayEquals(
            expected,
            mergeSort.sort(array),
            "The array should be sorted in ascending order including negative, positive, and zero values."
        )
    }

    @Test
    fun `Test Optimized Merge Sort with randomly ordered array`() {
        val array = intArrayOf(38, 27, 43, 3, 9, 82, 10)
        val expected = intArrayOf(3, 9, 10, 27, 38, 43, 82)
        assertArrayEquals(
            expected, mergeSort.optimizedMergeSort(array), "The array should be sorted in ascending order."
        )
    }

    @Test
    fun `Test Optimized Merge Sort with nearly sorted array`() {
        val array = intArrayOf(1, 2, 5, 3, 4, 6)
        val expected = intArrayOf(1, 2, 3, 4, 5, 6)
        assertArrayEquals(
            expected,
            mergeSort.optimizedMergeSort(array),
            "The nearly sorted array should be efficiently sorted in ascending order."
        )
    }

    @Test
    fun `Test Bottom-Up Merge Sort with randomly ordered array`() {
        val array = intArrayOf(34, -2, 45, 29, 8)
        val expected = intArrayOf(-2, 8, 29, 34, 45)
        assertArrayEquals(
            expected, mergeSort.bottomUpMergeSort(array), "The array should be sorted in ascending order."
        )
    }

    @Test
    fun `Test Bottom-Up Merge Sort with negative and positive numbers`() {
        val array = intArrayOf(-5, 12, -3, 7, 3, -1)
        val expected = intArrayOf(-5, -3, -1, 3, 7, 12)
        assertArrayEquals(
            expected,
            mergeSort.bottomUpMergeSort(array),
            "The array should be sorted in ascending order with negative and positive numbers."
        )
    }

    @Test
    fun `Test QuickSort with randomly ordered array`() {
        val array = intArrayOf(10, 7, 8, 9, 1, 5)
        val expected = intArrayOf(1, 5, 7, 8, 9, 10)
        assertArrayEquals(expected, quickSort.sort(array), "The array should be sorted in ascending order.")
    }

    @Test
    fun `Test QuickSort with negative, positive, and zero values`() {
        val array = intArrayOf(-3, 0, 2, -5, 4, 1)
        val expected = intArrayOf(-5, -3, 0, 1, 2, 4)
        assertArrayEquals(
            expected,
            quickSort.sort(array),
            "The array should be sorted in ascending order including negative, positive, and zero values."
        )
    }

    @Test
    fun `Test Optimized QuickSort with randomly ordered array`() {
        val array = intArrayOf(3, 9, 5, 2, 8, 1, 4)
        val expected = intArrayOf(1, 2, 3, 4, 5, 8, 9)
        assertArrayEquals(expected, quickSort.optimizedSort(array), "The array should be sorted in ascending order.")
    }

    @Test
    fun `Test Optimized QuickSort with small range values`() {
        val array = intArrayOf(5, 3, 4, 1, 2)
        val expected = intArrayOf(1, 2, 3, 4, 5)
        assertArrayEquals(
            expected,
            quickSort.optimizedSort(array),
            "The array should be efficiently sorted, demonstrating the effectiveness of the cutoff to insertion sort."
        )
    }

    @Test
    fun `Test QuickSort 3-Way with many duplicates`() {
        val array = intArrayOf(2, 3, 3, 2, 3, 2, 2, 3, 1, 2, 1, 3)
        val expected = intArrayOf(1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3)

        assertArrayEquals(
            expected,
            quickSort.sort3Way(array),
            "The array should be sorted, demonstrating efficiency with duplicates."
        )
    }

    @Test
    fun `Test QuickSort 3-Way with randomly ordered array`() {
        val array = intArrayOf(9, 4, 6, 2, 8, 5, 7, 3, 1)
        val expected = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        assertArrayEquals(expected, quickSort.sort3Way(array), "The array should be sorted in ascending order.")
    }

    @Test
    fun `Test Counting Sort with positive integers`() {
        val array = intArrayOf(4, 2, 2, 8, 3, 3, 1)
        val expected = intArrayOf(1, 2, 2, 3, 3, 4, 8)
        assertArrayEquals(expected, countingSort.sort(array), "The array should be sorted in ascending order.")
    }

    @Test
    fun `Test Counting Sort with a single value`() {
        val array = intArrayOf(1, 1, 1, 1)
        val expected = intArrayOf(1, 1, 1, 1)
        assertArrayEquals(
            expected,
            countingSort.sort(array),
            "The array of identical elements should remain unchanged."
        )
    }

    @Test
    fun `Test Heap Sort with randomly ordered array`() {
        val array = intArrayOf(38, 27, 43, 3, 9, 82, 10)
        val expected = intArrayOf(3, 9, 10, 27, 38, 43, 82)

        heapSort.sort(array)

        assertArrayEquals(expected, array, "The array should be sorted in ascending order.")
    }

    @Test
    fun `Test Heap Sort with already sorted array`() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        val expected = intArrayOf(1, 2, 3, 4, 5)

        heapSort.sort(array)

        assertArrayEquals(expected, array, "The already sorted array should remain unchanged.")
    }

    @Test
    fun `Test Heap Sort with reverse ordered array`() {
        val array = intArrayOf(5, 4, 3, 2, 1)
        val expected = intArrayOf(1, 2, 3, 4, 5)

        heapSort.sort(array)

        assertArrayEquals(expected, array, "The reverse sorted array should be sorted in ascending order.")
    }

    @Test
    fun `Test Heap Sort with array containing duplicate values`() {
        val array = intArrayOf(4, 2, 2, 8, 3, 3, 1)
        val expected = intArrayOf(1, 2, 2, 3, 3, 4, 8)

        heapSort.sort(array)

        assertArrayEquals(expected, array, "The array with duplicate values should be sorted correctly.")
    }

    @Test
    fun `Test Heap Sort with single element array`() {
        val array = intArrayOf(10)
        val expected = intArrayOf(10)

        heapSort.sort(array)

        assertArrayEquals(expected, array, "The single-element array should remain unchanged.")
    }

    @Test
    fun `Test Heap Sort with empty array`() {
        val array = intArrayOf()
        val expected = intArrayOf()

        heapSort.sort(array)

        assertArrayEquals(expected, array, "The empty array should remain unchanged.")
    }
}