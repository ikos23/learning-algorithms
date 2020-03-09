package com.ivk23.algorithms.misc

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

class Merge2SortedCollections {

    companion object {

        /**
         * Merge two sorted arrays into a third one, keeping
         * the sorted order. Duplicates are not handled (you
         * will get them all in the result array .)
         */
        fun merge(src1: Array<String>,
                  src2: Array<String>,
                  res: Array<String>) {

            var i = 0
            var j = 0
            var k = 0

            while (i < src1.size && j < src2.size) {
                if (src1[i] <= src2[j]) {
                    res[k] = src1[i++]
                } else {
                    res[k] = src2[j++]
                }
                k++
            }

            if (i < src1.size) {
                for (p in i until src1.size) res[k++] = src1[p]
            } else {
                for (p in j until src2.size) res[k++] = src2[p]
            }

        }

        /**
         * Merge two sorted collections. Duplicates not included.
         */
        fun <T : Comparable<T>> merge(src1: Iterable<T>,
                                      src2: Iterable<T>): List<T> {

            val it1 = src1.iterator()
            val it2 = src2.iterator()

            val first = it1.next()
            var temp = it2.next()

            val resultList = ArrayList<T>()
            var currIterator: Iterator<T> = it1
            when {
                first < temp -> {
                    resultList.add(first)
                    currIterator = it1
                }
                first > temp -> {
                    resultList.add(temp)
                    temp = first
                    currIterator = it2
                }
            }

            while (it1.hasNext() || it2.hasNext()) {
                // if one iterator finished, there still might be another one :)
                if (!currIterator.hasNext()) {
                    currIterator = if (currIterator === it1) it2 else it1
                }

                val next = currIterator.next()
                println("${if (currIterator === it1) "it1" else "it2"} read $next, temp is $temp")
                when {
                    next < temp -> resultList.add(next)
                    next > temp -> {
                        resultList.add(temp)
                        temp = next
                        currIterator = if (currIterator === it1) it2 else it1
                    }

                }
            }

            resultList.add(temp)

            return resultList
        }

        /**
         * Merge data from 2 sorted files.
         * Not work correctly)) Don't have time for this.
         */
        fun merge(readFrom1Path: String,
                  readFrom2Path: String,
                  writeTo: File) {

            var reader1: BufferedReader? = null
            var reader2: BufferedReader? = null
            var writer: BufferedWriter? = null

            try {
                reader1 = object {}.javaClass.getResourceAsStream(readFrom1Path).bufferedReader()
                reader2 = object {}.javaClass.getResourceAsStream(readFrom2Path).bufferedReader()

                writer = BufferedWriter(FileWriter(writeTo))

                var left = reader1.readLine()
                var right = reader2.readLine()
                var temp: String?

                while (left != null && right != null) {
                    println("iteration: left=$left, right=$right")
                    if (left <= right) {
                        temp = left
                        left = reader1.readLine()
                    } else {
                        temp = right
                        right = reader2.readLine()
                    }
                    writer.appendln(temp)
                }
                writer.flush()
            } finally {
                reader1?.close()
                reader2?.close()
                writer?.close()
            }

        }
    }

}

fun main() {
    val ds1 = ArrayList<String>()
    ds1.add("a1")
    ds1.add("a2")
    ds1.add("a3")
    ds1.add("a5")
    ds1.add("a6")
    ds1.add("a7")

    val ds2 = ArrayList<String>()
    ds2.add("a1")
    ds2.add("a3")
    ds2.add("a4")
    ds2.add("b1")
    ds2.add("b2")
    ds2.add("b3")

    val merged = Merge2SortedCollections.merge(ds1, ds2)

    println("------------------------")
    merged.forEach { print("$it ") }

}