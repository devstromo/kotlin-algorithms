package sorting.heapsort

class Heapsort {
    fun heapSort(array: IntArray) {
        val n = array.size

        for (i in n / 2 - 1 downTo 0) {
            heapify(array, n, i)
        }

        for (i in n - 1 downTo 0) {
            swap(array, 0, i)

            heapify(array, i, 0)
        }
    }

    private fun heapify(array: IntArray, heapSize: Int, rootIndex: Int) {
        var largest = rootIndex
        val leftChild = 2 * rootIndex + 1
        val rightChild = 2 * rootIndex + 2

        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild
        }

        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild
        }

        if (largest != rootIndex) {
            swap(array, rootIndex, largest)

            heapify(array, heapSize, largest)
        }
    }

    private fun swap(array: IntArray, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}