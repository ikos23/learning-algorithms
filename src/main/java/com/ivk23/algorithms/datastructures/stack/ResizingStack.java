package com.ivk23.algorithms.datastructures.stack;

import java.util.Iterator;

/**
 * Array-based stack supporting resizing implementation.
 */
public class ResizingStack<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;
    private int size;

    public ResizingStack(int initialCapacity) {
        if (initialCapacity < 0) {
            this.elements = new Object[DEFAULT_CAPACITY];
        } else {
            this.elements = new Object[initialCapacity];
        }
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.elements.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.elements.length;
    }

    public void push(T element) {
        if (size == this.elements.length) {
            resize(2 * size);
        }
        this.elements[size++] = element;
    }

    private void resize(int newSize) {
        final Object[] bigger = new Object[newSize];
        for (int i=0; i < size; i++) {
            bigger[i] = this.elements[i];
        }
        this.elements = bigger;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        final T element = (T) this.elements[--size];

        this.elements[size] = null; // make this memory eligible for GC

        if (size > DEFAULT_CAPACITY && size == this.elements.length / 4) {
            resize(this.elements.length / 2);
        }

        return element;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int size = ResizingStack.this.size;

            public boolean hasNext() {
                return this.size > 0;
            }

            @SuppressWarnings("unchecked")
            public T next() {
                return (T) ResizingStack.this.elements[--size];
            }

            public void remove() {}
        };
    }

}
