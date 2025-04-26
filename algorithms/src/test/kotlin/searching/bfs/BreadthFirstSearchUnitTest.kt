package searching.bfs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BreadthFirstSearchUnitTest {
    private val graph = mapOf(
        'A' to listOf('B', 'C'),
        'B' to listOf('D', 'E'),
        'C' to listOf('F'),
        'D' to emptyList(),
        'E' to emptyList(),
        'F' to emptyList()
    )

    @Test
    fun `Test BFS`() {
        val bfs = BreadthFirstSearch<Char>()
        val visited = mutableSetOf<Char>()
        bfs.bfs(graph, 'A', visited)
        assertEquals(setOf('A', 'B', 'C', 'D', 'E', 'F'), visited)
    }
}