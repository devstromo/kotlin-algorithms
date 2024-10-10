package sequences.prefix_sum

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PrefixSumUnitTest {
    private val solution = PrefixSum()

    @Test
    fun `Test prefix sum`() {
        assertEquals(1, solution.sumRange(intArrayOf(-2, 0, 3, -5, 2, -1), 0, 2))
        assertEquals(-1, solution.sumRange(intArrayOf(-2, 0, 3, -5, 2, -1), 2, 5))
        assertEquals(-3, solution.sumRange(intArrayOf(-2, 0, 3, -5, 2, -1), 0, 5))
    }

    @Test
    fun `Test prefix sum no additional space`() {
        assertEquals(1, solution.sumRangeNoAdditionalSpace(intArrayOf(-2, 0, 3, -5, 2, -1), 0, 2))
        assertEquals(-1, solution.sumRangeNoAdditionalSpace(intArrayOf(-2, 0, 3, -5, 2, -1), 2, 5))
        assertEquals(-3, solution.sumRangeNoAdditionalSpace(intArrayOf(-2, 0, 3, -5, 2, -1), 0, 5))
    }
}