package searching

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import searching.binary.BinarySearch
import searching.linear.LinearSearch

class SearchUnitTest {
    private val linearSearch = LinearSearch()
    private val binarySearch = BinarySearch()

    @Test
    fun `Test Linear Search Algorithm`() {
        assertEquals(5, linearSearch.search(intArrayOf(4, 5, 8, 99, 77, 45), 45))
    }

    @Test
    fun `Test Linear Search Algorithm Element Not Found`() {
        assertEquals(-1, linearSearch.search(intArrayOf(4, 5, 8, 99, 77, 45), 147))
    }

    @Test
    fun `Test Binary Search Algorithm`() {
        assertEquals(3, binarySearch.search(intArrayOf(4, 5, 8, 45, 77, 99), 45))
    }

    @Test
    fun `Test Binary Search Algorithm Element Not Found`() {
        assertEquals(-1, binarySearch.search(intArrayOf(4, 5, 8, 45, 77, 99), 147))
    }

    @Test
    fun `Test Binary Recursive Search Algorithm`() {
        assertEquals(3, binarySearch.searchRecursive(intArrayOf(4, 5, 8, 45, 77, 99), 45))
    }

    @Test
    fun `Test Binary Recursive Search Algorithm Element Not Found`() {
        assertEquals(-1, binarySearch.searchRecursive(intArrayOf(4, 5, 8, 45, 77, 99), 147))
    }
}