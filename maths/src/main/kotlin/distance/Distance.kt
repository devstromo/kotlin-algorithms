package distance

import kotlin.math.abs
import kotlin.math.sqrt


/**
 * Calculates the Euclidean distance between two points in a 2D space.
 *
 * The Euclidean distance between two points (x1, y1) and (x2, y2) is defined as
 * the square root of the sum of the squares of the differences in their respective
 * x and y coordinates. Mathematically, it's described by the formula:
 *
 * d = sqrt((x2 - x1)^2 + (y2 - y1)^2)
 *
 * @param x1 The x-coordinate of the first point.
 * @param y1 The y-coordinate of the first point.
 * @param x2 The x-coordinate of the second point.
 * @param y2 The y-coordinate of the second point.
 * @return The Euclidean distance between the two points as a Double.
 */
fun euclidean(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    val deltaX = x2 - x1
    val deltaY = y2 - y1
    return sqrt(deltaX * deltaX + deltaY * deltaY)
}

/**
 * Calculates the Manhattan distance between two points in a 2D space.
 *
 * The Manhattan distance, also known as Taxicab distance or city block distance,
 * between two points (x1, y1) and (x2, y2) is defined as the sum of the absolute
 * differences of their respective coordinates. Mathematically, it's described by
 * the formula:
 *
 * d = |x2 - x1| + |y2 - y1|
 *
 * @param x1 The x-coordinate of the first point.
 * @param y1 The y-coordinate of the first point.
 * @param x2 The x-coordinate of the second point.
 * @param y2 The y-coordinate of the second point.
 * @return The Manhattan distance between the two points as a Double.
 */
fun manhattan(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    return abs(x2 - x1) + abs(y2 - y1)
}

/**
 * Calculates the Hamming distance between two strings.
 * The Hamming distance is the number of positions at which the corresponding characters of the two strings are different.
 *
 * @param str1 The first string to compare.
 * @param str2 The second string to compare.
 * @return The Hamming distance as an integer.
 * @throws IllegalArgumentException If the strings are not of the same length.
 *
 */
fun hammingDistance(str1: String, str2: String): Int {
    if (str1.length != str2.length) {
        throw IllegalArgumentException("Strings must be of the same length")
    }

    var distance = 0
    for (i in str1.indices) {
        if (str1[i] != str2[i]) {
            distance++
        }
    }
    return distance
}

/**
 * Calculates the average Hamming distance between two lists of integers representing bit strings.
 * The average Hamming distance is defined as the sum of the absolute differences between corresponding
 * bits in the two lists, divided by the number of bits (list size). This function requires that both
 * bit lists be of the same length.
 * ```
 * Hamming Distance = (sum for i to N abs(v1[i] — v2[i]))/N
 * ```
 * @param bits1 The first list of bits.
 * @param bits2 The second list of bits.
 * @return The average Hamming distance as a Double.
 * @throws IllegalArgumentException If the two bit lists are not of the same length.
 */
fun hammingAvgDistance(bits1: List<Int>, bits2: List<Int>): Double {
    if (bits1.size != bits2.size) {
        throw IllegalArgumentException("Both bit lists must be of the same length")
    }

    val distance = bits1.zip(bits2).sumOf { (bit1, bit2) ->
        abs(bit1 - bit2)
    }
    return distance.toDouble() / bits1.size
}

fun levenshteinDistance(s1: String, s2: String): Int {
    val n = s1.length
    val m = s2.length

    // Create the matrix
    val dp = Array(n + 1) { IntArray(m + 1) }

    for (i in 0..n) {
        dp[i][0] = i
    }
    for (j in 0..m) {
        dp[0][j] = j
    }

    for (i in 1..n) {
        for (j in 1..m) {
            val cost = if (s1[i - 1] == s2[j - 1]) 0 else 1

            dp[i][j] = minOf(
                dp[i - 1][j] + 1,    // Deletion
                dp[i][j - 1] + 1,    // Insertion
                dp[i - 1][j - 1] + cost // Substitution
            )
        }
    }

    return dp[n][m]
}