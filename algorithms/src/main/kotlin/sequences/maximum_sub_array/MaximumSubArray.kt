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

    fun maximumSubArray(input: IntArray): Int {
        var maxSum = Int.MIN_VALUE

        for (i in input.indices) {
            var currentSum = 0
            for (j in i until input.size) {
                currentSum += input[j]
                maxSum = maxOf(maxSum, currentSum)
            }
        }

        return maxSum
    }

}