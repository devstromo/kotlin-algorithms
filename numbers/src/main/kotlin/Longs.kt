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