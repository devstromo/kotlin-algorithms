package sequences.fibonacci


class Fibonacci {

    /**
     * Calculates the nth Fibonacci number using a recursive approach.
     *
     * @param n The position in the Fibonacci sequence to compute. It should be a non-negative integer.
     * @return The nth Fibonacci number.
     *
     * This function computes the nth Fibonacci number recursively.
     * It calls itself for the two previous numbers in the sequence until it reaches the base cases
     * (0 or 1). This approach is straightforward but not efficient for large values of n due to
     * exponential time complexity.
     *
     * Time Complexity: O(2^n), where n is the input parameter.
     * The function's time complexity is exponential due to the repeated recalculations of the
     * same Fibonacci numbers in each recursive call.
     *
     * Note: This method is not suitable for large values of n, as it can lead to a stack overflow
     * error and high computational time. For large n, consider using a dynamic programming approach.
     */
    fun fibonacciRecursive(n: Int): Int {
        if (n <= 1) return n
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2)
    }

    /**
     * Calculates the nth Fibonacci number using a memoization approach to optimize recursive calls.
     *
     * Memoization is a technique for improving the performance of recursive algorithms by storing
     * the results of expensive function calls and returning the cached result when the same inputs
     * occur again.
     *
     * @param n The position in the Fibonacci sequence to compute. Must be a non-negative integer.
     * @param memo An optional pre-initialized array for memoization. Defaults to an array filled with -1,
     * indicating that no values have been computed and stored yet. The size of the array is `n + 1` to store
     * computed values for all positions up to `n`.
     * @return The nth Fibonacci number.
     *
     * Time Complexity: O(n), where n is the input parameter. This improvement over the simple recursive
     * approach is due to the fact that each Fibonacci number is calculated once and stored for subsequent
     * retrieval, reducing the number of calculations from exponential to linear.
     *
     * Space Complexity: O(n), due to the memoization array that stores computed values for each Fibonacci
     * number up to n.
     */
    fun fibonacciMemoization(n: Int, memo: IntArray = IntArray(n + 1) { -1 }): Int {
        if (n <= 1) return n
        if (memo[n] != -1) return memo[n]
        memo[n] = fibonacciMemoization(n - 1, memo) + fibonacciMemoization(n - 2, memo)
        return memo[n]
    }
}
