package matrix.matrix_multiplication

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class MatrixMultiplicationKtUnitTest {
    @Test
    fun `Test Valid Matrix Multiplication`() {
        val matrixA = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        )

        val matrixB = arrayOf(
            intArrayOf(7, 8),
            intArrayOf(9, 10),
            intArrayOf(11, 12)
        )

        val expected = arrayOf(
            intArrayOf(58, 64),
            intArrayOf(139, 154)
        )

        val result = multiplyMatrices(matrixA, matrixB)
        assertTrue { expected.contentDeepEquals(result) }
    }

    @Test
    fun `Test Incompatible Matrices`() {
        val matrixA = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )

        val matrixB = arrayOf(
            intArrayOf(5, 6, 7),
            intArrayOf(8, 9, 10),
            intArrayOf(11, 12, 13)
        )

        assertFailsWith<IllegalArgumentException> {
            multiplyMatrices(matrixA, matrixB)
        }
    }

    @Test
    fun `Test IdentityMatrix`() {
        val matrixA = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )

        val identityMatrix = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1)
        )

        val result = multiplyMatrices(matrixA, identityMatrix)
        assertTrue { matrixA.contentDeepEquals(result) }
    }

    @Test
    fun `Test Zero Matrix`() {
        val matrixA = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        )

        val zeroMatrix = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )

        val expected = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )

        val result = multiplyMatrices(matrixA, zeroMatrix)
        assertTrue { expected.contentDeepEquals(result) }
    }
}