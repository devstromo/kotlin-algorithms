package maths

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

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
}