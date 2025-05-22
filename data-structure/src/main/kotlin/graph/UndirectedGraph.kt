package graph

class UndirectedGraph<T> {

    private val adjacencyMap = mutableMapOf<T, ArrayList<T>>()

    /**
     * Adds a node to the graph.
     */
    fun addNode(node: T) {
        adjacencyMap.putIfAbsent(node, ArrayList())
    }

    /**
     * Adds an undirected edge between two nodes.
     */
    fun addEdge(node1: T, node2: T) {
        addNode(node1)
        addNode(node2)
        adjacencyMap[node1]?.add(node2)
        adjacencyMap[node2]?.add(node1)
    }

    /**
     * Returns the neighbors of a given node.
     */
    fun getNeighbors(node: T): List<T> {
        return (adjacencyMap[node] ?: ArrayList()).let { list ->
            List(list.size) { list.get(it)!! }
        }
    }

    /**
     * Checks if a node exists in the graph.
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
     * Prints the graph.
     */
    fun printGraph() {
        for ((node, neighbors) in adjacencyMap) {
            val connections = (0 until neighbors.size)
                .joinToString(", ") { neighbors.get(it).toString() }
            println("$node -> [$connections]")
        }
    }
}
