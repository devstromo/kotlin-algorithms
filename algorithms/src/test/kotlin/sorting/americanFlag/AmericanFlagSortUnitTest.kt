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
}