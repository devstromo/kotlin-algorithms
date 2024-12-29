package sequences.modified_binary_search

class ModifiedBinarySearch {
    fun searchInRotatedArray(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2

            if (nums[mid] == target) {
                return mid // Target found
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    // Target lies within the left sorted half
                    right = mid - 1
                } else {
                    // Target is in the other half
                    left = mid + 1
                }
            } else {
                // The right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    // Target lies within the right sorted half
                    left = mid + 1
                } else {
                    // Target is in the other half
                    right = mid - 1
                }
            }
        }

        return -1 // Target not found
    }
}