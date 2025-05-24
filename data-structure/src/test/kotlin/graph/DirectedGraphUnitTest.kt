package graph

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.collections.listOf

class DirectedGraphUnitTest {
    private val graph = DirectedGraph<Int>()

    @Test
    fun `Test add edge creates correct neighbors`() {
        graph.addEdge(1, 2)
        graph.addEdge(1, 3)
        graph.addEdge(2, 4)

        assertEquals(listOf(2, 3), graph.getNeighbors(1))
        assertEquals(listOf(4), graph.getNeighbors(2))
        assertEquals(emptyList<Int>(), graph.getNeighbors(3))
    }

    @Test
    fun `Test contains returns true for existing nodes`() {
        graph.addNode(5)
        assertTrue(graph.contains(5))
    }

    @Test
    fun `Test contains returns false for missing nodes`() {
        assertFalse(graph.contains(999))
    }

    @Test
    fun `Test get all nodes returns complete set`() {
        graph.addEdge(10, 20)
        graph.addEdge(20, 30)
        val nodes = graph.getAllNodes()
        assertEquals(setOf(10, 20, 30), nodes)
    }

    @Test
    fun `Test get neighbors on node with no edges returns empty list`() {
        graph.addNode(100)
        assertEquals(emptyList<Int>(), graph.getNeighbors(100))
    }
}