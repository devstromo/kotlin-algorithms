package dp.catalan_numbers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CatalanNumberUnitTest {
    private val solver = CatalanNumber()

    @Test
    fun `Test catalan for n = 0`() {
        assertEquals(1L, solver.catalan(0))
    }

    @Test
    fun `Test catalan for n = 1`() {
        assertEquals(1L, solver.catalan(1))
    }

    @Test
    fun `Test catalan for n = 2`() {
        assertEquals(2L, solver.catalan(2))
    }

    @Test
    fun `Test catalan for n = 3`() {
        assertEquals(5L, solver.catalan(3))
    }

    @Test
    fun `Test catalan for n = 4`() {
        assertEquals(14L, solver.catalan(4))
    }

    @Test
    fun `Test catalan for n = 5`() {
        assertEquals(42L, solver.catalan(5))
    }

    @Test
    fun `Test catalan for n = 6`() {
        assertEquals(132L, solver.catalan(6))
    }

}