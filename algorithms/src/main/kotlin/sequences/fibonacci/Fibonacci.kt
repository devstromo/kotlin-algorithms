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
}
