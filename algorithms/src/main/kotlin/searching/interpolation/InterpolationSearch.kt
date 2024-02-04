package searching.interpolation

class InterpolationSearch {
    /**
     * Performs an interpolation search to find the index of a target value within a sorted array.
     *
     * Interpolation search is an algorithm for searching for a key in an array that has been ordered
     * by numerical values assigned to the keys (key values). It is designed to work on uniformly distributed
     * data. It positions the search at higher indexes for higher values and vice versa, potentially reducing
     * the number of comparisons in such cases compared to binary search.
     *
     * @param data The sorted array of integers to search through. The array must be sorted in ascending order.
     * @param target The integer value to search for in the array.
     * @return The index of the target value in the array if found; otherwise, -1.
     *
     * Time Complexity: Average case O(log(log n)), where n is the number of elements in the array. In the worst
     * case, particularly for non-uniform distributions, the complexity can degrade to O(n).
     *
     * Space Complexity: O(1), as the search is performed in place and does not require additional storage
     * that is proportional to the input array size.
     */
    fun search(data: IntArray, target: Int): Int {
        var low = 0
        var high = data.size - 1

        while (low <= high && target >= data[low] && target <= data[high]) {
            if (low == high) {
                if (data[low] == target) return low
                return -1
            }

            // Estimate the position
            val pos = low + ((target - data[low]) * (high - low) / (data[high] - data[low]))
            if (data[pos] == target) return pos
            if (data[pos] < target) low = pos + 1
            else high = pos - 1
        }
        return -1
    }
}