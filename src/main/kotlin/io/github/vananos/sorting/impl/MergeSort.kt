package io.github.vananos.sorting.impl

import io.github.vananos.sorting.StableSortingAlgorithm

class MergeSort : StableSortingAlgorithm {
    override fun <T> sort(array: Array<T>, comparator: Comparator<T>) {
        val tmp = arrayOfNulls<Any?>(array.size)
        mergeSort(array, comparator, 0, array.size, tmp)
    }

    private fun <T> mergeSort(array: Array<T>, comparator: Comparator<T>, l: Int, r: Int, tmp: Array<Any?>) {
        if (r - l <= 1) return
        val mid = (l + r) / 2
        mergeSort(array, comparator, l, mid, tmp)
        mergeSort(array, comparator, mid, r, tmp)
        merge(array, comparator, l, mid, r, tmp)
    }

    private fun <T> merge(
        array: Array<T>,
        comparator: Comparator<T>,
        l: Int, mid: Int, r: Int,
        tmp: Array<Any?>
    ) {
        var i = l
        var j = mid
        var x = 0
        while (i < mid && j < r) {
            val cmp = comparator.compare(array[i], array[j])
            if (cmp <= 0) {
                tmp[x] = array[i++]
            } else {
                tmp[x] = array[j++]
            }
            x++
        }
        while (i < mid) tmp[x++] = array[i++]
        while (j < r) tmp[x++] = array[j++]

        x = 0
        for (t in l until r) {
            array[t] = tmp[x++] as T
        }
    }
}