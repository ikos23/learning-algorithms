package com.ivk23.algorithms.sort.elementary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SelectionSortTest {

    @Test
    fun `test numbers arr asc sorting`() {
        val targetArr = arrayOf(4, 0, 2, 6, 1, 7, 3, 5)
        SelectionSort.sort(targetArr, SelectionSort.orderAsc())

        for (i in targetArr.indices) {
            assertEquals(i, targetArr[i])
        }
    }

    @Test
    fun `test strings arr desc sorting`() {
        val targetArr = arrayOf("a", "d", "c", "f", "b", "e")
        SelectionSort.sort(targetArr, SelectionSort.orderDesc())

        assertEquals("fedcba", targetArr.joinToString(""))
    }

}