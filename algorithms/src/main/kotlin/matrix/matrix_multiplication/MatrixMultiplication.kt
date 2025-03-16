package matrix.matrix_multiplication

/**
 * Multiplies two matrices and returns the resulting matrix.
 *
 * See: [Matrix Multiplication](https://en.wikipedia.org/wiki/Matrix_multiplication)
 *
 * @param matrixA The first matrix.
 * @param matrixB The second matrix.
 * @return The resulting matrix after multiplication.
 * @throws IllegalArgumentException if the number of columns in matrixA
 *         does not match the number of rows in matrixB.
 */
fun multiplyMatrices(matrixA: Array<IntArray>, matrixB: Array<IntArray>): Array<IntArray> {
    val rowsA = matrixA.size
    val colsA = matrixA[0].size
    val rowsB = matrixB.size
    val colsB = matrixB[0].size

    require(colsA == rowsB) { "Number of columns in Matrix A must match number of rows in Matrix B" }

    val result = Array(rowsA) { IntArray(colsB) }

    for (i in 0 until rowsA) {
        for (j in 0 until colsB) {
            for (k in 0 until colsA) {
                result[i][j] += matrixA[i][k] * matrixB[k][j]
            }
        }
    }
    return result
}

/**
 * Prints a matrix in a readable format.
 */
fun printMatrix(matrix: Array<IntArray>) {
    for (row in matrix) {
        println(row.joinToString(" "))
    }
}