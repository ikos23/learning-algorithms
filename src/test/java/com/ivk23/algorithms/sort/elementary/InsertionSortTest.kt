package com.ivk23.algorithms.sort.elementary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InsertionSortTest {

    @Test
    fun `test numbers arr asc sorting`() {
        val targetArr = arrayOf(4, 0, 2, 6, 1, 7, 3, 5)
        InsertionSort.sort(targetArr, InsertionSort.orderAsc())

        for (i in targetArr.indices) {
            assertEquals(i, targetArr[i])
        }
    }

    @Test
    fun `test strings arr desc sorting`() {
        val targetArr = arrayOf("a", "d", "c", "f", "b", "e")
        InsertionSort.sort(targetArr, InsertionSort.orderDesc())

        assertEquals("fedcba", targetArr.joinToString(""))
    }
}