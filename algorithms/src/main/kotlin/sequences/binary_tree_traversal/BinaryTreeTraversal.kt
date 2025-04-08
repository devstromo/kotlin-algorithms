package sequences.binary_tree_traversal

/**
 * Implements binary tree traversal algorithms: InOrder, PreOrder, and PostOrder.
 *
 * Traversal order:
 * - InOrder:    left -> root -> right
 * - PreOrder:   root -> left -> right
 * - PostOrder:  left -> right -> root
 */
class BinaryTreeTraversal {
    data class TreeNode(val value: Int, val left: TreeNode? = null, val right: TreeNode? = null)

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        fun inorder(node: TreeNode?) {
            if (node == null) return
            inorder(node.left)
            result.add(node.value)
            inorder(node.right)
        }
        inorder(root)
        return result
    }

    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        fun preorder(node: TreeNode?) {
            if (node == null) return
            result.add(node.value)
            preorder(node.left)
            preorder(node.right)
        }
        preorder(root)
        return result
    }

    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        fun postorder(node: TreeNode?) {
            if (node == null) return
            postorder(node.left)
            postorder(node.right)
            result.add(node.value)
        }
        postorder(root)
        return result
    }
}