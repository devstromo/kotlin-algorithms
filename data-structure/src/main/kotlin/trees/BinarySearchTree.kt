package trees

import base.ITree

/**
 * A class representing a binary search tree structure.
 *
 * @param T the type of elements in this tree
 */
class BinarySearchTree<T : Comparable<T>> : ITree<T> {

    private var root: Node<T>? = null

    private data class Node<T>(var value: T, var left: Node<T>? = null, var right: Node<T>? = null)

    override fun insert(value: T) {
        root = insertRec(root, value)
    }

    private fun insertRec(node: Node<T>?, value: T): Node<T> {
        if (node == null) {
            return Node(value)
        }

        if (value < node.value) {
            node.left = insertRec(node.left, value)
        } else if (value > node.value) {
            node.right = insertRec(node.right, value)
        }
        return node
    }

    override fun remove(value: T): Boolean {
        val (newRoot, removed) = removeRec(root, value)
        root = newRoot
        return removed
    }

    private fun removeRec(node: Node<T>?, value: T): Pair<Node<T>?, Boolean> {
        if (node == null) {
            return Pair(null, false)
        }

        if (value < node.value) {
            val (newLeft, removedLeft) = removeRec(node.left, value)
            node.left = newLeft
            return Pair(node, removedLeft)
        } else if (value > node.value) {
            val (newRight, removedRight) = removeRec(node.right, value)
            node.right = newRight
            return Pair(node, removedRight)
        }

        // Node with only one child or no child
        if (node.left == null) return Pair(node.right, true)
        if (node.right == null) return Pair(node.left, true)

        // Node with two children: Get the inorder successor (smallest in the right subtree)
        val smallestValue = findSmallest(node.right!!)
        node.value = smallestValue
        val (newRight, _) = removeRec(node.right, smallestValue)
        node.right = newRight
        return Pair(node, true)
    }

    private fun findSmallest(node: Node<T>): T {
        return node.left?.let { findSmallest(it) } ?: node.value
    }

    override fun find(value: T): Boolean {
        return findRec(root, value)
    }

    private fun findRec(node: Node<T>?, value: T): Boolean {
        if (node == null) {
            return false
        }
        return when {
            value < node.value -> findRec(node.left, value)
            value > node.value -> findRec(node.right, value)
            else -> true
        }
    }

    override fun traverse(action: (T) -> Unit) {
        traverseRec(root, action)
    }

    private fun traverseRec(node: Node<T>?, action: (T) -> Unit) {
        if (node != null) {
            traverseRec(node.left, action)
            action(node.value)
            traverseRec(node.right, action)
        }
    }

    override fun size(): Int {
        return sizeRec(root)
    }

    private fun sizeRec(node: Node<T>?): Int {
        return if (node == null) {
            0
        } else {
            1 + sizeRec(node.left) + sizeRec(node.right)
        }
    }

    override fun height(): Int {
        return heightRec(root)
    }

    override fun printTree() {
        if (root == null) {
            println("Tree is empty")
        } else {
            printTreeRec(root, "", true)
        }
    }

    private fun heightRec(node: Node<T>?): Int {
        return if (node == null) {
            0
        } else {
            1 + maxOf(heightRec(node.left), heightRec(node.right))
        }
    }

    private fun printTreeRec(node: Node<T>?, prefix: String, isTail: Boolean) {
        if (node != null) {
            println(prefix + (if (isTail) "└── " else "├── ") + node.value)
            val children = listOf(node.left, node.right).filterNotNull()
            for ((index, child) in children.withIndex()) {
                printTreeRec(child, prefix + if (isTail) "    " else "│   ", index == children.size - 1)
            }
        }
    }
}
