package matrix.matrix_traversal

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MatrixTraversalUnitTest {
    private val traversal = MatrixTraversal()

    @Test
    fun `Test Flood Fill DFS`() {
        val image = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
        )
        val expected = arrayOf(
            intArrayOf(2, 2, 2),
            intArrayOf(2, 2, 0),
            intArrayOf(2, 0, 1)
        )
        traversal.floodFillDFS(image, 1, 1, 2)
        assertTrue { expected.contentDeepEquals(image) }
    }

    @Test
    fun `Test Flood Fill BFS`() {
        val image = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
        )
        val expected = arrayOf(
            intArrayOf(2, 2, 2),
            intArrayOf(2, 2, 0),
            intArrayOf(2, 0, 1)
        )
        traversal.floodFillBFS(image, 1, 1, 2)
        assertTrue { expected.contentDeepEquals(image) }

    }
}