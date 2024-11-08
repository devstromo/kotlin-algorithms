package sequences.top_k_elements

import trees.heaps.MaxHeap

class TopKElements {
    fun topKElements(nums: IntArray, k: Int): Int {
        val maxHeap = MaxHeap<Int>()
        for (num in nums) {
            maxHeap.insert(num)
        }
        var i = 0
        while (i++ < k) {
            maxHeap.pop()
        }
        return maxHeap.peek()!!
    }
}