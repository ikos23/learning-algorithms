package com.ivk23.algorithms.datastructures.queue;

import java.util.Iterator;

/**
 * Linked list based implementation.
 */
public class Queue<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public void enqueue(T element) {
        final Node<T> oldLast = this.last;
        this.last = new Node<T>();
        this.last.element = element;

        if (isEmpty()) {
            this.first = this.last;
        } else {
            oldLast.next = this.last;
        }

        this.size++;
    }

    public T dequeue() {
        final Node<T> temp = this.first;
        this.first = this.first.next;
        this.size--;
        return temp.element;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> cursor = Queue.this.first;

            @Override
            public boolean hasNext() {
                return this.cursor != null;
            }

            @Override
            public T next() {
                T elem = cursor.element;
                cursor = cursor.next;
                return elem;
            }
        };
    }

    private static class Node<E> {
        E element;
        Node<E> next;
    }
}
