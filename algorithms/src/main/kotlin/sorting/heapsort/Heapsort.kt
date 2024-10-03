package sorting.heapsort

class Heapsort {
    /**
     * Sorts an array of integers in ascending order using the Heap Sort algorithm.
     *
     * Heap Sort works by first converting the array into a Max Heap and then repeatedly
     * moving the largest element (root of the heap) to the end of the array, reducing
     * the heap size, and re-heapifying the remaining elements.
     *
     * This process continues until the array is fully sorted.
     *
     * **Stability**: Heap Sort is **not stable**. Stability in sorting means that two elements with the same value
     * maintain their relative order from the input in the output. In Heap Sort, due to the way elements are
     * rearranged when the heap is built and re-heapified, elements with the same value might not retain
     * their original order in the sorted output.
     *
     * @param array The array of integers to be sorted.
     *
     * Time Complexity:
     * - Worst-case: O(n log n), where n is the number of elements in the array. Building the heap takes O(n),
     *   and each removal of the max element takes O(log n), repeated for n elements.
     * - Average-case: O(n log n), same as the worst case, since the algorithm behaves similarly in all cases.
     * - Best-case: O(n log n), even in cases where the array is already sorted, heapification still takes log n time.
     *
     * Space Complexity: O(1), as Heap Sort is an in-place sorting algorithm and does not require extra space beyond the input array.
     */
    fun sort(array: IntArray) {
        val n = array.size

        for (i in n / 2 - 1 downTo 0) {
            heapify(array, n, i)
        }

        for (i in n - 1 downTo 0) {
            swap(array, 0, i)

            heapify(array, i, 0)
        }
    }

    private fun heapify(array: IntArray, heapSize: Int, rootIndex: Int) {
        var largest = rootIndex
        val leftChild = 2 * rootIndex + 1
        val rightChild = 2 * rootIndex + 2

        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild
        }

        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild
        }

        if (largest != rootIndex) {
            swap(array, rootIndex, largest)

            heapify(array, heapSize, largest)
        }
    }

    private fun swap(array: IntArray, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}