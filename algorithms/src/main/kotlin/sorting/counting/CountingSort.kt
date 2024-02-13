package sorting.counting

class CountingSort {
    /**
     * Sorts an array of integers using the Counting Sort algorithm.
     *
     * Counting Sort is an efficient algorithm for sorting a collection of objects according to keys that are small integers.
     * It works by counting the number of objects having distinct key values, and applying prefix sum calculation to determine
     * the positions of each key value in the output sequence, providing a stable sort.
     *
     * @param data The array of non-negative integers to be sorted. Note: This implementation assumes that the input consists
     * of non-negative integers.
     * @return The sorted array in ascending order.
     *
     * Time Complexity:
     * - Worst-case: O(n + k), where n is the number of elements in the array and k is the range of the input.
     * - Average-case: O(n + k), as the algorithm processes each input element exactly once.
     * - Best-case: O(n + k), consistent across all scenarios.
     *
     * Space Complexity: O(n + k), for the output array and the counting array.
     */
    fun sort(data: IntArray): IntArray {
        if (data.isEmpty()) return intArrayOf()

        val max = data.maxOrNull() ?: 0 // Find the maximum value to know the counting array size
        val count = IntArray(max + 1)
        val output = IntArray(data.size)

        // Count each element
        for (num in data) count[num]++

        // Compute the prefix sum
        for (i in 1 until count.size) count[i] += count[i - 1]

        // Build the output array
        for (num in data.reversed()) { // Iterate in reverse for stable sorting
            output[count[num] - 1] = num
            count[num]--
        }

        return output
    }
}