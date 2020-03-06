package com.ivk23.algorithms.datastructures.fun;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RandomBag<E> implements Iterable<E> {

    private Object[] elements;
    private int size;

    public RandomBag() {
        this.elements = new Object[10];
    }

    public RandomBag(int capacity) {
        this.elements = new Object[capacity];
    }

    public void add(E element) {
        if (this.size == this.elements.length) {
            // resize arr to bigger (twice bigger)
            this.elements = Arrays.copyOf(this.elements, 2 * this.elements.length);
        }
        this.elements[size++] = element;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        class RandIterator<E> implements Iterator<E> {

            private Object[] elements;
            private int pos;

            public RandIterator(Object[] elements) {
                final List<Object> list = Arrays.asList(elements);
                Collections.shuffle(list);
                this.elements = list.toArray();
            }

            @Override
            public boolean hasNext() {
                return this.pos < this.elements.length;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                return (E) elements[pos++];
            }
        }

        return new RandIterator<E>(Arrays.copyOf(RandomBag.this.elements, RandomBag.this.size));
    }
}
