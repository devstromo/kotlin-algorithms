package sorting.bubble

class BubbleSort {
    /**
     * Sorts an array of integers in ascending order using the Bubble Sort algorithm and returns the sorted array.
     * Bubble Sort is a simple yet inefficient sorting algorithm for most large datasets. It repeatedly steps through
     * the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list
     * is repeated until no swaps are needed, which means the list is sorted.
     *
     * @param data The array of integers to be sorted.
     * @return The same array, sorted in ascending order.
     *
     * Time Complexity:
     * - Worst-case: O(n^2), where n is the number of elements in the array. This worst-case scenario occurs when
     *   the array is in reverse order, and we need to make n(n-1)/2 comparisons and swaps.
     * - Best-case: O(n) when the array is already sorted, and only one pass is needed with no swaps.
     * - Average-case: O(n^2), due to the need for nearly n(n-1)/2 comparisons and swaps on average.
     *
     * Space Complexity: O(1), as the sorting is done in-place, requiring no additional storage proportional to the
     * array's size.
     *
     * @sample
     * val array = intArrayOf(5, 3, 8, 4, 2)
     * println(bubbleSort(array).joinToString(", ")) // Output: 2, 3, 4, 5, 8
     */
    fun sort(data: IntArray): IntArray {
        val n = data.size
        var swapped: Boolean
        do {
            swapped = false
            for (i in 1 until n) {
                if (data[i - 1] > data[i]) {
                    // Swap the elements
                    data.swap(i - 1, i)
                    swapped = true
                }
            }
            // If no two elements were swapped by inner loop, then break
        } while (swapped)
        return data
    }

    /**
     * Swaps two elements in an array.
     *
     * @param i The index of the first element to swap.
     * @param j The index of the second element to swap.
     */
    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}