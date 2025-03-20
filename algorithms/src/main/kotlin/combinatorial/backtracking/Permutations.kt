package combinatorial.backtracking

/**
 * Generates all permutations of a given list of numbers using backtracking.
 *
 * This is useful for combinatorial problems, such as generating permutations, combinations, or subsets.
 *
 * See: [Backtracking](https://en.wikipedia.org/wiki/Backtracking)
 */
class Permutations {
    /**
     * Generates all permutations of the given list.
     *
     * @param nums The list of numbers to permute.
     * @return A list of all possible permutations.
     */
    fun generatePermutations(nums: List<Int>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        backtrack(nums, mutableListOf(), BooleanArray(nums.size), result)
        return result
    }

    /**
     * Helper function for backtracking.
     */
    private fun backtrack(
        nums: List<Int>,
        current: MutableList<Int>,
        used: BooleanArray,
        result: MutableList<List<Int>>
    ) {
        if (current.size == nums.size) {
            result.add(ArrayList(current))
            return
        }

        for (i in nums.indices) {
            if (used[i]) continue

            used[i] = true
            current.add(nums[i])

            backtrack(nums, current, used, result)

            // Backtrack step
            used[i] = false
            current.removeAt(current.size - 1)
        }
    }
}
