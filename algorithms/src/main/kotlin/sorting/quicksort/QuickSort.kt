package sorting.quicksort

class QuickSort {
    /**
     * Sorts an array of integers in ascending order using the QuickSort algorithm.
     *
     * QuickSort is a divide-and-conquer algorithm that picks an element as pivot and
     * partitions the given array around the picked pivot. This implementation always picks
     * the last element as the pivot. It's known for its high performance on large datasets,
     * with good average-case time complexity.
     *
     * @param data The array of integers to be sorted.
     * @return The sorted array in ascending order.
     *
     *  where n is the number of elements in the array. The worst case occurs when the partition process always picks greatest or smallest element as pivot.
     *
     * Time Complexity:
     * - Worst-case: O(n log n), random shuffle to avoid O(n^2)
     * - Average-case: O(n log n), due to the split of the array in log n levels and linear work at each level of partitioning.
     * - Best-case: O(n log n), with a good pivot, the array is divided into nearly two equal parts.
     *
     * Space Complexity: O(log n) due to recursive calls in the stack.
     */
    fun sort(data: IntArray): IntArray {
        shuffle(data)
        quickSortHelper(data, 0, data.size - 1)
        return data
    }

    /**
     * Sorts an array of integers in ascending order using an optimized QuickSort algorithm that switches
     * to Insertion Sort for subarrays smaller than a certain threshold.
     *
     * This optimization leverages the efficiency of Insertion Sort for small datasets within the
     * QuickSort algorithm, improving its overall performance, especially for arrays with small subarrays.
     *
     * @param data The array of integers to be sorted.
     * @return The sorted array in ascending order.
     *
     * Time Complexity:
     * - Worst-case: O(n log n), random shuffle to avoid O(n^2)
     * - Average-case: O(n log n), significantly improved for small subarrays due to the insertion sort cutoff.
     * - Best-case: O(n log n), achieved with a good pivot selection strategy.
     *
     * Space Complexity: O(log n), due to recursion stack space, slightly improved with the insertion sort cutoff.
     */
    fun optimizedSort(data: IntArray): IntArray {
        shuffle(data) // Randomly shuffle to guarantee performance
        quickSortWithCutoff(data, 0, data.size - 1)
        return data
    }

    /**
     * Sorts an array of integers using the QuickSort algorithm with 3-way partitioning.
     *
     * This method enhances QuickSort by partitioning the array into three parts:
     * elements less than the pivot, elements equal to the pivot, and elements greater than the pivot.
     * This approach is particularly effective for arrays with many duplicate elements, as it
     * significantly reduces the sorting time by minimizing unnecessary comparisons and swaps.
     * O(n^2) in the rare case of pathological inputs.
     *
     * @param data The array of integers to be sorted.
     * @return The sorted array in ascending order.
     *
     * Time Complexity:
     * - Worst-case: O(n log n) random shuffle to avoid O(n^2)
     * - Average-case: O(n log n), significantly improved for arrays with many duplicates.
     * - Best-case: O(n) for arrays with all or nearly all elements equal.
     *
     * Space Complexity: O(log n) for the recursion stack.
     */
    fun sort3Way(data: IntArray): IntArray {
        shuffle(data)
        quickSort3Way(data, 0, data.lastIndex)
        return data
    }

    private fun quickSort3Way(data: IntArray, lo: Int, hi: Int) {
        if (hi <= lo) return
        var lt = lo
        var gt = hi
        val v = data[lo]
        var i = lo + 1
        while (i <= gt) {
            when {
                data[i] < v -> data.swap(lt++, i++)
                data[i] > v -> data.swap(i, gt--)
                else -> i++
            }
        }
        quickSort3Way(data, lo, lt - 1)
        quickSort3Way(data, gt + 1, hi)
    }

    private fun quickSortHelper(data: IntArray, low: Int, high: Int) {
        if (low < high) {
            val pi = partition(data, low, high)
            quickSortHelper(data, low, pi - 1)
            quickSortHelper(data, pi + 1, high)
        }
    }

    private fun partition(data: IntArray, low: Int, high: Int): Int {
        val pivot = data[high]
        var i = low - 1
        for (j in low until high) {
            if (data[j] < pivot) {
                i++
                data.swap(i, j)
            }
        }
        data.swap(i + 1, high)
        return i + 1
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }


    private fun quickSortWithCutoff(data: IntArray, low: Int, high: Int) {
        val CUTOFF = 10 // Optimal cutoff value can be between 5 and 15
        if (high <= low + CUTOFF - 1) {
            insertionSort(data, low, high)
            return
        }
        val pivotIndex = partition(data, low, high)
        quickSortWithCutoff(data, low, pivotIndex - 1)
        quickSortWithCutoff(data, pivotIndex + 1, high)
    }

    private fun insertionSort(a: IntArray, low: Int, high: Int) {
        for (i in low + 1..high) {
            val value = a[i]
            var j = i
            while (j > low && a[j - 1] > value) {
                a[j] = a[j - 1]
                j--
            }
            a[j] = value
        }
    }


    /**
     * Randomly shuffles the elements of an array.
     *
     * @param data The array to be shuffled.
     */
    private fun shuffle(data: IntArray) {
        val rnd = java.util.Random()
        for (i in data.indices) {
            val randomIndex = i + rnd.nextInt(data.size - i)
            data.swap(i, randomIndex)
        }
    }

}