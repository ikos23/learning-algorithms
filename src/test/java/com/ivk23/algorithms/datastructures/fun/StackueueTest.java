package com.ivk23.algorithms.datastructures.fun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackueueTest {

    @Test
    void usageAsStackTest() {
        final var stackQ = new Stackueue<Integer>();

        stackQ.push(1);
        stackQ.push(2);
        stackQ.push(3);

        assertEquals(3, stackQ.pop());
        assertEquals(2, stackQ.pop());
        assertEquals(1, stackQ.pop());
        assertTrue(stackQ.isEmpty());
    }

    @Test
    void usageAsQueueTest() {
        final var stackQ = new Stackueue<Integer>();

        stackQ.enqueue(1);
        stackQ.enqueue(2);
        stackQ.enqueue(3);

        assertEquals(1, stackQ.pop());
        assertEquals(2, stackQ.pop());
        assertEquals(3, stackQ.pop());
        assertTrue(stackQ.isEmpty());
    }

    @Test
    void mixModeUsageTest() {
        final var stackQ = new Stackueue<String>();

        stackQ.push("first");
        stackQ.push("second");
        stackQ.enqueue("third");
        stackQ.push("fourth");

        assertEquals("fourth", stackQ.pop());
        assertEquals("second", stackQ.pop());
        assertEquals("first", stackQ.pop());
        assertEquals("third", stackQ.pop());
        assertTrue(stackQ.isEmpty());
    }

}
