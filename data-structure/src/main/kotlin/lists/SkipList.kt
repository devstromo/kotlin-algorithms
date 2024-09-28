package lists

import base.IList
import kotlin.random.Random

class SkipList<T : Comparable<T>>(
    private val maxLevel: Int = 16,
    private val p: Double = 0.5
) : IList<T> {

    private var level = 1 // Current level of skip list
    private val header = SkipListNode<T>(null, maxLevel) // Header node
    private var size = 0 // Number of elements in the skip list

    private fun randomLevel(): Int {
        var lvl = 1
        while (Random.nextDouble() < p && lvl < maxLevel) {
            lvl++
        }
        return lvl
    }

    override fun add(value: T): Boolean {
        val update = arrayOfNulls<SkipListNode<T>>(maxLevel)
        var x = header

        for (i in level - 1 downTo 0) {
            while (x.forward[i] != null && x.forward[i]!!.value!! < value) {
                x = x.forward[i]!!
            }
            update[i] = x
        }

        val lvl = randomLevel()
        if (lvl > level) {
            for (i in level until lvl) {
                update[i] = header
            }
            level = lvl
        }

        val newNode = SkipListNode(value, lvl)
        for (i in 0 until lvl) {
            newNode.forward[i] = update[i]?.forward?.get(i)
            update[i]?.forward?.set(i, newNode)
        }
        size++
        return true
    }

    override fun remove(value: T): Boolean {
        val update = arrayOfNulls<SkipListNode<T>>(maxLevel)
        var x = header

        for (i in level - 1 downTo 0) {
            while (x.forward[i] != null && x.forward[i]!!.value!! < value) {
                x = x.forward[i]!!
            }
            update[i] = x
        }

        val targetNode = x.forward[0]
        if (targetNode == null || targetNode.value != value) {
            return false
        }

        for (i in 0 until level) {
            if (update[i]?.forward?.get(i) != targetNode) break
            update[i]?.forward?.set(i, targetNode.forward[i])
        }

        while (level > 1 && header.forward[level - 1] == null) {
            level--
        }
        size--
        return true
    }

    override fun contains(value: T): Boolean {
        var x = header
        for (i in level - 1 downTo 0) {
            while (x.forward[i] != null && x.forward[i]!!.value!! < value) {
                x = x.forward[i]!!
            }
        }
        x = x.forward[0] ?: return false
        return x.value == value
    }

    override fun size(): Int = size

    override fun clear() {
        for (i in 0 until maxLevel) {
            header.forward[i] = null
        }
        level = 1
        size = 0
    }

    override fun validate(): Boolean {
        var current = header.forward[0]
        while (current?.forward?.get(0) != null) {
            if (current.value!! > current.forward[0]?.value!!) return false
            current = current.forward[0]
        }
        return true
    }

    private class SkipListNode<T : Comparable<T>>(val value: T?, level: Int) {
        val forward: Array<SkipListNode<T>?> = arrayOfNulls(level)
    }
}