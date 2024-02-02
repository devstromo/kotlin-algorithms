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

    /**
     * Calculates the nth Fibonacci number using the tabulation (bottom-up) dynamic programming approach.
     *
     * Tabulation is a bottom-up approach to dynamic programming. This method iteratively calculates
     * and stores the Fibonacci numbers in a table (array) from the bottom up. It starts with the base
     * cases and solves for higher numbers based on them.
     *
     * @param n The position in the Fibonacci sequence to compute. Must be a non-negative integer.
     * @return The nth Fibonacci number.
     *
     * This function first checks for the base cases (n = 0 or n = 1). It then initializes an array
     * to hold the Fibonacci numbers up to n, with a default value of 0. The first two Fibonacci numbers
     * (at indices 0 and 1) are set according to the Fibonacci sequence, and the function iterates from 2 to n,
     * filling the array with the sum of the two preceding Fibonacci numbers at each step. The nth Fibonacci
     * number is returned as the output.
     *
     * Time Complexity: O(n), where n is the input parameter. This is a significant improvement over the
     * recursive approach without memoization, as each Fibonacci number up to n is calculated exactly once.
     *
     * Space Complexity: O(n), due to the array used to store the Fibonacci numbers up to n. This space is
     * required to hold the intermediate results of the Fibonacci sequence.
     */
    fun fibonacciTabulation(n: Int): Int {
        if (n <= 1) return n
        val fib = IntArray(n + 1)
        fib[1] = 1
        for (i in 2..n) {
            fib[i] = fib[i - 1] + fib[i - 2]
        }
        return fib[n]
    }
}
