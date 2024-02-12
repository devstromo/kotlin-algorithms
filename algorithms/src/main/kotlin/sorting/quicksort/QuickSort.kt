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
     * Time Complexity:
     * - Worst-case: O(n^2), where n is the number of elements in the array. The worst case occurs when the partition process always picks greatest or smallest element as pivot.
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

    /**
     * Randomly shuffles the elements of an array.
     *
     * @param data The array to be shuffled.
     */
    fun shuffle(data: IntArray) {
        val rnd = java.util.Random()
        for (i in data.indices) {
            val randomIndex = i + rnd.nextInt(data.size - i)
            data.swap(i, randomIndex)
        }
    }

}