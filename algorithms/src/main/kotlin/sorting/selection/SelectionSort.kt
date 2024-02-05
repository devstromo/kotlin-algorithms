package sorting.selection

class SelectionSort {
    /**
     * Sorts an array of integers in ascending order using the Selection Sort algorithm and returns the sorted array.
     *
     * Selection Sort iterates over the array, and for each position, it finds the smallest element in the unsorted region
     * and swaps it with the element at the current position. This process is repeated until the entire array is sorted.
     *
     * @param data The array of integers to be sorted.
     * @return The sorted array in ascending order.
     *
     * Time Complexity:
     * - Worst-case: O(n^2), where n is the number of elements in the array. The algorithm makes n^2/2 comparisons and n swaps.
     * - Average-case: O(n^2), due to the need for roughly n^2/2 comparisons across all cases.
     * - Best-case: O(n^2), the same as the worst-case because even when the array is sorted, the algorithm still makes the same
     *   number of comparisons to verify the order.
     *
     * Space Complexity: O(1), as Selection Sort sorts the array in place and requires no additional storage that is proportional
     * to the size of the input array.
     */
    fun sort(data: IntArray): IntArray {
        for (i in data.indices) {
            var minIndex = i
            for (j in i + 1 until data.size) {
                if (data[j] < data[minIndex]) {
                    minIndex = j
                }
            }
            val temp = data[i]
            data[i] = data[minIndex]
            data[minIndex] = temp
        }
        return data
    }

}