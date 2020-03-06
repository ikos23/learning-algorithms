package com.ivk23.algorithms.datastructures.stack;

import java.util.Iterator;

/**
 * Array-based stack implementation.
 */
public class FixedCapacityStack<T> implements Iterable<T> {

    private Object[] elements;
    private int size;

    public FixedCapacityStack(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be positive integer");
        }
        this.elements = new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.elements.length;
    }

    public void push(T element) {
        this.elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return (T) this.elements[--size];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int size = FixedCapacityStack.this.size;

            public boolean hasNext() {
                return this.size > 0;
            }

            @SuppressWarnings("unchecked")
            public T next() {
                return (T) FixedCapacityStack.this.elements[--size];
            }

            public void remove() {}
        };
    }
}
