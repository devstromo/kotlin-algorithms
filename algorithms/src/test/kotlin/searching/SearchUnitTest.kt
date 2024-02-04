package searching

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import searching.linear.LinearSearch

class SearchUnitTest {
    private val linearSearch = LinearSearch()

    @Test
    fun `Test Linear Search Algorithm`() {
        assertEquals(5, linearSearch.search(intArrayOf(4, 5, 8, 99, 77, 45), 45))
    }

    @Test
    fun `Test Linear Search Algorithm Element Not Found`() {
        assertEquals(-1, linearSearch.search(intArrayOf(4, 5, 8, 99, 77, 45), 147))
    }
}