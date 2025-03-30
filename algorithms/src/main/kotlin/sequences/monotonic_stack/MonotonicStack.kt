package sequences.monotonic_stack

import java.util.*

class MonotonicStack {

    fun monotonicStack(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { -1 }
        val stack = Stack<Int>()

        for (i in nums.indices) {
            while (stack.isNotEmpty() && nums[i] > nums[stack.peek()]) {
                val index = stack.pop()
                result[index] = nums[i]
            }
            stack.push(i)
        }

        return result
    }
}