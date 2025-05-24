package graph

/**
 * Represents a directed graph using an adjacency list.
 *
 * Nodes are generic and stored along with their outbound edges.
 */
class DirectedGraph<T> {

    private val adjacencyMap = mutableMapOf<T, MutableList<T>>()

    /**
     * Adds a node to the graph.
     */
    fun addNode(node: T) {
        adjacencyMap.putIfAbsent(node, mutableListOf())
    }

    /**
     * Adds a directed edge from 'from' to 'to'.
     */
    fun addEdge(from: T, to: T) {
        addNode(from)
        addNode(to)
        adjacencyMap[from]?.add(to)
    }

    /**
     * Returns a list of all neighbors that the given node points to.
     */
    fun getNeighbors(node: T): List<T> {
        return adjacencyMap[node] ?: emptyList()
    }

    /**
     * Checks if the graph contains a node.
     */
    fun contains(node: T): Boolean {
        return adjacencyMap.containsKey(node)
    }

    /**
     * Returns all nodes in the graph.
     */
    fun getAllNodes(): Set<T> {
        return adjacencyMap.keys
    }

    /**
     * Prints the directed graph.
     */
    fun printGraph() {
        for ((node, neighbors) in adjacencyMap) {
            println("$node -> ${neighbors.joinToString(", ")}")
        }
    }
}
