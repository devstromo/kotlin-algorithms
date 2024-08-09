import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LongsKtUnitTest {
    @Test
    fun `Test to binary using divide and modulus with positive number input`() {
        val result = toBinaryUsingDivideAndModulusLong(10)
        assertEquals("1010", result, "Binary representation of 10 should be '1010'")
    }

    @Test
    fun `Test to binary using divide and modulus with zero input`() {
        val result = toBinaryUsingDivideAndModulusLong(0)
        assertEquals("0", result, "Binary representation of 0 should be '0'")
    }

    @Test
    fun `Test to binary using divide and modulus with negative number input`() {
        val exception = assertThrows<IllegalArgumentException> {
            toBinaryUsingDivideAndModulusLong(-1)
        }
        assertEquals("Method argument cannot be negative. number=-1", exception.message)
    }

    @Test
    fun `Test to binary using divide and modulus with large number input`() {
        val result = toBinaryUsingDivideAndModulusLong(255)
        assertEquals("11111111", result, "Binary representation of 255 should be '11111111'")
    }

    @Test
    fun `Test to binary using shifts and modulus with positive number input`() {
        val result = toBinaryUsingShiftsAndModulusLong(10)
        assertEquals("1010", result, "Binary representation of 10 should be '1010'")
    }

    @Test
    fun `Test to binary using shifts and modulus with zero input`() {
        val result = toBinaryUsingShiftsAndModulusLong(0)
        assertEquals("0", result, "Binary representation of 0 should be '0'")
    }

    @Test
    fun `Test to binary using shifts and modulus with negative number input`() {
        val exception = assertThrows<IllegalArgumentException> {
            toBinaryUsingShiftsAndModulusLong(-1)
        }
        assertEquals("Method argument cannot be negative. number=-1", exception.message)
    }

    @Test
    fun `Test to binary using shifts and modulus with large number input`() {
        val result = toBinaryUsingShiftsAndModulusLong(255)
        assertEquals("11111111", result, "Binary representation of 255 should be '11111111'")
    }
}