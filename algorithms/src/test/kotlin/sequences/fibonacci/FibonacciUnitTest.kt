package sequences.fibonacci

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FibonacciUnitTest {
    private val fibonacci = Fibonacci()

    @Test
    fun `Fibonacci Recursive`() {
        assertEquals(610, fibonacci.fibonacciRecursive(15))
    }

    @Test
    fun `Fibonacci Memoization`() {
        assertEquals(610, fibonacci.fibonacciMemoization(15))
    }

    @Test
    fun `Fibonacci Tabulation`() {
        assertEquals(610, fibonacci.fibonacciTabulation(15))
    }

    @Test
    fun `Fibonacci Space Optimization`() {
        assertEquals(610, fibonacci.fibonacciSpaceOptimized(15))
    }

    @Test
    fun `Fibonacci Closed-Form Formula (Binet's Formula)`() {
        assertEquals(610, fibonacci.fibonacciClosedForm(15))
    }


}