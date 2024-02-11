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
     * Optimizes Merge Sort by using Insertion Sort for small subarrays, checking if the array
     * is already in order, and eliminating unnecessary copying to auxiliary arrays.
     *
     * @param data The array of integers to be sorted.
     * @return The sorted array in ascending order.
     *
     * Time Complexity:
     * - Worst-case: O(n log n), improved by optimizations for small arrays and nearly sorted arrays.
     * - Best-case: O(n) if the array is already sorted (due to the order check).
     *
     * Space Complexity: O(n), primarily for the auxiliary space used in merging.
     */
    fun optimizedMergeSort(data: IntArray): IntArray {
        val aux = data.copyOf()
        sort(data, aux, 0, data.size - 1)
        return data
    }

    /**
     * Sorts an array of integers in ascending order using the Bottom-Up Merge Sort algorithm.
     *
     * This iterative version of Merge Sort starts with small subarrays of size 1, merging them into
     * ordered subarrays of size 2, then merges those into subarrays of size 4, and so on, until the whole
     * array is sorted. This approach does not require recursion.
     *
     * @param data The array of integers to be sorted.
     * @return The sorted array in ascending order.
     *
     * Time Complexity:
     * - Worst-case: O(n log n), where n is the number of elements in the array.
     * - Average-case: O(n log n), consistent across all cases.
     * - Best-case: O(n log n), as even in the best case, the entire array must be merged.
     *
     * Space Complexity: O(n), due to the temporary arrays used in the merge step, requiring
     * additional storage proportional to the size of the input array.
     */
    fun bottomUpMergeSort(data: IntArray): IntArray {
        val n = data.size
        val aux = IntArray(n)
        var sz = 1
        while (sz < n) {
            var low = 0
            while (low < n - sz) {
                mergeBottomUp(data, aux, low, low + sz - 1, minOf(low + sz + sz - 1, n - 1))
                low += sz + sz
            }
            sz += sz
        }
        return data
    }

    private fun sort(data: IntArray, aux: IntArray, low: Int, high: Int) {
        if (high <= low) return

        // Use Insertion Sort for small subarrays for better performance.
        val CUTOFF = 15
        if (high <= low + CUTOFF - 1) {
            insertionSort(data, low, high)
            return
        }

        val mid = low + (high - low) / 2
        sort(aux, data, low, mid)
        sort(aux, data, mid + 1, high)

        // Check if the array is already in order to skip the merge.
        if (aux[mid] <= aux[mid + 1]) {
            System.arraycopy(aux, low, data, low, high - low + 1)
            return
        }

        merge(data, aux, low, mid, high)
    }

    /**
     * Merges two sorted subarrays into a single sorted subarray.
     */
    private fun merge(data: IntArray, aux: IntArray, low: Int, mid: Int, high: Int) {
        var i = low
        var j = mid + 1
        for (k in low..high) {
            when {
                i > mid -> data[k] = aux[j++]
                j > high -> data[k] = aux[i++]
                aux[j] < aux[i] -> data[k] = aux[j++]
                else -> data[k] = aux[i++]
            }
        }
    }

    /**
     * Sorts a subarray using Insertion Sort.
     */
    private fun insertionSort(a: IntArray, low: Int, high: Int) {
        for (i in low..high) {
            var j = i
            while (j > low && a[j] < a[j - 1]) {
                a.swap(j, j - 1)
                j--
            }
        }
    }

    /**
     * Swaps two elements in an array.
     */
    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
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

    /**
     * Merges two sorted subarrays into a single sorted subarray.
     */
    private fun mergeBottomUp(data: IntArray, aux: IntArray, low: Int, mid: Int, high: Int) {
        System.arraycopy(data, low, aux, low, high - low + 1)

        var i = low
        var j = mid + 1
        for (k in low..high) {
            when {
                i > mid -> data[k] = aux[j++]
                j > high -> data[k] = aux[i++]
                aux[j] < aux[i] -> data[k] = aux[j++]
                else -> data[k] = aux[i++]
            }
        }
    }
}