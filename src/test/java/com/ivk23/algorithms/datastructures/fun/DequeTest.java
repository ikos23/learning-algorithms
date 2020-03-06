package com.ivk23.algorithms.datastructures.fun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DequeTest {

    @Test
    void isEmptyTest() {
        final var deque = new Deque<Double>();
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());

        int iter = 0;
        for (Double d : deque) {
            iter++;
        }
        assertEquals(0, iter);
    }

    @Test
    void usageTest() {
        final var deque = new Deque<Integer>();

        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushRight(3);
        deque.pushLeft(4);
        deque.pushRight(5);
        deque.pushRight(6);

        StringBuilder sb = new StringBuilder("");
        for(int i : deque) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
        assertEquals("4 2 1 3 5 6", sb.toString().trim());

        assertEquals(4, deque.popLeft());
        assertEquals(2, deque.popLeft());
        assertEquals(1, deque.popLeft());
        assertEquals(3, deque.popLeft());
        assertEquals(5, deque.popLeft());
        assertEquals(6, deque.popLeft());
        assertTrue(deque.isEmpty());
    }

    @Test
    void popRightTest() {
        final var deque = new Deque<Integer>();

        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushRight(3);

        assertEquals(3, deque.popRight());
        assertEquals(1, deque.popRight());
        assertEquals(2, deque.popRight());
        assertTrue(deque.isEmpty());
    }

}
