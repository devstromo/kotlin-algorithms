package sequences.binary_tree_traversal

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class BinaryTreeTraversalUnitTest {
    private val solution = BinaryTreeTraversal()

    private fun buildSampleTree(): BinaryTreeTraversal.TreeNode {
        // Tree structure:
        //     1
        //      \
        //       2
        //      /
        //     3
        val node3 = BinaryTreeTraversal.TreeNode(3)
        val node2 = BinaryTreeTraversal.TreeNode(2, left = node3)
        return BinaryTreeTraversal.TreeNode(1, right = node2)
    }

    @Test
    fun testInorderTraversal() {
        val root = buildSampleTree()
        val expected = listOf(1, 3, 2)
        val result = solution.inorderTraversal(root)
        assertContentEquals(expected, result)
    }

    @Test
    fun testPreorderTraversal() {
        val root = buildSampleTree()
        val expected = listOf(1, 2, 3)
        val result = solution.preorderTraversal(root)
        assertContentEquals(expected, result)
    }

    @Test
    fun testPostorderTraversal() {
        val root = buildSampleTree()
        val expected = listOf(3, 2, 1)
        val result = solution.postorderTraversal(root)
        assertContentEquals(expected, result)
    }

    @Test
    fun testEmptyTree() {
        val root: BinaryTreeTraversal.TreeNode? = null
        assertContentEquals(emptyList(), solution.inorderTraversal(root))
        assertContentEquals(emptyList(), solution.preorderTraversal(root))
        assertContentEquals(emptyList(), solution.postorderTraversal(root))
    }
}