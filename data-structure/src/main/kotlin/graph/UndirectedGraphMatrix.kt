package graph

/**
 * Represents an undirected graph using an adjacency matrix.
 *
 * Nodes are identified by integer indices from 0 to capacity - 1.
 */
class UndirectedGraphMatrix(private val capacity: Int) {
    private val adjacencyMatrix: Array<BooleanArray> = Array(capacity) { BooleanArray(capacity) }

    /**
     * Adds an undirected edge between node1 and node2.
     * @throws IllegalArgumentException if node indices are out of bounds.
     */
    fun addEdge(node1: Int, node2: Int) {
        require(node1 in 0 until capacity && node2 in 0 until capacity) {
            "Node indices must be between 0 and ${capacity - 1}"
        }
        adjacencyMatrix[node1][node2] = true
        adjacencyMatrix[node2][node1] = true
    }

    /**
     * Checks whether there is an edge between node1 and node2.
     */
    fun hasEdge(node1: Int, node2: Int): Boolean {
        return adjacencyMatrix[node1][node2]
    }

    /**
     * Returns a list of neighbors for a given node.
     */
    fun getNeighbors(node: Int): List<Int> {
        return adjacencyMatrix[node].withIndex()
            .filter { it.value }
            .map { it.index }
    }

    /**
     * Prints the adjacency matrix.
     */
    fun printMatrix() {
        println("Adjacency Matrix:")
        for (row in adjacencyMatrix) {
            println(row.joinToString(" ") { if (it) "1" else "0" })
        }
    }
}
