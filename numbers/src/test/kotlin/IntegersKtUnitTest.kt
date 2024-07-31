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
}
