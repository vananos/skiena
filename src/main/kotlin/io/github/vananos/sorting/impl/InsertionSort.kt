package io.github.vananos.sorting.impl

import io.github.vananos.sorting.StableSortingAlgorithm

class InsertionSort : StableSortingAlgorithm {
    override fun <T> sort(array: Array<T>, comparator: Comparator<T>) {
        for (i in 1 until array.size) {
            var j = i
            while (j > 0 && comparator.compare(array[j], array[j - 1]) < 0) {
                val tmp = array[j]
                array[j] = array[j - 1]
                array[j - 1] = tmp
                j--
            }
        }
    }

}