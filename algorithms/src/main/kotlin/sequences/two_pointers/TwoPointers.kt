package sequences.two_pointers

class TwoPointers {

    fun twoPointers(nums: IntArray, target: Int): IntArray {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return intArrayOf(left, right)
            } else if (nums[left] + nums[right] < target) {
                left++
            } else {
                right--
            }
        }
        return intArrayOf(-1, -1)
    }
}