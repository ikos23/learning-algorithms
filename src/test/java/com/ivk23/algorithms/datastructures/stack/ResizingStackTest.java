package com.ivk23.algorithms.datastructures.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResizingStackTest {

    @Test
    void usageTest() {
        final var stack = new ResizingStack<Integer>(3);

        assertEquals(3, stack.capacity());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertTrue(stack.isFull());

        // will be resized
        stack.push(4);

        assertEquals(6, stack.capacity());
    }

    @Test
    void multipleResizingTest() {
        final var stack = new ResizingStack<Integer>(5);

        assertEquals(5, stack.capacity());
        assertEquals(0, stack.size());

        for (int i = 100; i < 200; i++) {
            stack.push(i);
        }

        assertEquals(100, stack.size());
        assertEquals(160, stack.capacity());

        for (int i = 1; i <= 60; i++) {
            stack.pop();
        }

        assertEquals(40, stack.size());
        assertEquals(80, stack.capacity());
    }

}
