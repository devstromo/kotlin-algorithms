import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class IntegersKtUnitTest {
    @Test
    fun `Test to binary using divide and modulus with positive number input`() {
        val result = toBinaryUsingDivideAndModulus(10)
        assertEquals("1010", result)
    }

    @Test
    fun `Test to binary using divide and modulus with zero`() {
        val result = toBinaryUsingDivideAndModulus(0)
        assertEquals("0", result)
    }

    @Test
    fun `Test to binary using divide and modulus with negative number`() {
        val exception = assertThrows<IllegalArgumentException> {
            toBinaryUsingDivideAndModulus(-1)
        }
        assertEquals("Method argument cannot be negative. number=-1", exception.message)
    }

    @Test
    fun `Test to binary using divide and modulus with large number`() {
        val result = toBinaryUsingDivideAndModulus(255)
        assertEquals("11111111", result)
    }

    @Test
    fun `Test to binary using shifts and modulus with positive number input`() {
        // Test positive number
        val result = toBinaryUsingShiftsAndModulus(10)
        assertEquals("1010", result)
    }

    @Test
    fun `Test to binary using shifts and modulus with zero input`() {
        val result = toBinaryUsingShiftsAndModulus(0)
        assertEquals("0", result)
    }

    @Test
    fun `Test to binary using shifts and modulus with negative number input`() {
        // Test negative number
        val exception = assertThrows<IllegalArgumentException> {
            toBinaryUsingShiftsAndModulus(-1)
        }
        assertEquals("Method argument cannot be negative. number=-1", exception.message)
    }

    @Test
    fun `Test to binary using shifts and modulus with large number input`() {
        val result = toBinaryUsingShiftsAndModulus(255)
        assertEquals("11111111", result, "Binary representation of 255 should be '11111111'")
    }

    @Test
    fun `Test to binary using BigDecimal with positive number input`() {
        val result = toBinaryUsingBigDecimal(10)
        assertEquals("1010", result, "Binary representation of 10 should be '1010'")
    }

    @Test
    fun `Test to binary using BigDecimal with zero input`() {
        val result = toBinaryUsingBigDecimal(0)
        assertEquals("0", result, "Binary representation of 0 should be '0'")
    }

    @Test
    fun `Test to binary using BigDecimal with negative number input`() {
        val exception = assertThrows<IllegalArgumentException> {
            toBinaryUsingBigDecimal(-1)
        }
        assertEquals("Method argument cannot be negative. number=-1", exception.message)
    }

    @Test
    fun `Test to binary using BigDecimal with large number input`() {
        val result = toBinaryUsingBigDecimal(255)
        assertEquals("11111111", result, "Binary representation of 255 should be '11111111'")
    }


    @Test
    fun `Test to binary using divide and double with positive number input`() {
        val result = toBinaryUsingDivideAndDouble(10)
        assertEquals("1010", result, "Binary representation of 10 should be '1010'")
    }

    @Test
    fun `Test to binary using divide and double with zero input`() {
        val result = toBinaryUsingDivideAndDouble(0)
        assertEquals("0", result, "Binary representation of 0 should be '0'")
    }

    @Test
    fun `Test to binary using divide and double with negative number input`() {
        val exception = assertThrows<IllegalArgumentException> {
            toBinaryUsingDivideAndDouble(-1)
        }
        assertEquals("Method argument cannot be negative. number=-1", exception.message)
    }

    @Test
    fun `Test to binary using divide and double with large number input`() {
        val result = toBinaryUsingDivideAndDouble(255)
        assertEquals("11111111", result, "Binary representation of 255 should be '11111111'")
    }

    @Test
    fun `Test int to binary with positive number input`() {
        val result = intToBinary(10)
        assertEquals("1010", result, "Binary representation of 10 should be '1010'")
    }

    @Test
    fun `Test int to binary with zero input`() {
        val result = intToBinary(0)
        assertEquals("0", result, "Binary representation of 0 should be '0'")
    }

    @Test
    fun `Test int to binary with negative number input`() {
        val exception = assertThrows<IllegalArgumentException> {
            intToBinary(-1)
        }
        assertEquals("Method argument cannot be negative. number=-1", exception.message)
    }

    @Test
    fun `Test int to binary using toBinaryString function with large number input`() {
        val result = intToBinary(255)
        assertEquals("11111111", result, "Binary representation of 255 should be '11111111'")
    }

    @Test
    fun `Test int to binary using toBinaryString function with positive number input`() {
        val result = toBinaryUsingToBinaryString(10)
        assertEquals("1010", result, "Binary representation of 10 should be '1010'")
    }

    @Test
    fun `Test int to binary using toBinaryString function with zero input`() {
        val result = toBinaryUsingToBinaryString(0)
        assertEquals("0", result, "Binary representation of 0 should be '0'")
    }

    @Test
    fun `Test int to binary using toBinaryString function with negative number input`() {
        val exception = assertThrows<IllegalArgumentException> {
            toBinaryUsingToBinaryString(-1)
        }
        assertEquals("Method argument cannot be negative. number=-1", exception.message)
    }

    @Test
    fun `Test int to binary using toBinaryString function  with large number input`() {
        val result = toBinaryUsingToBinaryString(255)
        assertEquals("11111111", result, "Binary representation of 255 should be '11111111'")
    }

    @Test
    fun `Test int to binary using toString with radix function with positive number input`() {
        val result = toBinaryUsingToStringRadix(10)
        assertEquals("1010", result, "Binary representation of 10 should be '1010'")
    }

    @Test
    fun `Test int to binary using toString with radix function with zero input`() {
        val result = toBinaryUsingToStringRadix(0)
        assertEquals("0", result, "Binary representation of 0 should be '0'")
    }

    @Test
    fun `Test int to binary using toString with radix function with negative number input`() {
        val result = toBinaryUsingToStringRadix(-2)
        assertEquals("-10", result, "Binary representation of -2 should be '-10'")
    }

    @Test
    fun `Test int to binary using toString with radix function  with large number input`() {
        val result = toBinaryUsingToStringRadix(255)
        assertEquals("11111111", result, "Binary representation of 255 should be '11111111'")
    }

    @Test
    fun `Test is power of two with positive power of two input`() {
        assertTrue(isPowerOfTwoWithLoop(1), "1 is 2^0, so it should be a power of two")
        assertTrue(isPowerOfTwoWithLoop(2), "2 is 2^1, so it should be a power of two")
        assertTrue(isPowerOfTwoWithLoop(4), "4 is 2^2, so it should be a power of two")
        assertTrue(isPowerOfTwoWithLoop(8), "8 is 2^3, so it should be a power of two")
        assertTrue(isPowerOfTwoWithLoop(16), "16 is 2^4, so it should be a power of two")
    }

    @Test
    fun `Test is power of two with non-power of two input`() {
        assertFalse(isPowerOfTwoWithLoop(3), "3 is not a power of two")
        assertFalse(isPowerOfTwoWithLoop(5), "5 is not a power of two")
        assertFalse(isPowerOfTwoWithLoop(6), "6 is not a power of two")
        assertFalse(isPowerOfTwoWithLoop(10), "10 is not a power of two")
    }

    @Test
    fun `Test is power of two with zero input`() {
        assertFalse(isPowerOfTwoWithLoop(0), "0 is not a power of two")
    }

    @Test
    fun `Test is power of two with negative number input`() {
        val exception = assertThrows<IllegalArgumentException> {
            isPowerOfTwoWithLoop(-8)
        }
        assertEquals("Method argument cannot be negative. number=-8", exception.message)
    }

    @Test
    fun `Test is power of two using recursion with positive power of two input`() {
        assertTrue(isPowerOfTwoRecursive(1), "1 is 2^0, so it should be a power of two")
        assertTrue(isPowerOfTwoRecursive(2), "2 is 2^1, so it should be a power of two")
        assertTrue(isPowerOfTwoRecursive(4), "4 is 2^2, so it should be a power of two")
        assertTrue(isPowerOfTwoRecursive(8), "8 is 2^3, so it should be a power of two")
        assertTrue(isPowerOfTwoRecursive(16), "16 is 2^4, so it should be a power of two")
    }

    @Test
    fun `Test is power of two using recursion with non-power of two input`() {
        assertFalse(isPowerOfTwoRecursive(3), "3 is not a power of two")
        assertFalse(isPowerOfTwoRecursive(5), "5 is not a power of two")
        assertFalse(isPowerOfTwoRecursive(6), "6 is not a power of two")
        assertFalse(isPowerOfTwoRecursive(10), "10 is not a power of two")
    }

    @Test
    fun `Test is power of two using recursion with zero input`() {
        assertFalse(isPowerOfTwoRecursive(0), "0 is not a power of two")
    }

    @Test
    fun `Test is power of two using recursion with negative number input`() {
        val exception = assertThrows<IllegalArgumentException> {
            isPowerOfTwoRecursive(-8)
        }
        assertEquals("Method argument cannot be negative. number=-8", exception.message)
    }

    @Test
    fun `Test is power of two using log with positive power of two input`() {
        assertTrue(isPowerOfTwoUsingLog(1), "1 is 2^0, so it should be a power of two")
        assertTrue(isPowerOfTwoUsingLog(2), "2 is 2^1, so it should be a power of two")
        assertTrue(isPowerOfTwoUsingLog(4), "4 is 2^2, so it should be a power of two")
        assertTrue(isPowerOfTwoUsingLog(8), "8 is 2^3, so it should be a power of two")
        assertTrue(isPowerOfTwoUsingLog(16), "16 is 2^4, so it should be a power of two")
    }

    @Test
    fun `Test is power of two using log with non-power of two input`() {
        assertFalse(isPowerOfTwoUsingLog(3), "3 is not a power of two")
        assertFalse(isPowerOfTwoUsingLog(5), "5 is not a power of two")
        assertFalse(isPowerOfTwoUsingLog(6), "6 is not a power of two")
        assertFalse(isPowerOfTwoUsingLog(10), "10 is not a power of two")
    }

    @Test
    fun `Test is power of two using log with zero input`() {
        assertFalse(isPowerOfTwoUsingLog(0), "0 is not a power of two")
    }

    @Test
    fun `Test is power of two using log with negative number input`() {
        val exception = assertThrows<IllegalArgumentException> {
            isPowerOfTwoUsingLog(-8)
        }
        assertEquals("Method argument cannot be negative. number=-8", exception.message)
    }

    @Test
    fun `Test is power of two using bit manipulation with positive power of two input`() {
        assertTrue(isPowerOfTwoUsingBits(1), "1 is 2^0, so it should be a power of two")
        assertTrue(isPowerOfTwoUsingBits(2), "2 is 2^1, so it should be a power of two")
        assertTrue(isPowerOfTwoUsingBits(4), "4 is 2^2, so it should be a power of two")
        assertTrue(isPowerOfTwoUsingBits(8), "8 is 2^3, so it should be a power of two")
        assertTrue(isPowerOfTwoUsingBits(16), "16 is 2^4, so it should be a power of two")
    }

    @Test
    fun `Test is power of two using bit manipulation with non-power of two input`() {
        assertFalse(isPowerOfTwoUsingBits(3), "3 is not a power of two")
        assertFalse(isPowerOfTwoUsingBits(5), "5 is not a power of two")
        assertFalse(isPowerOfTwoUsingBits(6), "6 is not a power of two")
        assertFalse(isPowerOfTwoUsingBits(10), "10 is not a power of two")
    }

    @Test
    fun `Test is power of two using bit manipulation with zero input`() {
        assertFalse(isPowerOfTwoUsingBits(0), "0 is not a power of two")
    }

    @Test
    fun `Test is power of two using bit manipulation with negative number input`() {
        val exception = assertThrows<IllegalArgumentException> {
            isPowerOfTwoUsingBits(-8)
        }
        assertEquals("Method argument cannot be negative. number=-8", exception.message)
    }
}
