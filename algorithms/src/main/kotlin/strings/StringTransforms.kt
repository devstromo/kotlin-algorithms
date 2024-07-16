package strings

fun reverseUsingStringConcat(string: String): String {
    var output = ""
    for (i in string.length - 1 downTo 0) {
        output += string[i]
    }
    return output
}