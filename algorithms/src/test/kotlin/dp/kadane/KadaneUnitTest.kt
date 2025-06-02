package dp.kadane

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KadaneUnitTest {
    private val solution = Kadane()

    @Test
    fun `Test Kadane with mixed numbers`() {
        val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
        val expected = 6 // subarray: [4, -1, 2, 1]
        assertEquals(expected, solution.maxSubArray(nums))
    }

    @Test
    fun `Test Kadane with all negative`() {
        val nums = intArrayOf(-3, -1, -2)
        val expected = -1
        assertEquals(expected, solution.maxSubArray(nums))
    }

    @Test
    fun `Test Kadane with all positive`() {
        val nums = intArrayOf(1, 2, 3, 4)
        val expected = 10
        assertEquals(expected, solution.maxSubArray(nums))
    }

    @Test
    fun `Test Kadane with single element`() {
        val nums = intArrayOf(7)
        val expected = 7
        assertEquals(expected, solution.maxSubArray(nums))
    }

    @Test
    fun `Test Kadane with empty array`() {
        val nums = intArrayOf()
        val expected = Int.MIN_VALUE // consistent with the function behavior
        assertEquals(expected, solution.maxSubArray(nums))
    }

}