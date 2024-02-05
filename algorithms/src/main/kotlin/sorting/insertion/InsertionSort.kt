package sorting.insertion

class InsertionSort {
    /**
     * Sorts an array of integers in ascending order using the Insertion Sort algorithm.
     *
     * Insertion Sort iteratively takes one element from the array and finds its appropriate
     * position within the sorted portion of the array, placing it there. It repeats this process
     * for each element until the whole array is sorted.
     *
     * @param data The array of integers to be sorted.
     * @return The sorted array in ascending order.
     *
     * Time Complexity:
     * - Worst-case: O(n^2), where n is the number of elements in the array.
     * - Average-case: O(n^2), as each element needs to be compared to potentially every other element in the sorted portion.
     * - Best-case: O(n) when the array is already sorted, as only one comparison is needed per element.
     *
     * Space Complexity: O(1), as Insertion Sort sorts the array in place and does not require significant additional storage.
     */
    fun sort(data: IntArray): IntArray {
        for (i in 1 until data.size) {
            val key = data[i]
            var j = i - 1

            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j]
                j = j - 1
            }
            data[j + 1] = key
        }
        return data
    }
}