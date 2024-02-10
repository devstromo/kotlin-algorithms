package sorting.shell

class ShellSort {
    /**
     * Sorts an array of integers in ascending order using the Shell Sort algorithm.
     *
     * Shell Sort improves on insertion sort by breaking the original list into a number of smaller sublists,
     * each of which is sorted using an insertion sort. The unique way that these sublists are chosen is the key to
     * the Shell Sort's performance: instead of breaking the list into sublists of contiguous items, the Shell Sort
     * uses an increment 'i', sometimes called the gap, to create a sublist by choosing all items that are 'i' items apart.
     *
     * @param data The array of integers to be sorted.
     * @return The sorted array in ascending order.
     *
     * Time Complexity:
     * - Worst-case: Depends on the gap sequence, the best known is O(n(log n)^2).
     * - Average-case: Depends on the gap sequence.
     * - Best-case: O(n log n) for certain gap sequences.
     *
     * Space Complexity: O(1), as Shell Sort sorts the array in place and does not require significant additional storage.
     */
    fun sort(data: IntArray): IntArray {
        var gap = data.size / 2
        while (gap > 0) {
            for (i in gap until data.size) {
                val temp = data[i]
                var j = i
                while (j >= gap && data[j - gap] > temp) {
                    data[j] = data[j - gap]
                    j -= gap
                }
                data[j] = temp
            }
            gap /= 3
        }
        return data
    }
}