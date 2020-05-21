package io.github.vananos.sorting.impl

import io.github.vananos.sorting.StableSortingAlgorithm

class BubbleSort : StableSortingAlgorithm {
    override fun <T> sort(array: Array<T>, comparator: Comparator<T>) {
        do {
            var swapped = false
            for (j in 0..array.size - 2) {
                if (comparator.compare(array[j + 1], array[j]) < 0) {
                    val tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                    swapped = true
                }
            }
        } while (swapped)
    }
}