package sorting.americanFlag

import kotlin.math.pow


/**
 * Sorts an array of integers in ascending order using the American Flag Sort algorithm.
 * American Flag Sort is an efficient, in-place variant of radix sort that distributes items into multiple buckets.
 * This algorithm is particularly useful for sorting large objects like strings, where comparison operations are
 * not constant-time.
 *
 * The algorithm operates by identifying the maximum number of digits in the input array and then sorting the array
 * by distributing elements into buckets based on their digit values. This process is repeated for each digit,
 * starting from the most significant digit.
 *
 * @param unsorted The array of integers to be sorted.
 * @return The same array, sorted in ascending order.
 *
 * Time Complexity:
 * - Average-case: O(n * k / d), where n is the number of elements, k is the average bucket size, and d is the number of digits.
 * - Worst-case: O(n * k / d), as all elements need to be processed for each digit.
 * - Best-case: O(n * k / d), given the deterministic nature of the sorting process.
 *
 * Space Complexity: O(1), as the sorting is done in-place, requiring no additional storage proportional to the array's size.
 *
 * Stability: Not stable, meaning the relative order of equal elements may not be preserved.
 *
 * @sample
 * val array = arrayOf(329, 457, 657, 839, 436, 720, 355)
 * println(AmericanFlagSort.sort(array).joinToString(", ")) // Output: 329, 355, 436, 457, 657, 720, 839
 *
 * @see <a href="https://en.wikipedia.org/wiki/American_flag_sort">American Flag Sort (Wikipedia)</a>
 */
class AmericanFlagSort {

    private val NUMBER_OF_BUCKETS = 10

    fun sort(unsorted: Array<Int>): Array<Int> {
        val numberOfDigits = getMaxNumberOfDigits(unsorted) // Max number of digits
        var max = 1
        for (i in 0 until numberOfDigits - 1) {
            max *= 10
        }
        sort(unsorted, 0, unsorted.size, max)
        return unsorted
    }

    fun americanFlagSort(array: IntArray, radix: Int) {
        if (array.isEmpty()) return

        val nonNegativeNumbers = array.filter { it >= 0 }.toIntArray()
        val negativeNumbers = array.filter { it < 0 }.map { -it }.toIntArray()

        if (nonNegativeNumbers.isNotEmpty()) {
            val maxDigits = getMaxDigits(nonNegativeNumbers, radix)
            americanFlagSortIterative(nonNegativeNumbers, radix, maxDigits)
        }

        if (negativeNumbers.isNotEmpty()) {
            val maxDigits = getMaxDigits(negativeNumbers, radix)
            americanFlagSortIterative(negativeNumbers, radix, maxDigits)
        }


        var index = 0
        for (num in negativeNumbers.reversed()) {
            array[index++] = -num
        }
        for (num in nonNegativeNumbers) {
            array[index++] = num
        }
    }

    private fun americanFlagSortIterative(array: IntArray, radix: Int, maxDigits: Int) {
        val counts = IntArray(radix)
        val offsets = IntArray(radix)

        for (digit in 0 until maxDigits) {
            counts.fill(0)

            for (num in array) {
                val digitValue = getDigit(num, radix, digit)
                counts[digitValue]++
            }

            offsets[0] = 0
            for (i in 1 until radix) {
                offsets[i] = offsets[i - 1] + counts[i - 1]
            }

            val tempArray = array.copyOf()
            for (num in array) {
                val digitValue = getDigit(num, radix, digit)
                tempArray[offsets[digitValue]++] = num
            }

            System.arraycopy(tempArray, 0, array, 0, array.size)
        }
    }

    private fun getMaxDigits(array: IntArray, radix: Int): Int {
        var maxNumber = array.maxOrNull() ?: 0
        var digits = 0
        while (maxNumber > 0) {
            maxNumber /= radix
            digits++
        }
        return digits
    }

    private fun getDigit(number: Int, radix: Int, position: Int): Int {
        return (number / radix.toDouble().pow(position.toDouble()).toInt()) % radix
    }

    private fun sort(unsorted: Array<Int>, start: Int, length: Int, divisor: Int) {
        val count = IntArray(NUMBER_OF_BUCKETS)
        val offset = IntArray(NUMBER_OF_BUCKETS)
        var digit: Int
        for (i in start until length) {
            val d = unsorted[i]
            digit = getDigit(d, divisor)
            count[digit]++
        }
        offset[0] = start
        for (i in 1 until NUMBER_OF_BUCKETS) {
            offset[i] = count[i - 1] + offset[i - 1]
        }
        // Second pass - move into position
        for (b in 0 until NUMBER_OF_BUCKETS) {
            while (count[b] > 0) {
                val origin = offset[b]
                var from = origin
                var num = unsorted[from]
                unsorted[from] = -1
                do {
                    digit = getDigit(num, divisor)
                    val to = offset[digit]++
                    count[digit]--
                    val temp = unsorted[to]
                    unsorted[to] = num
                    num = temp
                    from = to
                } while (from != origin)
            }
        }
        if (divisor > 1) {
            // Sort the buckets
            for (i in 0 until NUMBER_OF_BUCKETS) {
                val begin = if (i > 0) offset[i - 1] else start
                val end = offset[i]
                if (end - begin > 1) {
                    sort(unsorted, begin, end, divisor / 10)
                }
            }
        }
    }

    private fun getMaxNumberOfDigits(unsorted: Array<Int>): Int {
        var max = Int.MIN_VALUE
        for (i in unsorted) {
            val temp = (Math.log10(i.toDouble()) + 1).toInt()
            if (temp > max) {
                max = temp
            }
        }
        return max
    }

    private fun getDigit(integer: Int, divisor: Int): Int {
        return (integer / divisor) % 10
    }
}