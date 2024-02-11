package sorting.radix

class RadixSort {
    /**
     * Sorts an array of non-negative integers using the Radix Sort algorithm.
     *
     * Radix Sort works by processing individual digits of integer numbers, sorting the array
     * from the least significant digit to the most significant digit using a stable counting
     * sort algorithm for each digit. Note that this implementation only works for non-negative integers.
     *
     * @param data The array of non-negative integers to be sorted.
     * @return The sorted array in ascending order.
     *
     * Time Complexity:
     * - Worst-case: O(nk), where n is the number of elements in the array and k is the number of digits
     *   in the maximum number in the array.
     * - Average-case: O(nk), under the same conditions as the worst-case scenario.
     * - Best-case: O(nk), consistent across all scenarios since every digit of every item needs to be processed.
     *
     * Space Complexity: O(n + k), due to the need for auxiliary storage for the counting sort at each digit level.
     */
    fun sort(data: IntArray): IntArray {
        val max = data.maxOrNull() ?: return data

        var place = 1
        while (max / place > 0) {
            countingSortByDigit(data, place)
            place *= 10
        }
        return data
    }

    /**
     * A helper function for radixSort that performs a counting sort on the array based on the digit
     * represented by 'place'.
     */
    private fun countingSortByDigit(data: IntArray, place: Int) {
        val output = IntArray(data.size)
        val count = IntArray(10) { 0 }

        // Count occurrences of each digit
        for (number in data) {
            val digit = (number / place) % 10
            count[digit]++
        }

        // Change count[i] so it contains the position of this digit in output[]
        for (i in 1 until 10) {
            count[i] += count[i - 1]
        }

        // Build the output array
        for (i in data.indices.reversed()) {
            val digit = (data[i] / place) % 10
            output[count[digit] - 1] = data[i]
            count[digit]--
        }

        // Copy the output array to data[], so that data[] now contains sorted numbers
        for (i in data.indices) {
            data[i] = output[i]
        }
    }
}