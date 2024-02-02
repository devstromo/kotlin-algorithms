package sequences.fibonacci

import kotlin.math.pow
import kotlin.math.sqrt


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

    /**
     * Calculates the nth Fibonacci number using a space-optimized approach.
     *
     * This method improves on the space efficiency of the tabulation method by only keeping track of the last two numbers
     * in the Fibonacci sequence at any point in time. This drastically reduces the space requirement from an array of size n
     * to just two integer variables, without sacrificing the computational efficiency of the dynamic programming approach.
     *
     * @param n The position in the Fibonacci sequence to compute. Must be a non-negative integer.
     * @return The nth Fibonacci number.
     *
     * The function initializes two variables, `a` and `b`, to represent the first two Fibonacci numbers, respectively 0 and 1.
     * It then iterates from 2 up to `n`, updating these variables to hold the last two Fibonacci numbers at each step. This process
     * continues until it reaches the desired position `n` in the sequence. The variable `b` will then hold the nth Fibonacci number,
     * which is returned as the output.
     *
     * Time Complexity: O(n), where n is the input parameter. Similar to the tabulation approach, this method calculates each Fibonacci
     * number once. However, it does so with significantly reduced space complexity.
     *
     * Space Complexity: O(1), a constant space complexity, as the method only requires a fixed amount of space (for the variables `a`, `b`,
     * and `c`) regardless of the input size.
     */
    fun fibonacciSpaceOptimized(n: Int): Int {
        if (n <= 1) return n
        var a = 0
        var b = 1
        var c: Int
        for (i in 2..n) {
            c = a + b
            a = b
            b = c
        }
        return b
    }

    /**
     * Calculates the nth Fibonacci number using the closed-form expression known as Binet's formula.
     *
     * Binet's formula is given by:
     *
     * `F(n) = (phi^n - psi^n) / sqrt(5)`
     *
     * where `phi = (1 + sqrt(5)) / 2` (the golden ratio) and `psi = (1 - sqrt(5)) / 2`.
     * For the purposes of computing Fibonacci numbers, the term involving `psi` is omitted
     * because it tends towards zero for large n, and its effect is negligible, allowing the formula
     * to be simplified to:
     *
     * `F(n) = round(phi^n / sqrt(5))`
     *
     * This method applies this simplified version of Binet's formula, directly calculating the nth Fibonacci number
     * without recursion or iteration. This approach offers significant computational advantages, particularly for large
     * values of n, by enabling constant-time computation.
     *
     * @param n The position in the Fibonacci sequence to compute. Must be a non-negative integer. The method returns
     * a [Long] to accommodate larger Fibonacci numbers.
     * @return The nth Fibonacci number as a [Long].
     *
     * The function calculates the golden ratio, `phi`, raises `phi` to the power of `n`, divides by the square root of 5,
     * and rounds the result to the nearest whole number to derive the nth Fibonacci number. While fast and efficient, this method
     * may experience precision issues for very large values of n due to limitations in floating-point arithmetic.
     *
     * Time Complexity: O(1), as the calculation involves a constant number of operations regardless of the size of n.
     *
     * Space Complexity: O(1), as the method uses a fixed amount of space for its calculations.
     */
    fun fibonacciClosedForm(n: Int): Long {
        val sqrt5 = sqrt(5.0)
        val phi = (1 + sqrt5) / 2
        return Math.round(phi.pow(n.toDouble()) / sqrt5)
    }
}
