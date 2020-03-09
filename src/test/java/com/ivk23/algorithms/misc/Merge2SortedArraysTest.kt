package com.ivk23.algorithms.misc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Merge2SortedArraysTest {

    @Test
    fun `very simple test case`() {
        val arr1 = arrayOf("a1")
        val arr2 = arrayOf("a1")
        val res = Array(2) { "" }

        Merge2SortedCollections.merge(arr1, arr2, res)

        assertEquals("a1 a1", res.joinToString(" "))
    }

    @Test
    fun `two eq size arrays no intersections`() {
        val arr1 = arrayOf("a1", "a3", "a5")
        val arr2 = arrayOf("a2", "a4", "a6")
        val res = Array(6) { "" }

        Merge2SortedCollections.merge(arr1, arr2, res)

        assertEquals("a1 a2 a3 a4 a5 a6", res.joinToString(" "))
    }

    @Test
    fun `two eq size arrays no intersections reversed`() {
        val arr1 = arrayOf("a2", "a4", "a6")
        val arr2 = arrayOf("a1", "a3", "a5")
        val res = Array(6) { "" }

        Merge2SortedCollections.merge(arr1, arr2, res)

        assertEquals("a1 a2 a3 a4 a5 a6", res.joinToString(" "))
    }

    @Test
    fun `first array smaller than second`() {
        val arr1 = arrayOf("a2", "b1")
        val arr2 = arrayOf("a1", "a2", "a3", "a4", "b1")
        val res = Array(7) { "" }

        Merge2SortedCollections.merge(arr1, arr2, res)

        assertEquals("a1 a2 a2 a3 a4 b1 b1", res.joinToString(" "))
    }

    @Test
    fun `second array smaller than first`() {
        val arr1 = arrayOf("a1", "a2", "a3", "a4", "b1", "b2")
        val arr2 = arrayOf("b1", "b4")
        val res = Array(8) { "" }

        Merge2SortedCollections.merge(arr1, arr2, res)

        assertEquals("a1 a2 a3 a4 b1 b1 b2 b4", res.joinToString(" "))
    }

    @Test
    fun `arrays with same elements`() {
        val arr1 = arrayOf("a1", "a2", "a3", "a5", "a6", "a7")
        val arr2 = arrayOf("a1", "a3", "a4", "b1", "b2", "b3")
        val res = Array(12) { "" }

        Merge2SortedCollections.merge(arr1, arr2, res)

        assertEquals("a1 a1 a2 a3 a3 a4 a5 a6 a7 b1 b2 b3", res.joinToString(" "))
    }

    @Test
    fun `identical lists`() {
        val arr1 = arrayOf("a1", "a2", "a3", "a4", "a5", "a6")
        val arr2 = arrayOf("a1", "a2", "a3", "a4", "a5", "a6")
        val res = Array(12) { "" }

        Merge2SortedCollections.merge(arr1, arr2, res)

        assertEquals("a1 a1 a2 a2 a3 a3 a4 a4 a5 a5 a6 a6", res.joinToString(" "))
    }

}