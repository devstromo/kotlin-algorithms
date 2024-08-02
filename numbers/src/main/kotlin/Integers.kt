import java.math.BigDecimal
import kotlin.math.log10

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

fun intToBinary(n: Int): String {
    require(n >= 0) { "Method argument cannot be negative. number=$n" }

    var number = n
    var binaryString = ""
    while (number > 0) {
        binaryString = if (number % 2 == 0) "0$binaryString" else "1$binaryString"
        number /= 2
    }

    return binaryString.ifEmpty { "0" }
}


fun toBinaryUsingToBinaryString(number: Int): String {
    require(number >= 0) { "Method argument cannot be negative. number=$number" }
    return Integer.toBinaryString(number)
}

fun toBinaryUsingToStringRadix(number: Int): String {
    return number.toString(2)
}

fun isPowerOfTwoWithLoop(number: Int): Boolean {
    require(number >= 0) { "Method argument cannot be negative. number=$number" }
    if (number == 0) return false
    var inputNumber = number
    while (inputNumber % 2 == 0) {
        inputNumber /= 2
    }

    return inputNumber == 1
}

fun isPowerOfTwoRecursive(number: Int): Boolean {
    require(number >= 0) { "Method argument cannot be negative. number=$number" }
    if (number == 1) return true
    if (number == 0 || number % 2 != 0) return false
    return isPowerOfTwoRecursive(number / 2)
}

/**
 * Determines if a given non-negative integer is a power of two using logarithms.
 *
 * This function uses logarithms to check if the number can be expressed as 2^k where k is a non-negative integer.
 * It calculates the base-10 logarithm of the number and divides it by the base-10 logarithm of 2 to get the exponent
 * and then compares if this exponent is an integer.
 *
 * @param number The integer to check. Must be non-negative.
 * @return `true` if the number is a power of two, `false` otherwise.
 * @throws IllegalArgumentException if the input number is negative.
 */
fun isPowerOfTwoUsingLog(number: Int): Boolean {
    require(number >= 0) { "Method argument cannot be negative. number=$number" }
    val doubleLog = log10(number.toDouble()) / log10(2.0)
    val intLog = doubleLog.toInt()
    return doubleLog.compareTo(intLog.toDouble()) == 0
}