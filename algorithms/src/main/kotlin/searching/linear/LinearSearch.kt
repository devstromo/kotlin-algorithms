package searching.linear

class LinearSearch {

    /**
     * Performs a linear search to find the index of a target value within an array.
     *
     * This method iterates over all elements in the given array, comparing each element
     * with the target value. If a match is found, the index of the matching element is
     * returned. If no match is found after checking all elements, the method returns -1.
     *
     * @param data The array of integers to search through.
     * @param target The integer value to search for in the array.
     * @return The index of the target value in the array if found; otherwise, -1.
     *
     * Time Complexity: O(n), where n is the number of elements in the array. In the worst case,
     * every element in the array needs to be checked, making the time complexity linear in relation
     * to the size of the input array.
     *
     * Space Complexity: O(1), as the search is performed in place and does not require additional
     * storage proportional to the input array size.
     */
    fun search(data: IntArray, target: Int): Int {
        for (index in data.indices)
            if (data[index] == target)
                return index
        return -1
    }
}