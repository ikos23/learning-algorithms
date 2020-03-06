package com.ivk23.algorithms.sort.elementary


class InsertionSort {

    // just to have all methods like static Java methods
    companion object {

        fun <T : Comparable<T>> orderAsc(): (T, T) -> Boolean = { a, b -> a < b }

        fun <T : Comparable<T>> orderDesc(): (T, T) -> Boolean = { a, b -> a > b }

        fun <T : Comparable<T>> sort(arr: Array<T>,
                                     order: (T, T) -> Boolean) {
            // print original array
            printArr(arr)

            val size = arr.size

            for (i in 1 until size) {
                for (j in i downTo 1) {
                    if (order(arr[j], arr[j - 1])) {
                        swap(arr, j, j - 1)
                        printArr(arr)
                    }

                }
            }

            printArr(arr) // sorted
        }

        private fun <T : Comparable<T>> swap(arr: Array<T>, i: Int, j: Int) {
            println("swap elem at index $i (${arr[i]}) with elem at index $j (${arr[j]})")
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
    InsertionSort.sort(arrayOf(4, 2, 1, 7, 9, 5), InsertionSort.orderAsc())
}