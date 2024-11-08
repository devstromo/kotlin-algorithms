package sequences.top_k_elements

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TopKElementsUnitTest {
    private val solution = TopKElements()

    @Test
    fun `Test K top elements`() {
        assertEquals(5, solution.topKElements(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    }
}