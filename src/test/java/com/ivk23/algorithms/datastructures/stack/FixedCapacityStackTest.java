package com.ivk23.algorithms.datastructures.stack;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FixedCapacityStackTest {

    @Test
    void usageTest() {
        final var stack = new FixedCapacityStack<Integer>(5);

        int i = 1;
        while (!stack.isFull()) {
            stack.push(i++);
        }

        assertEquals(5, stack.size());
        assertTrue(stack.isFull());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        } // prints 5 4 3 2 1

        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    void instantiatingExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new FixedCapacityStack<Integer>(-1));
    }

    @Test
    void sizeTest() {
        final var stack = new FixedCapacityStack<String>(10);

        assertEquals(0, stack.size());

        stack.push("foo");
        stack.push("bar");

        assertEquals(2, stack.size());

        stack.pop();
        stack.pop();

        assertEquals(0, stack.size());
    }

    @Test
    void pushOverCapacityTest() {
        final var stack = new FixedCapacityStack<Integer>(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThrows(ArrayIndexOutOfBoundsException.class, () ->  stack.push(4));
    }

    @Test
    void popTest() {
        final var stack = new FixedCapacityStack<BigDecimal>(5);

        stack.push(BigDecimal.valueOf(1.23));
        stack.push(BigDecimal.valueOf(7.0));
        stack.push(BigDecimal.valueOf(22.01));

        assertEquals(BigDecimal.valueOf(22.01), stack.pop());
        assertEquals(BigDecimal.valueOf(7.0), stack.pop());
        assertEquals(BigDecimal.valueOf(1.23), stack.pop());

        assertEquals(0, stack.size());

        assertThrows(ArrayIndexOutOfBoundsException.class, stack::pop);
    }

    @Test
    void isEmptyTest() {
        final var stack = new FixedCapacityStack<Integer>(5);
        assertTrue(stack.isEmpty());

        stack.push(1000);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());

        int iter = 0;
        for (Integer i : stack) {
            iter++;
        }
        assertEquals(0, iter);
    }

    @Test
    void isFullTest() {
        final var stack = new FixedCapacityStack<Integer>(3);
        assertFalse(stack.isFull());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.isFull());
    }

    @Test
    void iteratorTest() {
        final var stack = new FixedCapacityStack<Integer>(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        int iteration = 0;
        final var expected = List.of(3,2,1);
        for(Integer i : stack) {
            assertEquals(expected.get(iteration++), i);
        }

        assertEquals(3, stack.size());
    }

}
