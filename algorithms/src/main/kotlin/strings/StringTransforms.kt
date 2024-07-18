package strings

fun reverseUsingStringConcat(string: String): String {
    var output = ""
    for (i in string.length - 1 downTo 0) {
        output += string[i]
    }
    return output
}

fun reverseUsingStringBuilder(string: String): String {
    val builder = StringBuilder()
    for (i in string.length - 1 downTo 0) {
        builder.append(string[i])
    }
    return builder.toString()
}

fun reverseUsingStringBuilderReverse(string: String): String {
    val stringBuilder = StringBuilder(string)
    return stringBuilder.reverse().toString()
}

fun reverseUsingSwaps(string: String): String {
    val array = string.toCharArray()
    val length = array.size - 1
    val half = array.size / 2

    for (i in 0 until half) {
        val c = array[length - i]
        array[length - i] = array[i]
        array[i] = c
    }
    return String(array)
}

fun reverseUsingXOR(string: String): String {
    val array = string.toCharArray()
    val length = array.size
    val half = length / 2

    for (i in 0 until half) {
        array[i] = (array[i].code xor array[length - i - 1].code).toChar()
        array[length - i - 1] = (array[length - i - 1].code xor array[i].code).toChar()
        array[i] = (array[i].code xor array[length - i - 1].code).toChar()
    }
    return String(array)
}

fun reverseWordsByCharUsingAdditionalStorage(string: String): String {
    val builder = StringBuilder()
    val length = string.length - 1
    val temp = StringBuilder()

    var index: Int
    var last = string.length

    for (i in length downTo 0) {
        val c = string[i]
        if (c == ' ' || i == 0) {
            index = if (i == 0) 0 else i + 1
            temp.append(string.substring(index, last))
            if (index != 0) temp.append(c)
            builder.append(temp)
            temp.delete(0, temp.length)
            last = i
        }
    }

    return builder.toString()
}

fun reverseWordsUsingStringTokenizerWithAdditionalStorage(string: String): String {
    val tokens = string.split("\\s+".toRegex())
    var output = ""
    for (token in tokens) {
        output = "$token $output"
    }
    return output.trim()
}

fun reverseWordsUsingSplitWithAdditionalStorage(string: String): String {
    val builder = StringBuilder()
    val temp = string.trim().split("\\s+".toRegex())

    for (i in temp.size - 1 downTo 0) {
        builder.append(temp[i]).append(' ')
    }
    return builder.toString().trim()
}

fun reverseWordsInPlace(string: String): String {
    val chars = string.toCharArray()

    var lengthI: Int
    var lastI = 0
    var lengthJ = 0
    var lastJ = chars.size - 1

    var i = 0
    while (i < chars.size && i <= lastJ) {
        val iChar = chars[i]
        if (iChar == ' ') {
            lengthI = i - lastI
            for (j in lastJ downTo i) {
                val jChar = chars[j]
                if (jChar == ' ') {
                    lengthJ = lastJ - j
                    swapWords(lastI, i - 1, j + 1, lastJ, chars)
                    lastJ -= lengthI + 1
                    break
                }
            }
            lastI += lengthJ + 1
            i = lastI
        } else {
            i++
        }
    }

    return String(chars)
}

private fun swapWords(start1: Int, end1: Int, start2: Int, end2: Int, chars: CharArray) {
    val length = end1 - start1 + 1
    for (k in 0 until length) {
        val temp = chars[start1 + k]
        chars[start1 + k] = chars[start2 + k]
        chars[start2 + k] = temp
    }
}