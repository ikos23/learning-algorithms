package com.ivk23.algorithms.datastructures.fun;


import java.util.Iterator;

/**
 * Linked list based implementation of Deque.
 * Deque - you can add/remove from both sides.
 */
public class Deque<E> implements Iterable<E> {

    private Node<E> left;
    private Node<E> right;
    private int size;

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void pushLeft(E element) {
        final var oldLeft = this.left;
        this.left = new Node<E>();
        this.left.element = element;

        if (isEmpty()) {
            this.right = this.left;
        } else {
            oldLeft.prev = this.left;
            this.left.next = oldLeft;
        }

        this.size++;
    }
    public void pushRight(E element) {
        final var oldRight = this.right;
        this.right = new Node<E>();
        this.right.element = element;

        if (isEmpty()) {
            this.left = this.right;
        } else {
            this.right.prev = oldRight;
            oldRight.next = this.right;
        }

        this.size++;
    }

    public E popLeft() {
        final var element = this.left.element;
        this.left = this.left.next;
        this.size--;
        return element;
    }
    public E popRight() {
        final var element = this.right.element;
        this.right = this.right.prev;
        this.size--;
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> cursor = Deque.this.left;

            @Override
            public boolean hasNext() {
                return this.cursor != null;
            }

            @Override
            public E next() {
                final var elem = this.cursor.element;
                this.cursor = this.cursor.next;
                return elem;
            }
        };
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
    }
}

