package searching.binary

class BinarySearch {

    /**
     * Performs a binary search to find the index of a target value within a sorted array.
     *
     * Binary search compares the target value to the middle element of the array. If they are not equal,
     * the half in which the target cannot lie is eliminated, and the search continues on the remaining half,
     * again taking the middle element to compare to the target value, and repeating this process until the target
     * value is found. If the search ends with the remaining half being empty, the target is not in the array.
     *
     * @param data The sorted array of integers to search through. The array must be sorted in ascending order.
     * @param target The integer value to search for in the array.
     * @return The index of the target value in the array if found; otherwise, -1.
     *
     * Time Complexity: O(log n), where n is the number of elements in the array. Binary search divides the search
     * interval in half each time, making the search logarithmically fast even for large arrays.
     *
     * Space Complexity: O(1), as the search is performed in place and does not require additional storage that is
     * proportional to the input array size.
     */
    fun search(data: IntArray, target: Int): Int {
        var low = 0
        var high = data.size - 1

        while (low <= high) {
            val mid = low + (high - low) / 2
            when {
                data[mid] == target -> return mid
                data[mid] < target -> low = mid + 1
                else -> high = mid - 1
            }
        }
        return -1
    }

    /**
     * Initiates a recursive binary search to find the index of a target value within a sorted array.
     *
     * This function is a wrapper that calls the recursive implementation of binary search, providing
     * the initial parameters such as the start and end indices of the array. The array must be sorted
     * in ascending order for the binary search algorithm to work correctly.
     *
     * @param data The sorted array of integers to search through.
     * @param target The integer value to search for in the array.
     * @return The index of the target value in the array if found; otherwise, -1.
     *
     * Time Complexity: O(log n), where n is the number of elements in the array. The recursive approach
     * divides the problem space in half with each call, leading to logarithmic time complexity.
     *
     * Space Complexity: O(log n), due to the recursive call stack. Each recursive call adds a layer to the
     * call stack, with the maximum depth of the recursion being proportional to the logarithm of the array size.
     */
    fun searchRecursive(data: IntArray, target: Int): Int {
        return search(data, 0, data.size - 1, target)
    }

    /**
     * Performs a recursive binary search to find the index of a target value within a segment of a sorted array.
     *
     * This private helper function recursively divides the search interval in half, comparing the target value
     * to the middle element of the interval. It continues to narrow down the search interval based on whether
     * the target is greater or lesser than the middle element, until the target is found or the interval is empty.
     *
     * @param data The sorted array of integers to search through.
     * @param low The starting index of the segment of the array to search through.
     * @param high The ending index of the segment of the array to search through.
     * @param target The integer value to search for in the array.
     * @return The index of the target value in the segment of the array if found; otherwise, -1.
     */
    private fun search(data: IntArray, low: Int, high: Int, target: Int): Int {
        if (low > high) return -1
        val mid = low + (high - low) / 2
        if (data[mid] == target) return mid
        return if (data[mid] > target) search(data, low, mid - 1, target)
        else search(data, mid + 1, high, target)
    }
}