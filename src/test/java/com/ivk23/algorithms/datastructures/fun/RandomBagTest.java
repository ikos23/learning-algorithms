package com.ivk23.algorithms.datastructures.fun;

import org.junit.jupiter.api.Test;

class RandomBagTest {

    /**
     * For me prints something like:
     *
     * 5 10 4 12 2 8 11 7 3 6 1 9
     * ----------------------------
     * 7 9 4 11 2 1 12 6 8 5 3 10
     * ----------------------------
     * 11 5 7 9 6 10 12 8 3 1 2 4
     * ----------------------------
     */
    @Test
    void iteratorTest() {
        var randomBag = new RandomBag<Integer>();

        for (int i = 1; i <= 12; i++) {
            randomBag.add(i);
        }

        for (int i : randomBag) {
            System.out.print(i + " ");
        }

        System.out.println("\n----------------------------");

        for (int i : randomBag) {
            System.out.print(i + " ");
        }

        System.out.println("\n----------------------------");

        for (int i : randomBag) {
            System.out.print(i + " ");
        }

        System.out.println("\n----------------------------");
    }

}
