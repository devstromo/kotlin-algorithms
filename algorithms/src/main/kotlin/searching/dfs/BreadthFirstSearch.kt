package searching.dfs

/**
 * A generic implementation of Breadth First Search (BFS) in Kotlin.
 *
 * This class provides a method to traverse a graph using BFS.
 *
 * @param T The type of elements in the graph.
 */
class BreadthFirstSearch<T> {

    /**
     * Performs Breadth First Search using a queue.
     *
     * @param graph The adjacency list representation of the graph.
     * @param start The starting node for the search.
     * @param visited A mutable set to keep track of visited nodes.
     */
    fun bfs(
        graph: Map<T, List<T>>,
        start: T,
        visited: MutableSet<T> = mutableSetOf()
    ) {
        val queue = ArrayDeque<T>()
        queue.add(start)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (node in visited) continue

            visited.add(node)
            println("Visited: $node")

            graph[node]?.forEach { neighbor ->
                queue.add(neighbor)
            }
        }
    }
}