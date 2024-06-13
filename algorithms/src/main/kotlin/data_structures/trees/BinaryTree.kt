package data_structures.trees

import data_structures.base.ITree

class BinaryTree<T> : ITree<T> {
    private var root: Node<T>? = null

    private data class Node<T>(var value: T, var left: Node<T>? = null, var right: Node<T>? = null)

    override fun insert(value: T) {
        root = insertRec(root, value)
    }

    override fun remove(value: T): Boolean {
        val (newRoot, removed) = removeRec(root, value)
        root = newRoot
        return removed
    }

    override fun find(value: T): Boolean {
        return findRec(root, value)
    }

    override fun traverse(action: (T) -> Unit) {
        traverseRec(root, action)
    }

    override fun size(): Int {
        return sizeRec(root)
    }

    override fun height(): Int {
        return heightRec(root)
    }

    override fun printTree() {
        printTreeRec(root, "", true)
    }

    private fun insertRec(node: Node<T>?, value: T): Node<T> {
        if (node == null) {
            return Node(value)
        }

        if (Math.random() < 0.5) {
            node.left = insertRec(node.left, value)
        } else {
            node.right = insertRec(node.right, value)
        }
        return node
    }

    private fun findSmallest(node: Node<T>): T {
        return node.left?.let { findSmallest(it) } ?: node.value
    }

    private fun findRec(node: Node<T>?, value: T): Boolean {
        if (node == null) {
            return false
        }
        if (node.value == value) {
            return true
        }
        return findRec(node.left, value) || findRec(node.right, value)
    }

    private fun traverseRec(node: Node<T>?, action: (T) -> Unit) {
        if (node != null) {
            traverseRec(node.left, action)
            action(node.value)
            traverseRec(node.right, action)
        }
    }

    private fun sizeRec(node: Node<T>?): Int {
        return if (node == null) {
            0
        } else {
            1 + sizeRec(node.left) + sizeRec(node.right)
        }
    }


    private fun heightRec(node: Node<T>?): Int {
        return if (node == null) {
            0
        } else {
            1 + maxOf(heightRec(node.left), heightRec(node.right))
        }
    }

    private fun removeRec(node: Node<T>?, value: T): Pair<Node<T>?, Boolean> {
        if (node == null) {
            return Pair(null, false)
        }

        if (node.value == value) {
            return when {
                node.left == null -> Pair(node.right, true)
                node.right == null -> Pair(node.left, true)
                else -> {
                    val smallestValue = findSmallest(node.right!!)
                    node.value = smallestValue
                    val (newRight, _) = removeRec(node.right, smallestValue)
                    node.right = newRight
                    Pair(node, true)
                }
            }
        }

        val (newLeft, removedLeft) = removeRec(node.left, value)
        if (removedLeft) {
            node.left = newLeft
            return Pair(node, true)
        }

        val (newRight, removedRight) = removeRec(node.right, value)
        node.right = newRight
        return Pair(node, removedRight)
    }

    private fun printTreeRec(node: Node<T>?, prefix: String, isTail: Boolean) {
        if (node != null) {
            println(prefix + (if (isTail) "└── " else "├── ") + node.value)
            printTreeRec(node.left, prefix + if (isTail) "    " else "│   ", false)
            printTreeRec(node.right, prefix + if (isTail) "    " else "│   ", true)
        }
    }
}