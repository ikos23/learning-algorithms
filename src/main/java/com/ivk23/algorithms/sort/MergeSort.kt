package com.ivk23.algorithms.sort

class MergeSort<T> {

    // temp array to be used in merging
    private lateinit var aux: Array<Comparable<T>?>;

    fun sort(arr: Array<Comparable<T>>) {
        this.aux = arrayOfNulls(arr.size)
        sort(arr, 0, arr.size - 1)
    }

    private fun sort(arr: Array<Comparable<T>>, lo: Int, hi: Int) {
        println("sort iteration. lo=$lo, hi=$hi")
        if (hi <= lo) return
        val mid = lo + (hi - lo) / 2
        sort(arr, lo, mid) // left part sort
        sort(arr, mid + 1, hi) // right part sort
        merge(arr, lo, mid, hi)
    }

    private fun merge(arr: Array<Comparable<T>>, lo: Int, mid: Int, hi: Int) {
        println("merge iteration. lo=$lo, mid=$mid, hi=$hi")
        print("current aux: ")
        aux.forEach { print("$it ") }
        println()

        print("current arr: ")
        arr.forEach { print("$it ") }
        println()

        var i = lo
        var j = mid + 1
        for (k in lo..hi) aux[k] = arr[k] // copy arr[lo..hi] into aux[lo..hi]
        for (k in lo..hi) {
            when {
                i > mid -> arr[k] = aux[j++]!!
                j > hi -> arr[k] = aux[i++]!!
                (aux[j]!! < aux[i]!! as T) -> arr[k] = aux[j++]!!
                else -> arr[k] = aux[i++]!!
            }
            /*if (i > mid) arr[k] = aux[j++]!!
            else if (j > hi) arr[k] = aux[i++]!!
            else if ((aux[j]!! < aux[i]!! as T)) arr[k] = aux[j++]!!
            else arr[k] = aux[i++]!!*/
        }
    }

}

fun main() {
    val mergeSort = MergeSort<Int>()
    val arr: Array<Comparable<Int>> = arrayOf(3, 2, 1, 4)

    mergeSort.sort(arr)

    arr.forEach { print("$it ") }

    val mergeSortStr = MergeSort<String>()
    val strArr: Array<Comparable<String>> = "MERGESORTEXAMPLE"
            .asSequence()
            .map { it.toString() }
            .toList()
            .toTypedArray()
    mergeSortStr.sort(strArr)

    strArr.forEach { print("$it ") }
}