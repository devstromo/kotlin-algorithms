package sequences.sliding_window

import kotlin.math.max

class SlidingWindow {
    fun slidingWindow(nums: IntArray, k: Int): Int {
        val n = nums.size
        if (n < k) {
            return -1
        }
        var maxSum = 0
        for (i in 0 until k) maxSum += nums[i]

        var windowSum = maxSum
        for (i in k until n) {
            windowSum += nums[i] - nums[i - k]
            maxSum = max(maxSum, windowSum)
        }

        return maxSum
    }

    fun slidingWindowBruteForce(nums: IntArray, k: Int): Int {
        val n = nums.size
        if (n < k) {
            return -1
        }
        var maxSum = Int.MIN_VALUE
        for (i in 0 until n - k + 1) {
            var currentSum = 0
            for (j in 0 until k) currentSum += nums[i + j]

            maxSum = max(currentSum, maxSum)
        }

        return maxSum
    }
}