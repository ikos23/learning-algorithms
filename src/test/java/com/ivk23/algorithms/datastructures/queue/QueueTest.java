package com.ivk23.algorithms.datastructures.queue;

import com.ivk23.algorithms.datastructures.fun.Deque;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueueTest {

    @Test
    void isEmptyTest() {
        final var queue = new Queue<String>();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        int iter = 0;
        for (String s : queue) {
            iter++;
        }
        assertEquals(0, iter);
    }

    @Test
    void basicUsageTest() {
        final var queue = new Queue<String>();

        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");

        assertEquals("first is out", queue.dequeue() + " is out");
        assertEquals("second is out", queue.dequeue() + " is out");
        assertEquals("third is out", queue.dequeue() + " is out");
        assertTrue(queue.isEmpty());
    }

    @Test
    void iteratorTest() {
        final var queue = new Queue<String>();

        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");

        assertEquals(3, queue.size());

        final StringBuilder result = new StringBuilder();
        for (String s : queue) {
            result.append(s).append(" ");
        }

        assertEquals("first second third", result.toString().trim());
        assertEquals(3, queue.size());
    }

}
