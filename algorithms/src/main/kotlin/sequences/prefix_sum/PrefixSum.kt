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
        for (i in left..right) {
            sum += nums[i]
        }
        return sum
    }

    fun findMaxLength(nums: IntArray): Int {
        val n = nums.size
        val prefixSumIndex = IntArray(2 * n + 1) { -2 }
        prefixSumIndex[n] = -1

        var maxLength = 0
        var prefixSum = 0

        for (i in nums.indices) {
            prefixSum += if (nums[i] == 0) -1 else 1

            val adjustedIndex = prefixSum + n

            if (prefixSumIndex[adjustedIndex] >= -1) {
                maxLength = maxOf(maxLength, i - prefixSumIndex[adjustedIndex])
            } else {
                prefixSumIndex[adjustedIndex] = i
            }
        }

        return maxLength
    }
}