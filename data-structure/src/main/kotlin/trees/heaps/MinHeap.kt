package trees.heaps

import base.ITree
import kotlin.math.floor
import kotlin.math.ln
import kotlin.math.pow

class MinHeap<T : Comparable<T>> : ITree<T> {
    private val heap = mutableListOf<T>()

    override fun insert(value: T) {
        heap.add(value)
        heapifyUp(heap.size - 1)
    }

    override fun remove(value: T): Boolean {
        val index = heap.indexOf(value)
        if (index == -1) return false

        swap(index, heap.size - 1)
        heap.removeAt(heap.size - 1)

        if (index < heap.size) {
            heapifyDown(index)
            heapifyUp(index)
        }
        return true
    }

    override fun find(value: T): Boolean {
        return heap.contains(value)
    }

    override fun traverse(action: (T) -> Unit) {
        heap.forEach(action)
    }

    override fun size(): Int {
        return heap.size
    }

    override fun height(): Int {
        return if (heap.isEmpty()) 0 else floor(ln(heap.size.toDouble()) / ln(2.0)).toInt() + 1
    }

    override fun printTree() {
        if (heap.isEmpty()) {
            println("The heap is empty.")
            return
        }

        var level = 0
        var elementsInLevel = 1
        var i = 0

        while (i < heap.size) {
            while (i < elementsInLevel && i < heap.size) {
                print("${heap[i]} ")
                i++
            }
            println()
            level++
            elementsInLevel += 2.0.pow(level).toInt()
        }
    }

    private fun heapifyUp(index: Int) {
        var currentIndex = index
        val parentIndex = (currentIndex - 1) / 2

        while (currentIndex > 0 && heap[currentIndex] < heap[parentIndex]) {
            swap(currentIndex, parentIndex)
            currentIndex = parentIndex
        }
    }

    private fun heapifyDown(index: Int) {
        var currentIndex = index
        val size = heap.size

        while (true) {
            val leftChildIndex = 2 * currentIndex + 1
            val rightChildIndex = 2 * currentIndex + 2
            var smallestIndex = currentIndex

            if (leftChildIndex < size && heap[leftChildIndex] < heap[smallestIndex]) {
                smallestIndex = leftChildIndex
            }

            if (rightChildIndex < size && heap[rightChildIndex] < heap[smallestIndex]) {
                smallestIndex = rightChildIndex
            }

            if (smallestIndex != currentIndex) {
                swap(currentIndex, smallestIndex)
                currentIndex = smallestIndex
            } else {
                break
            }
        }
    }

    private fun swap(index1: Int, index2: Int) {
        val temp = heap[index1]
        heap[index1] = heap[index2]
        heap[index2] = temp
    }
}
