package io.github.vananos.datastructures

class Heap<T>(val array: Array<T>, val comparator: Comparator<T>) {
    private var n: Int = array.size

    fun sort() {
        val size = n - 1
        for (i in size downTo 0) {
            array[i] = extractMin()
        }
    }

    fun extractMin(): T {
        if (n < 0) throw NoSuchElementException("Heap is empty")
        val result = array[0]
        array[0] = array[--n]
        bubbleDown(0)
        return result
    }

    fun heapify() {
        for (i in array.size - 1 downTo 0) {
            bubbleDown(i)
        }
    }

    private fun compare(i: Int, j: Int): Int {
        return comparator.compare(array[i], array[j])
    }

    private fun bubbleUp(index: Int) {
        val p = parent(index)
        if (p < 0) return
        if (compare(p, index) < 0) {
            swap(p, index)
            bubbleUp(p)
        }
    }

    private fun bubbleDown(index: Int) {
        val c = child(index)
        if (c >= n) return

        var min = index
        for (i in 0 until 2) {
            if (c + i < n && compare(min, c + i) < 0) {
                min = c + i
            }
        }
        if (min != index) {
            swap(min, index)
            bubbleDown(min)
        }
    }

    private fun swap(i: Int, j: Int) {
        val tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
    }

    private fun child(index: Int): Int {
        return (index + 1) * 2 - 1
    }

    private fun parent(index: Int): Int {
        if (index <= 0) return -1
        return (index - 1) / 2
    }
}