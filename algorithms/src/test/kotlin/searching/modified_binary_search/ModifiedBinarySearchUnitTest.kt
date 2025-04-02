package searching.modified_binary_search

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ModifiedBinarySearchUnitTest {
    private val searcher = ModifiedBinarySearch()

    @Test
    fun `Test Search Target Found`() {
        val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        val target = 0
        val expectedIndex = 4
        assertEquals(expectedIndex, searcher.search(nums, target))
    }

    @Test
    fun `Test Search Target Not Found`() {
        val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
        val target = 3
        val expectedIndex = -1
        assertEquals(expectedIndex, searcher.search(nums, target))
    }

    @Test
    fun `Test Search Single Element Found`() {
        val nums = intArrayOf(1)
        val target = 1
        val expectedIndex = 0
        assertEquals(expectedIndex, searcher.search(nums, target))
    }

    @Test
    fun `Test Search Single Element Not Found`() {
        val nums = intArrayOf(1)
        val target = 0
        val expectedIndex = -1
        assertEquals(expectedIndex, searcher.search(nums, target))
    }

    @Test
    fun `Test Search Empty Array`() {
        val nums = intArrayOf()
        val target = 1
        val expectedIndex = -1
        assertEquals(expectedIndex, searcher.search(nums, target))
    }

    @Test
    fun `Test Search No Rotation`() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val target = 5
        val expectedIndex = 4
        assertEquals(expectedIndex, searcher.search(nums, target))
    }
}