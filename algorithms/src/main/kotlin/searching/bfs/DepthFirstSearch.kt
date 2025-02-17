package searching.bfs

/**
 * A generic implementation of Depth First Search (DFS) in Kotlin.
 *
 * This class provides methods to traverse a graph using DFS.
 * It supports both recursive and iterative approaches.
 *
 * @param T The type of elements in the graph.
 */
class DepthFirstSearch<T> {

    /**
     * Performs Depth First Search using recursion.
     *
     * @param graph The adjacency list representation of the graph.
     * @param start The starting node for the search.
     * @param visited A mutable set to keep track of visited nodes.
     */
    fun recursiveDFS(
        graph: Map<T, List<T>>,
        start: T,
        visited: MutableSet<T> = mutableSetOf()
    ) {
        if (start in visited) return

        visited.add(start)
        println("Visited: $start")

        graph[start]?.forEach { neighbor ->
            recursiveDFS(graph, neighbor, visited)
        }
    }

    /**
     * Performs Depth First Search using an iterative approach with a stack.
     *
     * @param graph The adjacency list representation of the graph.
     * @param start The starting node for the search.
     */
    fun iterativeDFS(graph: Map<T, List<T>>, start: T) {
        val stack = ArrayDeque<T>()
        val visited = mutableSetOf<T>()

        stack.add(start)

        while (stack.isNotEmpty()) {
            val node = stack.removeLast()
            if (node in visited) continue

            visited.add(node)
            println("Visited: $node")

            graph[node]?.forEach { neighbor ->
                stack.add(neighbor)
            }
        }
    }
}
