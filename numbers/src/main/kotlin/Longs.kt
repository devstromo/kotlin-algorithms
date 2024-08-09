import java.math.BigDecimal

fun toBinaryUsingDivideAndModulusLong(numberToConvert: Long): String {
    require(numberToConvert >= 0) { "Method argument cannot be negative. number=$numberToConvert" }

    val builder = StringBuilder()
    var longNumber = numberToConvert
    var temp: Long

    while (longNumber > 0) {
        temp = longNumber
        longNumber = temp / 2
        builder.append(temp % 2)
    }

    return builder.reverse().toString().ifEmpty { "0" }
}

fun toBinaryUsingShiftsAndModulusLong(numberToConvert: Long): String {
    require(numberToConvert >= 0) { "Method argument cannot be negative. number=$numberToConvert" }

    val builder = StringBuilder()
    var longNumber = numberToConvert
    var temp: Long

    while (longNumber > 0) {
        temp = longNumber
        longNumber = temp shr 1
        builder.append(temp % 2)
    }

    return builder.reverse().toString().ifEmpty { "0" }
}

fun toBinaryUsingBigDecimalLong(numberToConvert: Long): String {
    require(numberToConvert >= 0) { "Method argument cannot be negative. number=$numberToConvert" }

    val builder = StringBuilder()
    val zero = BigDecimal.ZERO
    val two = BigDecimal(2)
    var number = BigDecimal(numberToConvert)
    var decimals: Array<BigDecimal>

    while (number > zero) {
        decimals = number.divideAndRemainder(two)
        number = decimals[0]
        builder.append(decimals[1].toInt())
    }

    return builder.reverse().toString().ifEmpty { "0" }
}