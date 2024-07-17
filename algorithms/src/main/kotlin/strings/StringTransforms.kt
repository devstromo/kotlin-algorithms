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