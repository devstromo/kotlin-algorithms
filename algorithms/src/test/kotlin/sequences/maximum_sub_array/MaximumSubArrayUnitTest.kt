package sequences.maximum_sub_array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubArrayUnitTest {

    private val maximumSubArray = MaximumSubArray()

    @Test
    fun `Test maximum sub array`() {
        assertEquals(6, maximumSubArray.maximumSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }

    @Test
    fun `Test maximum sub array using Kadane Algorithm`() {
        assertEquals(6, maximumSubArray.maximumSubArrayKadane(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }
}