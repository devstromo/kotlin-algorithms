package graph

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DirectedGraphMatrixUnitTest {
    @Test
    fun `Test add edge creates correct direction`() {
        val graph = DirectedGraphMatrix(3)
        graph.addEdge(0, 1)
        assertTrue(graph.hasEdge(0, 1))
        assertFalse(graph.hasEdge(1, 0))
    }

    @Test
    fun `Test get neighbors returns correct nodes`() {
        val graph = DirectedGraphMatrix(4)
        graph.addEdge(0, 1)
        graph.addEdge(0, 2)
        graph.addEdge(2, 3)

        assertEquals(listOf(1, 2), graph.getNeighbors(0))
        assertEquals(listOf(3), graph.getNeighbors(2))
        assertEquals(emptyList<Int>(), graph.getNeighbors(1))
        assertEquals(emptyList<Int>(), graph.getNeighbors(3))
    }

    @Test
    fun `Test has edge returns false for disconnected nodes`() {
        val graph = DirectedGraphMatrix(2)
        assertFalse(graph.hasEdge(0, 1))
    }

    @Test
    fun `Test add edge with invalid index throws exception`() {
        val graph = DirectedGraphMatrix(2)
        try {
            graph.addEdge(1, 2)
            assert(false) { "Expected IllegalArgumentException" }
        } catch (e: IllegalArgumentException) {
            assertTrue(e.message!!.contains("Node indices must be in range"))
        }
    }

}