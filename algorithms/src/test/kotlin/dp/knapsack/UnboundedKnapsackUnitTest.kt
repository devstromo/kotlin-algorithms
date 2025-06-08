package dp.knapsack

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UnboundedKnapsackUnitTest {

    private val solver = UnboundedKnapsack()

    @Test
    fun `Test unbounded knapsack basic case`() {
        val weights = intArrayOf(2, 3, 4)
        val values = intArrayOf(40, 50, 60)
        val capacity = 8
        val expected = 160 // Two items of weight 4 (60 + 60)
        assertEquals(expected, solver.maxKnapsackValue(weights, values, capacity))
    }

    @Test
    fun `Test unbounded knapsack with capacity zero`() {
        val weights = intArrayOf(1, 2, 3)
        val values = intArrayOf(10, 20, 30)
        val capacity = 0
        val expected = 0
        assertEquals(expected, solver.maxKnapsackValue(weights, values, capacity))
    }

    @Test
    fun `Test unbounded knapsack with empty items`() {
        val weights = intArrayOf()
        val values = intArrayOf()
        val capacity = 10
        val expected = 0
        assertEquals(expected, solver.maxKnapsackValue(weights, values, capacity))
    }

    @Test
    fun `Test unbounded knapsack all items too heavy`() {
        val weights = intArrayOf(11, 12)
        val values = intArrayOf(100, 120)
        val capacity = 10
        val expected = 0
        assertEquals(expected, solver.maxKnapsackValue(weights, values, capacity))
    }

    @Test
    fun `Test unbounded knapsack multiple combinations`() {
        val weights = intArrayOf(5, 10, 15)
        val values = intArrayOf(10, 30, 20)
        val capacity = 100
        val expected = 300 // ten 10-weight items worth 30 each
        assertEquals(expected, solver.maxKnapsackValue(weights, values, capacity))
    }
}