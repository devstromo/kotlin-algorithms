package dp.knapsack

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Knapsack01UnitTest {
    private val solver = Knapsack01()

    @Test
    fun `Test max value with basic input`() {
        val weights = intArrayOf(1, 2, 3)
        val values = intArrayOf(10, 15, 40)
        val capacity = 6
        val expected = 65
        val result = solver.maxKnapsackValue(weights, values, capacity)
        assertEquals(expected, result)
    }

    @Test
    fun `Test zero capacity returns zero`() {
        val weights = intArrayOf(1, 2, 3)
        val values = intArrayOf(10, 15, 40)
        val capacity = 0
        val expected = 0
        val result = solver.maxKnapsackValue(weights, values, capacity)
        assertEquals(expected, result)
    }

    @Test
    fun `Test empty items returns zero`() {
        val weights = intArrayOf()
        val values = intArrayOf()
        val capacity = 10
        val expected = 0
        val result = solver.maxKnapsackValue(weights, values, capacity)
        assertEquals(expected, result)
    }

    @Test
    fun `Test capacity smaller than any item`() {
        val weights = intArrayOf(5, 6, 7)
        val values = intArrayOf(10, 20, 30)
        val capacity = 4
        val expected = 0
        val result = solver.maxKnapsackValue(weights, values, capacity)
        assertEquals(expected, result)
    }
}