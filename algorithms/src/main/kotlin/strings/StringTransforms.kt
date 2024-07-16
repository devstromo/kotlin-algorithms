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