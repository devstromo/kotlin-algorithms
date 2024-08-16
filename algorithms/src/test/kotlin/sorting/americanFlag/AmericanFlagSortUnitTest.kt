package sorting.americanFlag

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AmericanFlagSortUnitTest {
    private val sort = AmericanFlagSort()

    @Test
    fun `Test Sort With Positive Numbers`() {
        val array = arrayOf(329, 457, 657, 839, 436, 720, 355)
        val expected = arrayOf(329, 355, 436, 457, 657, 720, 839)
        assertArrayEquals(expected, sort.sort(array))
    }

    @Test
    fun `Test Sort With Duplicates`() {
        val array = arrayOf(329, 329, 329, 329, 329)
        val expected = arrayOf(329, 329, 329, 329, 329)
        assertArrayEquals(expected, sort.sort(array))
    }

    @Test
    fun `Test Sort With Single Element`() {
        val array = arrayOf(329)
        val expected = arrayOf(329)
        assertArrayEquals(expected, sort.sort(array))
    }

    @Test
    fun `Test Sort With Empty Array`() {
        val array = arrayOf<Int>()
        val expected = arrayOf<Int>()
        assertArrayEquals(expected, sort.sort(array))
    }

    @Test
    fun `Test Sort With Already Sorted Array`() {
        val array = arrayOf(1, 2, 3, 4, 5)
        val expected = arrayOf(1, 2, 3, 4, 5)
        assertArrayEquals(expected, sort.sort(array))
    }

    @Test
    fun `Test Sort With Reverse Sorted Array`() {
        val array = arrayOf(5, 4, 3, 2, 1)
        val expected = arrayOf(1, 2, 3, 4, 5)
        assertArrayEquals(expected, sort.sort(array))
    }

    @Test
    fun `Test Sort With Reverse Sorted Array Variant`() {
        val array = intArrayOf(9, 7, 5, 3, 1)
        val expected = intArrayOf(1, 3, 5, 7, 9)
        sort.americanFlagSort(array, 10)
        assertArrayEquals(expected, array, "Array should be sorted in ascending order")
    }

    @Test
    fun `Test Sort With Random Order Array`() {
        val array = intArrayOf(170, 45, 75, 90, 802, 24, 2, 66)
        val expected = intArrayOf(2, 24, 45, 66, 75, 90, 170, 802)
        sort.americanFlagSort(array, 10)
        assertArrayEquals(expected, array, "Array should be sorted in ascending order")
    }

    @Test
    fun `Test Sort With Array Containing Negative Numbers`() {
        val array = intArrayOf(-10, -3, 0, 2, 5, -7, 1)
        val expected = intArrayOf(-10, -7, -3, 0, 1, 2, 5)
        sort.americanFlagSort(array, 10)
        assertArrayEquals(expected, array, "Array with negative numbers should be sorted in ascending order")
    }

    @Test
    fun `Test Sort With Array Containing All Identical Elements`() {
        val array = intArrayOf(1, 1, 1, 1, 1)
        val expected = intArrayOf(1, 1, 1, 1, 1)
        sort.americanFlagSort(array, 10)
        assertArrayEquals(expected, array, "Array with all identical elements should remain unchanged")
    }

    @Test
    fun `Test Sort With Single Element Array`() {
        val array = intArrayOf(42)
        val expected = intArrayOf(42)
        sort.americanFlagSort(array, 10)
        assertArrayEquals(expected, array, "Single element array should remain unchanged")
    }

    @Test
    fun `Test Sort With Empty Array Variant`() {
        val array = intArrayOf()
        val expected = intArrayOf()
        sort.americanFlagSort(array, 10)
        assertArrayEquals(expected, array, "Empty array should remain unchanged")
    }
}