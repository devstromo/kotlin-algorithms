package sequences.maximum_sub_array

/**
 * This class solves the **Maximum Subarray Problem**, which involves finding the contiguous subarray within a given
 * one-dimensional array `A[1...n]` that has the largest possible sum.
 *
 * The subarray must consist of consecutive elements from the original array, and the objective is to return the maximum sum
 * that can be obtained from such a subarray. This problem is often solved using algorithms like Kadane's Algorithm.
 *
 */
class MaximumSubArray {

    fun maximumSubArray(nums: IntArray): Int {
        var maxSum = Int.MIN_VALUE

        for (i in nums.indices) {
            var currentSum = 0
            for (j in i until nums.size) {
                currentSum += nums[j]
                maxSum = maxOf(maxSum, currentSum)
            }
        }

        return maxSum
    }

    fun maximumSubArrayKadane(nums: IntArray): Int {
        var maxSum = nums[0]
        var maxLocal = nums[0]
        val n = nums.size

        for (i in 1 until n) {
            maxLocal = maxOf(nums[i], nums[i] + maxLocal)
            if (maxLocal > maxSum) {
                maxSum = maxLocal
            }
        }

        return maxSum
    }

}