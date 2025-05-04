package dp.edit_distance

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EditDistanceUnitTest {
    private val solver = EditDistance()

    @Test
    fun `Test same words`() {
        val result = solver.minDistance("kitten", "kitten")
        assertEquals(0, result)
    }

    @Test
    fun `Test insertions only`() {
        val result = solver.minDistance("", "abc")
        assertEquals(3, result)
    }

    @Test
    fun `Test deletions only`() {
        val result = solver.minDistance("abc", "")
        assertEquals(3, result)
    }

    @Test
    fun `Test mixed operations`() {
        val result = solver.minDistance("horse", "ros")
        assertEquals(3, result) // remove 'h', replace 'r'->'o', remove 'e'
    }

    @Test
    fun `Test another mixed case`() {
        val result = solver.minDistance("intention", "execution")
        assertEquals(5, result)
    }
}