package sequences.prefix_sum

class PrefixSum {
    fun sumRange(nums: IntArray, left: Int, right: Int): Int {
        val n = nums.size
        val prefixSum = IntArray(n)
        prefixSum[0] = nums[0]
        for (i in 1 until n) {
            prefixSum[i] = nums[i] + prefixSum[i - 1]
        }
        return if (left > 0) {
            prefixSum[right] - prefixSum[left - 1]
        } else {
            prefixSum[right]
        }
    }

    fun sumRangeNoAdditionalSpace(nums: IntArray, left: Int, right: Int): Int {
        var sum = 0
        for (i in left .. right) {
            sum += nums[i]
        }
        return sum
    }
}