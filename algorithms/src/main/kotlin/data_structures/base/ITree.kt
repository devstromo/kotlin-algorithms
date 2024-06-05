package data_structures.base

interface ITree<T> {
    /**
     * Inserts an element into the tree.
     *
     * @param value the value to be inserted
     */
    fun insert(value: T)

    /**
     * Removes an element from the tree.
     *
     * @param value the value to be removed
     * @return `true` if the element was successfully removed, `false` otherwise
     */
    fun remove(value: T): Boolean

    /**
     * Finds an element in the tree.
     *
     * @param value the value to be found
     * @return `true` if the element is found, `false` otherwise
     */
    fun find(value: T): Boolean

    /**
     * Traverses the tree in a specific order and performs the given action on each element.
     *
     * @param action the action to be performed on each element
     */
    fun traverse(action: (T) -> Unit)

    /**
     * Returns the number of elements in the tree.
     *
     * @return the size of the tree
     */
    fun size(): Int

    /**
     * Returns the height of the tree.
     *
     * The height of a tree is the length of the longest path from the root to a leaf node.
     *
     * @return the height of the tree
     */
    fun height(): Int
}