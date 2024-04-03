package distance

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