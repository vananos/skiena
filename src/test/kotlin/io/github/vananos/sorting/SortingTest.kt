package io.github.vananos.sorting

import io.github.vananos.sorting.impl.MergeSort
import junit.framework.Assert.assertTrue
import org.spekframework.spek2.Spek
import kotlin.random.Random
//TODO: nice asserts, dsl for test case definition
//TODO: add JMH
object SortingTest : Spek({

    group("Soring test") {
        val testCases = mapOf(
            "empty" to Array(0) { 0 },
            "single element" to arrayOf(1),
            "two elements (sorted)" to arrayOf(1, 2),
            "two elements (unsorted)" to arrayOf(2, 1),
            "three elements (sorted)" to arrayOf(1, 2, 3),
            "three elements (unsorted)" to arrayOf(3, 2, 1),
            "four elements (sorted)" to arrayOf(1, 2, 3, 4),
            "four elements (unsorted)" to arrayOf(4, 3, 2, 1),
            "thousand elements (random)" to List(111910) { Random.nextInt(0, 10000) }.toTypedArray()
        )

        testCases.forEach { (description, value) ->
            test("Sort when $description") {
                MergeSort().sort(value)
                println(value.joinToString())
                assertTrue(sorted(value))
            }
        }

    }
})

data class TestCase(val description: String, val array: Array<Int>, val sortingAlgorithm: SortingAlgorithm)

fun <T : Comparable<T>> sorted(array: Array<T>): Boolean {
    for (i in 0 until array.size - 1) {
        if (array[i] > array[i + 1]) return false
    }
    return true
}