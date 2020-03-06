package com.ivk23.algorithms.misc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Merge2SortedArraysTest {

    @Test
    fun `very simple test case`() {
        val list1 = listOf("a1")
        val list2 = listOf("a1")

        val merged = Merge2SortedArrays.merge(list1, list2)

        assertEquals("a1", merged.joinToString(""))
    }

    @Test
    fun `two eq size lists no intersections`() {
        val list1 = listOf("a1", "a3", "a5")
        val list2 = listOf("a2", "a4", "a6")

        val merged = Merge2SortedArrays.merge(list1, list2)

        assertEquals("a1 a2 a3 a4 a5 a6", merged.joinToString(" "))
    }

    @Test
    fun `two eq size lists no intersections reversed`() {
        val list1 = listOf("a2", "a4", "a6")
        val list2 = listOf("a1", "a3", "a5")


        val merged = Merge2SortedArrays.merge(list1, list2)

        assertEquals("a1 a2 a3 a4 a5 a6", merged.joinToString(" "))
    }

    @Test
    fun `first list smaller than second`() {
        val list1 = listOf("a2", "b1")
        val list2 = listOf("a1", "a2", "a3", "a4", "b1")


        val merged = Merge2SortedArrays.merge(list1, list2)

        assertEquals("a1 a2 a3 a4 b1", merged.joinToString(" "))
    }

    @Test
    fun `second list smaller than first`() {
        val list1 = listOf("a1", "a2", "a3", "a4", "b1", "b2")
        val list2 = listOf("b1", "b4")

        val merged = Merge2SortedArrays.merge(list1, list2)

        assertEquals("a1 a2 a3 a4 b1 b2 b4", merged.joinToString(" "))
    }

    @Test
    fun `list which contains same elements`() {
        val list1 = listOf("a1", "a2", "a3", "a5", "a6", "a7")
        val list2 = listOf("a1", "a3", "a4", "b1", "b2", "b3")

        val merged = Merge2SortedArrays.merge(list1, list2)

        assertEquals("a1 a2 a3 a4 a5 a6 a7 b1 b2 b3", merged.joinToString(" "))
    }

    @Test
    fun `identical lists`() {
        val list1 = listOf("a1", "a2", "a3", "a4", "a5", "a6")
        val list2 = listOf("a1", "a2", "a3", "a4", "a5", "a6")

        val merged = Merge2SortedArrays.merge(list1, list2)

        assertEquals("a1 a2 a3 a4 a5 a6", merged.joinToString(" "))
    }

}