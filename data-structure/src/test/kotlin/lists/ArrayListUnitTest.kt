package lists

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ArrayListUnitTest {
    private lateinit var arrayList: ArrayList<Int>

    @BeforeEach
    fun setUp() {
        arrayList = ArrayList()
    }

    @Test
    fun `Test Add`() {
        assertTrue(arrayList.add(1))
        assertTrue(arrayList.add(2))
        assertEquals(2, arrayList.size())
        assertEquals(1, arrayList.get(0))
        assertEquals(2, arrayList.get(1))
    }

    @Test
    fun `Test Remove`() {
        arrayList.add(1)
        arrayList.add(2)
        arrayList.add(3)
        assertTrue(arrayList.remove(2))
        assertEquals(2, arrayList.size())
        assertEquals(1, arrayList.get(0))
        assertEquals(3, arrayList.get(1))
        assertFalse(arrayList.remove(4))
    }

    @Test
    fun `Test Set`() {
        arrayList.add(1)
        arrayList.add(2)
        assertEquals(2, arrayList.set(1, 3))
        assertEquals(3, arrayList.get(1))
        assertNull(arrayList.set(3, 4)) // Index out of bounds
    }

    @Test
    fun `Test Get`() {
        arrayList.add(1)
        arrayList.add(2)
        assertEquals(1, arrayList.get(0))
        assertEquals(2, arrayList.get(1))
        assertNull(arrayList.get(2)) // Index out of bounds
    }

    @Test
    fun `Test Clear`() {
        arrayList.add(1)
        arrayList.add(2)
        arrayList.clear()
        assertEquals(0, arrayList.size())
        assertNull(arrayList.get(0))
    }

    @Test
    fun `Test Contains`() {
        arrayList.add(1)
        arrayList.add(2)
        assertTrue(arrayList.contains(1))
        assertTrue(arrayList.contains(2))
        assertFalse(arrayList.contains(3))
    }

    @Test
    fun `Test Validate`() {
        arrayList.add(1)
        arrayList.add(2)
        assertTrue(arrayList.validate())
        arrayList.remove(1)
        assertTrue(arrayList.validate())
        arrayList.clear()
        assertTrue(arrayList.validate())
    }

    @Test
    fun `Test Add Beyond Initial Capacity`() {
        for (i in 0 until 2000) {
            arrayList.add(i)
        }
        assertEquals(2000, arrayList.size())
        for (i in 0 until 2000) {
            assertEquals(i, arrayList.get(i))
        }
    }
}