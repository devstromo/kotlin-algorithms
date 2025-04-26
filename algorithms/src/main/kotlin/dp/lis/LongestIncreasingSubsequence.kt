package dp.lis

class LongestIncreasingSubsequence {
    fun lis(nums: IntArray): Int {
        val n = nums.size
        val lis = IntArray(n)
        var j: Int
        var max = Int.Companion.MIN_VALUE
        var i = 0
        while (i < n) {
            lis[i] = 1
            i++
        }

        i = 1
        while (i < n) {
            j = 0
            while (j < i) {
                if (nums[j] < nums[i] && lis[j] + 1 > lis[i]) lis[i] = lis[j] + 1
                j++
            }
            i++
        }
        i = 0
        while (i < n) {
            if (max < lis[i]) max = lis[i]
            i++
        }

        return max
    }
}