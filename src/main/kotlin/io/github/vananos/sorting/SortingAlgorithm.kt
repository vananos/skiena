package io.github.vananos.sorting

interface SortingAlgorithm {
    fun <T : Comparable<T>> sort(array: Array<T>) {
        sort(array, Comparator { a, b -> a.compareTo(b) })
    }

    fun <T> sort(array: Array<T>, comparator: Comparator<T>)
}