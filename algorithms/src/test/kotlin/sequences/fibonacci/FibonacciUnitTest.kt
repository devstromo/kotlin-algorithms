package sequences.fibonacci

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FibonacciUnitTest {
    private val fibonacci = Fibonacci()

    @Test
    fun `Fibonacci Recursive`() {
        assertEquals(610, fibonacci.fibonacciRecursive(15))
    }

}