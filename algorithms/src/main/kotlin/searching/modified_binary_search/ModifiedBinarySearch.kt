package searching.modified_binary_search

/**
 * Implements Modified Binary Search to find a target in a rotated sorted array.
 *
 * This is useful for solving search problems in rotated sorted arrays.
 *
 * See: [Binary Search](https://en.wikipedia.org/wiki/Binary_search_algorithm)
 */
class ModifiedBinarySearch {
    /**
     * Searches for the target in a rotated sorted array.
     *
     * @param nums The rotated sorted array.
     * @param target The value to search for.
     * @return The index of the target if found, or -1 otherwise.
     */
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val mid = (right - left) / 2 + left
            if (nums[mid] == target) return mid

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target in nums[left]..nums[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            } else { // Right half is sorted
                if (target in nums[mid]..nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }

        return -1
    }
}
