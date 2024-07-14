package permutations

fun permutations(stringToGeneratePermutationsFrom: String): Array<String> {
    val size = numberOfPermutations(stringToGeneratePermutationsFrom.length)
    val list = Array(size) { "" }
    if(size == 0)
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
