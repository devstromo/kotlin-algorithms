package graph

/**
 * Represents a directed graph using an adjacency matrix.
 *
 * Nodes are represented by integer indices [0..capacity-1].
 */
class DirectedGraphMatrix(private val capacity: Int) {
    private val adjacencyMatrix: Array<BooleanArray> = Array(capacity) { BooleanArray(capacity) }

    /**
     * Adds a directed edge from node1 to node2.
     * @throws IllegalArgumentException if either node is out of bounds.
     */
    fun addEdge(from: Int, to: Int) {
        require(from in 0 until capacity && to in 0 until capacity) {
            "Node indices must be in range 0..${capacity - 1}"
        }
        adjacencyMatrix[from][to] = true
    }

    /**
     * Checks if there's a directed edge from node1 to node2.
     */
    fun hasEdge(from: Int, to: Int): Boolean {
        return adjacencyMatrix[from][to]
    }

    /**
     * Returns the list of neighbors node points to.
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