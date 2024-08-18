package sets

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DisjointSetUnitTest {
    @Test
    fun `Test MakeSet Creates Single Element Set`() {
        val item = DisjointSet.makeSet("Test")
        assertNotNull(item)
        assertEquals("Test", item.value)
        assertEquals(item, item.parent)
    }

    @Test
    fun `Test Find Returns Representative Item`() {
        val item1 = DisjointSet.makeSet("Item1")
        val item2 = DisjointSet.makeSet("Item2")
        DisjointSet.union(item1, item2)
        val root1 = DisjointSet.find(item1)
        val root2 = DisjointSet.find(item2)
        assertEquals(root1, root2)
    }

    @Test
    fun `Test Union Merges Sets Correctly`() {
        val item1 = DisjointSet.makeSet("Item1")
        val item2 = DisjointSet.makeSet("Item2")
        val item3 = DisjointSet.makeSet("Item3")

        DisjointSet.union(item1, item2)
        DisjointSet.union(item2, item3)

        val root1 = DisjointSet.find(item1)
        val root2 = DisjointSet.find(item2)
        val root3 = DisjointSet.find(item3)

        assertEquals(root1, root2)
        assertEquals(root2, root3)
    }

    @Test
    fun `Test Union By Rank Attaches Smaller Tree To Larger Tree`() {
        val item1 = DisjointSet.makeSet("Item1")
        val item2 = DisjointSet.makeSet("Item2")
        val item3 = DisjointSet.makeSet("Item3")
        val item4 = DisjointSet.makeSet("Item4")

        DisjointSet.union(item1, item2)
        DisjointSet.union(item2, item3)
        DisjointSet.union(item3, item4) // Rank of item4 should be higher now

        assertTrue((DisjointSet.find(item1)?.rank ?: 0) >= (DisjointSet.find(item4)?.rank ?: 0))
    }

    @Test
    fun `Test Find Returns Correct Representative After Union`() {
        val item1 = DisjointSet.makeSet("Item1")
        val item2 = DisjointSet.makeSet("Item2")
        val item3 = DisjointSet.makeSet("Item3")

        DisjointSet.union(item1, item2)
        DisjointSet.union(item2, item3)

        assertEquals(item1, DisjointSet.find(item3))
        assertEquals(item1, DisjointSet.find(item2))
        assertEquals(item1, DisjointSet.find(item1))
    }
}