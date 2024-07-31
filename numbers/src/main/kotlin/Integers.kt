fun toBinaryUsingDivideAndModulus(number: Int): String {
    require(number >= 0) { "Method argument cannot be negative. number=$number" }

    if (number == 0) {
        return "$number"
    }

    val builder = StringBuilder()
    var integer = number
    var temp: Int
    while (integer > 0) {
        temp = integer
        integer = temp / 2
        builder.append(temp % 2)
    }
    return builder.reverse().toString()
}

fun toBinaryUsingShiftsAndModulus(number: Int): String {
    require(number >= 0) { "Method argument cannot be negative. number=$number" }

    if (number == 0) {
        return "$number"
    }

    val builder = StringBuilder()
    var integer = number
    var temp: Int
    while (integer > 0) {
        temp = integer
        integer = temp shr 1
        builder.append(temp % 2)
    }
    return builder.reverse().toString()
}