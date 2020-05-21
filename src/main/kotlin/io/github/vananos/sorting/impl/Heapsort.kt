package io.github.vananos.sorting.impl

import io.github.vananos.datastructures.Heap
import io.github.vananos.sorting.UnstableSortingAlgorithm

class Heapsort : UnstableSortingAlgorithm {
    override fun <T> sort(array: Array<T>, comparator: Comparator<T>) {
        val heap = Heap(array, comparator)
        heap.heapify()
        heap.sort()
    }
}
