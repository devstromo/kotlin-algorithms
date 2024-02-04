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
            if (data[mid] == target) {
                return mid
            } else if (data[mid] > target) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return -1
    }

    fun searchRecursive(data: IntArray, target: Int): Int {
        return search(data, 0, data.size - 1, target)
    }

    private fun search(data: IntArray, low: Int, high: Int, target: Int): Int {
        if (low > high) return -1
        val mid = low + (high - low) / 2
        if (data[mid] == target) return mid
        return if (data[mid] > target) search(data, low, mid - 1, target)
        else search(data, mid + 1, high, target)
    }
}