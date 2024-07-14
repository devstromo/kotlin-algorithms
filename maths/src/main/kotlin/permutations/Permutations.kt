package permutations

fun permutations(stringToGeneratePermutationsFrom: String): Array<String> {
    val size = numberOfPermutations(stringToGeneratePermutationsFrom.length)
    val list = Array(size) { "" }
    if (size == 0)
        return list
    val prefix = charArrayOf()
    val chars = stringToGeneratePermutationsFrom.toCharArray()
    permutations(list, 0, prefix, chars, 0, chars.size)
    return list
}

fun <N : Number> getAllPermutations(numbers: Array<N>): List<List<N>> {
    val result = mutableListOf<List<N>>()
    return getAllPermutations(numbers, result)
}

/**
 * Generates all permutations of the given array using Heap's Algorithm.
 *
 * @param array The array to generate permutations from.
 * @return A list of all permutations.
 */
fun <T> heapPermutations(array: Array<T>): List<List<T>> {
    val result = mutableListOf<List<T>>()
    heapPermutations(array, array.size, result)
    return result
}

/**
 * Generates all permutations of the given array using an iterative approach.
 *
 * @param array The array to generate permutations from.
 * @return A list of all permutations.
 */
fun <T> iterativePermutations(array: Array<T>): List<List<T>> {
    val result = mutableListOf<List<T>>()
    val n = array.size
    if (array.isEmpty())
        return result
    val c = IntArray(n) { 0 } // control array initially all zeros
    result.add(array.toList())

    var i = 0
    while (i < n) {
        if (c[i] < i) {
            if (i % 2 == 0) {
                array.swap(0, i)
            } else {
                array.swap(c[i], i)
            }
            result.add(array.toList())
            c[i] += 1
            i = 0
        } else {
            c[i] = 0
            i += 1
        }
    }

    return result
}

private fun <T> heapPermutations(array: Array<T>, size: Int, result: MutableList<List<T>>) {
    if (size == 1) {
        result.add(array.toList())
        return
    }

    for (i in 0 until size) {
        heapPermutations(array, size - 1, result)

        // Swap elements depending on the parity of the size
        if (size % 2 == 1) {
            array.swap(0, size - 1)
        } else {
            array.swap(i, size - 1)
        }
    }
}


private fun numberOfPermutations(N: Int): Int {
    // factorial
    var result = N
    var n = N
    while (n > 1) {
        result *= --n
    }
    return result
}

private fun permutations(
    list: Array<String>,
    index: Int,
    prefix: CharArray,
    remaining: CharArray,
    prefixLength: Int,
    remainingLength: Int
): Int {
    val N = remainingLength - prefixLength
    var currentIndex = index
    if (N == 0) {
        list[currentIndex] = String(prefix)
        currentIndex++
    } else {
        for (i in 0 until N) {
            val prefChars = CharArray(prefixLength + 1)
            System.arraycopy(prefix, 0, prefChars, 0, prefixLength)
            System.arraycopy(remaining, i, prefChars, prefixLength, 1)

            val restChars = CharArray(N - 1)
            System.arraycopy(remaining, 0, restChars, 0, i)
            System.arraycopy(remaining, i + 1, restChars, i, N - (i + 1))

            currentIndex =
                permutations(list, currentIndex, prefChars, restChars, remainingLength - (N - 1), remainingLength)
        }
    }
    return currentIndex
}

private fun <N : Number> getAllPermutations(numbers: Array<N>, result: MutableList<List<N>>): List<List<N>> {
    // numbers given in an array are also a permutation
    val firstPermutation = numbers.toMutableList()
    result.add(firstPermutation)
    // let's permute all elements in array starting from index 0
    return permute(numbers, 0, result)
}

private fun <N : Number> permute(
    numbers: Array<N>,
    currentElementIndex: Int,
    result: MutableList<List<N>>
): List<List<N>> {
    if (currentElementIndex == numbers.size - 1) return result

    for (i in currentElementIndex until numbers.size) {
        // swapping two elements
        numbers.swap(i, currentElementIndex)

        permute(numbers, currentElementIndex + 1, result)

        // all next permutation found
        if (i != currentElementIndex) {
            val nextPermutation = numbers.toMutableList()
            result.add(nextPermutation)
        }

        // swapping back two elements
        numbers.swap(i, currentElementIndex)
    }
    return result
}

private fun <N> Array<N>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}
