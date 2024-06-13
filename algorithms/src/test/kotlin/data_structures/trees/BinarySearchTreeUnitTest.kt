package data_structures.trees

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BinarySearchTreeUnitTest {
    private lateinit var tree: BinarySearchTree<Int>

    @BeforeEach
    fun setUp() {
        tree = BinarySearchTree()
    }

    @Test
    fun `Test Insert And Find`() {
        tree.insert(10)
        tree.insert(5)
        tree.insert(15)

        assertTrue(tree.find(10), "The tree should contain 10")
        assertTrue(tree.find(5), "The tree should contain 5")
        assertTrue(tree.find(15), "The tree should contain 15")
        assertFalse(tree.find(20), "The tree should not contain 20")

        tree.insert(3)

        tree.insert(17)
        tree.insert(7)
        tree.insert(9)
        tree.insert(8)
        tree.printTree()
    }

    @Test
    fun `Test Remove`() {
        tree.insert(10)
        tree.insert(5)
        tree.insert(15)

        assertTrue(tree.remove(5), "Removing 5 should be successful")
        assertFalse(tree.find(5), "The tree should not contain 5 after removal")
        assertTrue(tree.find(10), "The tree should still contain 10")
        assertTrue(tree.find(15), "The tree should still contain 15")

        assertFalse(tree.remove(20), "Removing 20 should fail as it does not exist in the tree")
    }

    @Test
    fun `Test Traverse`() {
        val values = mutableListOf<Int>()
        tree.insert(10)
        tree.insert(5)
        tree.insert(15)

        tree.traverse { values.add(it) }

        assertEquals(listOf(5, 10, 15), values, "The tree should traverse in-order")
    }

    @Test
    fun `Test Size`() {
        assertEquals(0, tree.size(), "The size of an empty tree should be 0")

        tree.insert(10)
        tree.insert(5)
        tree.insert(15)

        assertEquals(3, tree.size(), "The size of the tree should be 3 after inserting 3 elements")

        tree.remove(5)
        assertEquals(2, tree.size(), "The size of the tree should be 2 after removing one element")
    }

    @Test
    fun `Test Height`() {
        assertEquals(0, tree.height(), "The height of an empty tree should be 0")

        tree.insert(10)
        assertEquals(1, tree.height(), "The height of the tree should be 1 after inserting the root")

        tree.insert(5)
        tree.insert(15)
        assertEquals(2, tree.height(), "The height of the tree should be 2 after inserting 2 children")

        tree.insert(3)
        assertEquals(3, tree.height(), "The height of the tree should be 3 after inserting a grandchild")
    }
}