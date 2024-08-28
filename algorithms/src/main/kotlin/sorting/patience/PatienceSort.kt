package sorting.patience

import java.util.*

class PatienceSort {

    /**
     * Sorts an array of integers using the Patience Sorting algorithm.
     *
     * The Patience Sort algorithm builds piles of cards in a similar way to how
     * you would sort a hand of cards. It constructs a series of piles, then
     * uses a priority queue to merge these piles into a sorted array.
     *
     * For more information, see the Wikipedia article on
     * [Patience Sorting](https://en.wikipedia.org/wiki/Patience_sorting).
     *
     * Time Complexity:
     * - O(n log n) for the sorting process, where `n` is the number of elements in the array.
     *   - Each insertion operation in the piles is O(log n) due to binary search.
     *   - There can be up to `n` piles in the worst case.
     * - O(n log k) for the merging process, where `k` is the number of piles.
     *   - Each heap operation (insertion/extraction) is O(log k).
     *
     * Space Complexity:
     * - O(n) for the storage of piles, where `n` is the number of elements.
     * - O(k) for the priority queue, where `k` is the number of piles.
     *
     * @param arr The array of integers to sort.
     * @return A new sorted array containing the same elements as the input array.
     */
    fun sort(arr: IntArray): IntArray {
        // Create a list of stacks to represent piles
        val piles = mutableListOf<Stack<Int>>()

        // Go through each number in the input array
        for (num in arr) {
            // Find the first pile where the top element is greater than the current number
            val pile = piles.binarySearchBy(num) { it.peek() }
            if (pile >= 0) {
                piles[pile].push(num)
            } else {
                val newPile = Stack<Int>()
                newPile.push(num)
                piles.add(-pile - 1, newPile)
            }
        }

        // Retrieve sorted numbers
        val result = IntArray(arr.size)
        var index = 0

        // Use a priority queue to merge piles
        val pq = PriorityQueue<Pair<Int, Stack<Int>>>(compareBy { it.first })
        for (pile in piles) {
            pq.add(Pair(pile.pop(), pile))
        }

        while (pq.isNotEmpty()) {
            val (smallest, pile) = pq.poll()
            result[index++] = smallest
            if (pile.isNotEmpty()) {
                pq.add(Pair(pile.pop(), pile))
            }
        }

        return result
    }
}