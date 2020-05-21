package io.github.vananos.sorting.impl

import io.github.vananos.sorting.UnstableSortingAlgorithm

class SelectionSort : UnstableSortingAlgorithm {
    override fun <T> sort(array: Array<T>, comparator: Comparator<T>) {
        for (i in 0 until array.size - 1) {
            var minIdx = i
            for (j in i + 1 until array.size) {
                if (comparator.compare(array[j], array[minIdx]) < 0) {
                    minIdx = j
                }
            }
            if (minIdx != i) {
                val tmp = array[i]
                array[i] = array[minIdx]
                array[minIdx] = tmp
            }
        }
    }

}