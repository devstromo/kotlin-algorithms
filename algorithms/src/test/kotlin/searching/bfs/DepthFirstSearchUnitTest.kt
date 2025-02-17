package searching.bfs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DepthFirstSearchUnitTest {
    private val graph = mapOf(
        'A' to listOf('B', 'C'),
        'B' to listOf('D', 'E'),
        'C' to listOf('F'),
        'D' to emptyList(),
        'E' to emptyList(),
        'F' to emptyList()
    )

    @Test
    fun `Test Recursive DFS`() {
        val dfs = DepthFirstSearch<Char>()
        val visited = mutableSetOf<Char>()
        dfs.recursiveDFS(graph, 'A', visited)
        assertEquals(setOf('A', 'B', 'C', 'D', 'E', 'F'), visited)
    }

    @Test
    fun `Test Iterative DFS`() {
        val dfs = DepthFirstSearch<Char>()
        val visited = mutableSetOf<Char>()

        dfs.iterativeDFS(graph, 'A', visited)

        assertEquals(setOf('A', 'B', 'C', 'D', 'E', 'F'), visited)
    }
}