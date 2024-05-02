package distance

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DistanceKtUnitTest {
    @Test
    fun `Test Calculate EuclideanDistance`() {
        val delta = 0.01

        assertEquals(5.65, euclidean(1.0, 2.0, 5.0, 6.0), delta,
            "The Euclidean distance between (1,2) and (5,6) should be 5.65")

        assertEquals(13.0, euclidean(0.0, 0.0, -5.0, -12.0), delta,
            "The Euclidean distance between (0,0) and (-5,-12) should be 13.0")

        assertEquals(10.0, euclidean(-7.0, -4.0, -1.0, 4.0), delta,
            "The Euclidean distance between (-7,-4) and (-1,4) should be approximately 10.0")

        assertEquals(0.0, euclidean(3.0, 3.0, 3.0, 3.0), delta,
            "The Euclidean distance between two identical points should be 0.0")
    }


    @Test
    fun `Test Calculate Manhattan Distance`() {
        assertEquals(8.0, manhattan(1.0, 2.0, 5.0, 6.0),
            "The Manhattan distance between (1,2) and (5,6) should be 8.0")

        assertEquals(17.0, manhattan(0.0, 0.0, -5.0, -12.0),
            "The Manhattan distance between (0,0) and (-5,-12) should be 17.0")

        assertEquals(14.0, manhattan(-7.0, -4.0, -1.0, 4.0),
            "The Manhattan distance between (-7,-4) and (-1,4) should be 14.0")

        assertEquals(0.0, manhattan(3.0, 3.0, 3.0, 3.0),
            "The Manhattan distance between two identical points should be 0.0")
    }


    @Test
    fun `Test hamming distance`() {
        assertEquals(0, hammingDistance("karat", "karat"))
        assertEquals(2, hammingDistance("karat", "karma"))
        assertEquals(4, hammingDistance("abcd", "dcba"))
    }

    @Test
    fun `Test hamming distance with strings of different length`() {
        val string1 = "karat"
        val string2 = "karmas"
        assertThrows<IllegalArgumentException> {
            hammingDistance(string1, string2)
        }
    }
}