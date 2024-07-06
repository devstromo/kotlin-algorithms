package division

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivisionKtUnitTest {
    @Test
    fun `Test division`() {
        assertEquals(1, division(5, 5))
        assertEquals(1, division(6, 5))
        assertEquals(2, division(10, 5))
        assertEquals(2, division(10, 8))
    }
}