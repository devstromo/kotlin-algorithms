package sorting.merge

class MergeSort {
    /**
     * Sorts an array of integers using the Merge Sort algorithm.
     *
     * Merge Sort is a divide and conquer algorithm that divides the input array into two halves,
     * calls itself for the two halves, and then merges the two sorted halves. The merge step
     * is a key process that assumes that the two halves are sorted and merges them into a single
     * sorted array.
     *
     * @param data The array of integers to be sorted.
     * @return The sorted array in ascending order.
     *
     * Time Complexity:
     * - Worst-case: O(n log n), where n is the number of elements in the array.
     * - Average-case: O(n log n), consistent across all cases.
     * - Best-case: O(n log n), as the divide and conquer strategy involves log n levels of splitting
     *   and merging, each of which is linear across the array's length.
     *
     * Space Complexity: O(n), due to the temporary arrays used in the merge step, which require
     * additional storage proportional to the size of the input array.
     */
    fun sort(data: IntArray): IntArray {
        if (data.size < 2) return data
        val middle = data.size / 2
        val left = data.copyOfRange(0, middle)
        val right = data.copyOfRange(middle, data.size)

        return merge(sort(left), sort(right))
    }

    /**
     * Merges two sorted arrays into a single sorted array.
     */
    private fun merge(left: IntArray, right: IntArray): IntArray {
        var i = 0
        var j = 0
        val merged = IntArray(left.size + right.size)

        while (i < left.size && j < right.size) {
            if (left[i] < right[j]) {
                merged[i + j] = left[i]
                i++
            } else {
                merged[i + j] = right[j]
                j++
            }
        }

        while (i < left.size) {
            merged[i + j] = left[i]
            i++
        }

        while (j < right.size) {
            merged[i + j] = right[j]
            j++
        }

        return merged
    }
}