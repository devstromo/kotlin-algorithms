import java.math.BigDecimal

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

fun toBinaryUsingBigDecimal(numberToConvert: Int): String {
    require(numberToConvert >= 0) { "Method argument cannot be negative. number=$numberToConvert" }

    if (numberToConvert == 0) {
        return "$numberToConvert"
    }
    val builder = StringBuilder()
    var number = BigDecimal(numberToConvert)
    val two = BigDecimal(2)
    val zero = BigDecimal.ZERO

    while (number > zero) {
        val (quotient, remainder) = number.divideAndRemainder(two)
        number = quotient
        builder.append(remainder.toInt())
    }

    return builder.reverse().toString()
}

fun toBinaryUsingDivideAndDouble(number: Int): String {
    require(number >= 0) { "Method argument cannot be negative. number=$number" }

    if (number == 0) {
        return "$number"
    }

    val builder = StringBuilder()
    var integer = number
    var temp: Double

    while (integer > 0) {
        temp = integer / 2.0
        integer = temp.toInt()
        builder.append(if (temp > integer) 1 else 0)
    }

    return builder.reverse().toString()
}