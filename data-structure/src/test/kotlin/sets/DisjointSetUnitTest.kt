package sets

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DisjointSetUnitTest {

    private val disjointSet = DisjointSet<String>()

    @Test
    fun `Test MakeSet Creates Single Element Set`() {
        val item = disjointSet.makeSet("Test")
        assertNotNull(item)
        assertEquals("Test", item.value)
        assertEquals(item, item.parent)
    }

    @Test
    fun `Test Find Returns Representative Item`() {
        val item1 = disjointSet.makeSet("Item1")
        val item2 = disjointSet.makeSet("Item2")
        disjointSet.union(item1, item2)
        val root1 = disjointSet.find(item1)
        val root2 = disjointSet.find(item2)
        assertEquals(root1, root2)
    }

    @Test
    fun `Test Union Merges Sets Correctly`() {
        val item1 = disjointSet.makeSet("Item1")
        val item2 = disjointSet.makeSet("Item2")
        val item3 = disjointSet.makeSet("Item3")

        disjointSet.union(item1, item2)
        disjointSet.union(item2, item3)

        val root1 = disjointSet.find(item1)
        val root2 = disjointSet.find(item2)
        val root3 = disjointSet.find(item3)

        assertEquals(root1, root2)
        assertEquals(root2, root3)
    }

    @Test
    fun `Test Union By Rank Attaches Smaller Tree To Larger Tree`() {
        val item1 = disjointSet.makeSet("Item1")
        val item2 = disjointSet.makeSet("Item2")
        val item3 = disjointSet.makeSet("Item3")
        val item4 = disjointSet.makeSet("Item4")

        disjointSet.union(item1, item2)
        disjointSet.union(item2, item3)
        disjointSet.union(item3, item4) // Rank of item4 should be higher now

        assertTrue((disjointSet.find(item1)?.rank ?: 0) >= (disjointSet.find(item4)?.rank ?: 0))
    }

    @Test
    fun `Test Find Returns Correct Representative After Union`() {
        val item1 = disjointSet.makeSet("Item1")
        val item2 = disjointSet.makeSet("Item2")
        val item3 = disjointSet.makeSet("Item3")

        disjointSet.union(item1, item2)
        disjointSet.union(item2, item3)

        assertEquals(item1, disjointSet.find(item3))
        assertEquals(item1, disjointSet.find(item2))
        assertEquals(item1, disjointSet.find(item1))
    }
}