package matrix.matrix_traversal

/**
 * Implements matrix traversal using DFS and BFS.
 *
 * This is useful for problems like flood fill, connected components, and pathfinding.
 *
 * See: [Matrix Traversal](https://en.wikipedia.org/wiki/Flood_fill)
 */
class MatrixTraversal {
    /**
     * Performs flood fill using Depth First Search (DFS).
     *
     * @param image The 2D matrix representing the grid.
     * @param sr The starting row.
     * @param sc The starting column.
     * @param newColor The new color to fill.
     */
    fun floodFillDFS(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int) {
        val originalColor = image[sr][sc]
        if (originalColor == newColor) return

        fun dfs(r: Int, c: Int) {
            if (r !in image.indices || c !in image[0].indices || image[r][c] != originalColor) return
            image[r][c] = newColor
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)
        }

        dfs(sr, sc)
    }

    /**
     * Performs flood fill using Breadth First Search (BFS).
     *
     * @param image The 2D matrix representing the grid.
     * @param sr The starting row.
     * @param sc The starting column.
     * @param newColor The new color to fill.
     */
    fun floodFillBFS(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int) {
        val originalColor = image[sr][sc]
        if (originalColor == newColor) return

        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(sr to sc)

        while (queue.isNotEmpty()) {
            val (r, c) = queue.removeFirst()
            if (r !in image.indices || c !in image[0].indices || image[r][c] != originalColor) continue

            image[r][c] = newColor
            queue.add(r + 1 to c)
            queue.add(r - 1 to c)
            queue.add(r to c + 1)
            queue.add(r to c - 1)
        }
    }
}
