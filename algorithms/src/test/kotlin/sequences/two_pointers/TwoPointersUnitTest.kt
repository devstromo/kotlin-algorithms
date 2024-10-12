package sequences.two_pointers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TwoPointersUnitTest {
    private val solution = TwoPointers()

    @Test
    fun `Test two pointers`() {
        assertArrayEquals(intArrayOf(1, 3), solution.twoPointers(intArrayOf(1, 2, 3, 4, 6), 6))
        assertArrayEquals(intArrayOf(0, 4), solution.twoPointers(intArrayOf(1, 2, 3, 4, 5), 6))
        assertArrayEquals(intArrayOf(0, 1), solution.twoPointers(intArrayOf(2, 7, 11, 15), 9))
        assertArrayEquals(intArrayOf(0, 2), solution.twoPointers(intArrayOf(2, 3, 4), 6))
        assertArrayEquals(intArrayOf(0, 1), solution.twoPointers(intArrayOf(3, 3), 6))
        assertArrayEquals(intArrayOf(-1, -1), solution.twoPointers(intArrayOf(3, 4), 6))
    }
}