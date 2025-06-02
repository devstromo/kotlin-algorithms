package dp.kadane

/**
 * Implements Kadane's Algorithm to find the maximum sum of a contiguous subarray.
 *
 * Kadane's Algorithm is a dynamic programming approach that runs in linear time.
 *
 * See: [Kadane's Algorithm](https://en.wikipedia.org/wiki/Maximum_subarray_problem)
 */
class Kadane {

    /**
     * Finds the maximum sum of a contiguous subarray.
     *
     * @param nums The input array.
     * @return The maximum subarray sum.
     */
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = Int.MIN_VALUE
        var sum = 0
        nums.indices.forEach { i ->
            if (sum < 0) sum = nums[i] else sum += nums[i]
            maxSum = maxOf(maxSum, sum)
        }
        return maxSum
    }
}