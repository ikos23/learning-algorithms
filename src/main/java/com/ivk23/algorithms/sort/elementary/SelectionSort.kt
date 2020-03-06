package com.ivk23.algorithms.sort.elementary

/**
 * Probably the simplest sorting algorithm :)
 */
class SelectionSort {

    // just to have all methods like static Java methods
    companion object {

        fun <T : Comparable<T>> orderAsc(): (T, T) -> Boolean = { a, b -> a < b }

        fun <T : Comparable<T>> orderDesc(): (T, T) -> Boolean = { a, b -> a > b }

        fun <T : Comparable<T>> sort(arr: Array<T>,
                                     order: (T, T) -> Boolean) {
            // print original array
            printArr(arr)

            val size = arr.size

            for (i in arr.indices) {
                var target = i // save minimum or maximum elem index (depends on order)
                for (j in i + 1 until size) {
                    if (order(arr[j], arr[target])) {
                        target = j
                    }
                }
                swap(arr, i, target)
                printArr(arr)
            }

        }

        private fun <T : Comparable<T>> swap(arr: Array<T>, i: Int, j: Int) {
            println("iteration $i: swap elem at index $i with elem at index $j")
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }

        private fun <T : Comparable<T>> printArr(arr: Array<T>) {
            println("-----")
            print("Array: ")
            arr.forEach { print("${it} ") }
            println()
            println("-----")
        }
    }
}

fun main() {
    SelectionSort.sort(arrayOf(4, 2, 1, 7, 9, 5), SelectionSort.orderAsc())
    SelectionSort.sort(arrayOf("b", "c", "a", "f", "d"), SelectionSort.orderDesc())
}