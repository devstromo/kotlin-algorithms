package searching.exponential

class ExponentialSearch {
    /**
     * Performs an exponential search on a sorted array to find the index of a given target value.
     *
     * Exponential search involves two main steps:
     * 1. Finding the range where the target value might be present by exponentially increasing the index.
     * 2. Performing a binary search in the found range.
     *
     * @param data The sorted array of integers to search through. The array must be sorted in ascending order.
     * @param target The integer value to search for in the array.
     * @return The index of the target value in the array if found; otherwise, -1.
     *
     * Time Complexity: O(log n), where n is the position of the target value. The search quickly narrows down
     * the possible range using exponential steps, and then binary search performs in logarithmic time within that range.
     *
     * Space Complexity: O(1), as the search is performed in place and does not require significant additional storage.
     */
    fun search(data: IntArray, target: Int): Int {
        if (data.isEmpty()) return -1
        if (data[0] == target) return 0

        var bound = 1
        while (bound < data.size && data[bound] < target) {
            bound *= 2
        }

        return binarySearch(data, target, bound / 2, minOf(bound, data.size - 1))
    }

    /**
     * Helper function to perform binary search. Assumes input range [low, high] is valid.
     *
     * @param data The sorted array of integers.
     * @param target The target value to search for.
     * @param low The lower bound of the range.
     * @param high The upper bound of the range.
     * @return The index of the target value if found; otherwise, -1.
     */
    private fun binarySearch(data: IntArray, target: Int, low: Int, high: Int): Int {
        var lowVar = low
        var highVar = high
        while (lowVar <= highVar) {
            val mid = lowVar + (highVar - lowVar) / 2
            when {
                data[mid] == target -> return mid
                data[mid] < target -> lowVar = mid + 1
                else -> highVar = mid - 1
            }
        }
        return -1
    }
}