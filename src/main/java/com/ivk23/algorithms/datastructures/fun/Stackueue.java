package com.ivk23.algorithms.datastructures.fun;

/**
 * Linked list based implementation of StackAndQueue data structure.
 */
public class Stackueue<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public void enqueue(E element) {
        final var oldLast = this.last;
        this.last = new Node<E>();
        this.last.element = element;

        if (isEmpty()) {
            this.first = this.last;
        } else {
            oldLast.next = this.last;
        }

        size++;
    }

    public void push(E element) {
        final var oldFirst = this.first;
        this.first = new Node<E>();
        this.first.element = element;

        if (isEmpty()) {
            this.last = this.first;
        } else {
            this.first.next = oldFirst;
        }

        size++;
    }

    public E pop() {
        final var elem = this.first.element;
        this.first = this.first.next;
        this.size--;
        return elem;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private static class Node<E> {
        E element;
        Node<E> next;
    }
}
