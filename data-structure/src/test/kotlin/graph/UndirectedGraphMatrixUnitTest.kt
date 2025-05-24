package graph

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UndirectedGraphMatrixUnitTest {
    @Test
    fun `Test add edge updates matrix correctly`() {
        val graph = UndirectedGraphMatrix(3)
        graph.addEdge(0, 1)
        assertTrue(graph.hasEdge(0, 1))
        assertTrue(graph.hasEdge(1, 0))
        assertFalse(graph.hasEdge(0, 2))
    }

    @Test
    fun `Test get neighbors returns correct list`() {
        val graph = UndirectedGraphMatrix(4)
        graph.addEdge(0, 1)
        graph.addEdge(0, 2)
        graph.addEdge(1, 3)

        assertEquals(listOf(1, 2), graph.getNeighbors(0).sorted())
        assertEquals(listOf(0, 3), graph.getNeighbors(1).sorted())
        assertEquals(listOf(0), graph.getNeighbors(2))
        assertEquals(listOf(1), graph.getNeighbors(3))
    }

    @Test
    fun `Test has edge returns false for disconnected nodes`() {
        val graph = UndirectedGraphMatrix(2)
        assertFalse(graph.hasEdge(0, 1))
    }

    @Test
    fun `Test add edge with invalid node throws exception`() {
        val graph = UndirectedGraphMatrix(2)
        try {
            graph.addEdge(0, 2)
            assert(false) { "Expected IllegalArgumentException" }
        } catch (e: IllegalArgumentException) {
            assertTrue(e.message!!.contains("Node indices must be between"))
        }
    }
}