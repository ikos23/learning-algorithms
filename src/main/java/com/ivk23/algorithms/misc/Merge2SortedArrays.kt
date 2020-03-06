package com.ivk23.algorithms.misc

class Merge2SortedArrays {

    companion object {
        fun merge(dataSource1: List<String>,
                  dataSource2: List<String>): List<String> {

            val it1 = dataSource1.iterator()
            val it2 = dataSource2.iterator()

            val resultList = ArrayList<String>()

            val first = it1.next()
            var temp = it2.next()

            var currIterator : Iterator<String> = it1
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

    val merged = Merge2SortedArrays.merge(ds1, ds2)

    println("------------------------")
    merged.forEach { print("$it ") }

}