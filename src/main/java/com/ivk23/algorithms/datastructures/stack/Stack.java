package com.ivk23.algorithms.datastructures.stack;

import java.util.Iterator;

/**
 * Linked list based implementation.
 */
public class Stack<T> implements Iterable<T> {

    private Node<T> first;
    private int size;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(T element) {
        final Node<T> oldFirst = this.first;

        this.first = new Node<T>();
        this.first.element = element;
        this.first.next = oldFirst;

        size++;
    }

    // unsafe :) to be used with !isEmpty()
    public T pop() {
        final T element = this.first.element;
        this.first = this.first.next;
        size--;
        return element;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> currentPosition = Stack.this.first;

            @Override
            public boolean hasNext() {
                return this.currentPosition != null;
            }

            @Override
            public T next() {
                final T element = currentPosition.element;
                currentPosition = currentPosition.next;
                return element;
            }
        };
    }

    private static class Node<E> {
        E element;
        Node<E> next;
    }
}
