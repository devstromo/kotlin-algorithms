package sequences.sliding_window

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SlidingWindowUnitTest {
    private val solution = SlidingWindow()

    @Test
    fun `Test sliding-window `() {
        assertEquals(9, solution.slidingWindow(intArrayOf(2, 1, 5, 1, 3, 2), 3))
        assertEquals(700, solution.slidingWindow(intArrayOf(100, 200, 300, 400), 2))
        assertEquals(39, solution.slidingWindow(intArrayOf(1, 4, 2, 10, 23, 3, 1, 0, 20), 4))
        assertEquals(-1, solution.slidingWindow(intArrayOf(2, 3), 3))
    }

    @Test
    fun `Test sliding-window Brute Force `() {
        assertEquals(9, solution.slidingWindowBruteForce(intArrayOf(2, 1, 5, 1, 3, 2), 3))
        assertEquals(700, solution.slidingWindowBruteForce(intArrayOf(100, 200, 300, 400), 2))
        assertEquals(39, solution.slidingWindowBruteForce(intArrayOf(1, 4, 2, 10, 23, 3, 1, 0, 20), 4))
        assertEquals(-1, solution.slidingWindowBruteForce(intArrayOf(2, 3), 3))
    }
}