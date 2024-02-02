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


}