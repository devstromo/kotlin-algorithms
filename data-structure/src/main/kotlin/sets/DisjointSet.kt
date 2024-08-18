package sets

class DisjointSet<T> private constructor() {

    companion object {

        /**
         * Creates a set of one element.
         *
         * @param v Value to use when creating the set
         * @return Item representing the value
         */
        fun <T> makeSet(v: T): Item<T> {
            val item = Item(null, v)
            item.parent = item
            return item
        }

        /**
         * Determine which subset a particular element is in. Find returns an item from this set that serves as its "representative";
         * by comparing the result of two Find operations, one can determine whether two elements are in the same subset.
         * This method uses path compression which is a way of flattening the structure of the tree whenever Find is used on it.
         *
         * @param x Find the "representative" of this Item
         * @return "Representative" of this Item
         */
        fun <T> find(x: Item<T>?): Item<T>? {
            if (x == null) return null
            if (x.parent != null && x.parent != x) {
                x.parent = find(x.parent) // Path compression
            }
            return x.parent
        }

        /**
         * Join two subsets into a single subset. This method uses 'union by rank' which always attaches
         * the smaller tree to the root of the larger tree.
         *
         * @param x Subset 1 to join
         * @param y Subset 2 to join
         * @return Resulting Set of joining Subset 1 and Subset 2
         */
        fun <T> union(x: Item<T>?, y: Item<T>?): Item<T>? {
            val xRoot = find(x)
            val yRoot = find(y)

            if (xRoot == null && yRoot == null) return null
            if (xRoot == null) return yRoot
            if (yRoot == null) return xRoot

            if (xRoot == yRoot) return xRoot

            return if (xRoot.rank < yRoot.rank) {
                xRoot.parent = yRoot
                yRoot
            } else if (xRoot.rank > yRoot.rank) {
                yRoot.parent = xRoot
                xRoot
            } else {
                yRoot.parent = xRoot
                xRoot.rank++
                xRoot
            }
        }
    }

    class Item<T>(var parent: Item<T>?, val value: T) {
        /**
         * Rank is not the actual depth of the tree rather it is an upper bound. As such, on a find operation,
         * the rank is allowed to get out of sync with the depth.
         * **/
        var rank: Long = 0

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Item<*>

            if (parent != null && other.parent != null && parent?.value != other.parent?.value) return false
            if (value != other.value) return false

            return true
        }

        override fun hashCode(): Int {
            var result = parent?.value?.hashCode() ?: 0
            result = 31 * result + (value?.hashCode() ?: 0)
            return result
        }

        override fun toString(): String {
            return "parent=${parent?.value} ${if (rank > 0) "rank=$rank " else ""}value=$value"
        }
    }
}
