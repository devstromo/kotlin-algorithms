package searching

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import searching.binary.BinarySearch
import searching.exponential.ExponentialSearch
import searching.interpolation.InterpolationSearch
import searching.linear.LinearSearch

class SearchUnitTest {
    private val linearSearch = LinearSearch()
    private val binarySearch = BinarySearch()
    private val interpolationSearch = InterpolationSearch()
    private val exponentialSearch = ExponentialSearch()

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

    @Test
    fun `Test Interpolation Search Algorithm`() {
        val data = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val target = 7
        val expectedIndex = 6
        assertEquals(expectedIndex, interpolationSearch.search(data, target))
    }

    @Test
    fun `Test Interpolation Search Algorithm Element Not Found`() {
        val data = intArrayOf(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)
        val target = 75
        val expectedIndex = -1
        assertEquals(expectedIndex, interpolationSearch.search(data, target))
    }

    @Test
    fun `Test Exponential Search Algorithm`() {
        val data = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val expectedIndex = 6
        assertEquals(expectedIndex, exponentialSearch.search(data, 7))
    }

    @Test
    fun `Test Exponential Search Algorithm Element Not Found`() {
        val data = intArrayOf(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)
        val expectedIndex = -1
        assertEquals(expectedIndex, exponentialSearch.search(data, 75))
    }

}