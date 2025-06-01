package datastructures.lists;
import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T>{
    @Override
    public void addFirst(T t) {
        if(t == null)
            throw new NullPointerException();

        Node<T> node = new Node<>(t);
        if(head == null)
            head = tail = node;
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        ++size;
    }

    @Override
    public void addLast(T t) {
        if(t == null)
            throw new NullPointerException();

        Node<T> node = new Node<>(t);
        if(tail == null)
            tail = head = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        ++size;
    }

    @Override
    public T removeFirst() {
        if(head == null)
            throw new NoSuchElementException();

        T data = head.data;
        head = head.next;
        if(head == null)
            tail = null;
        else
            head.prev = null;

        --size;
        return data;
    }

    @Override
    public T removeLast() {
        if(tail == null)
            throw new NoSuchElementException();

        T data = tail.data;
        tail = tail.prev;
        if(tail == null)
            head = null;
        else
            tail.next = null;

        --size;
        return data;
    }

    @Override
    public T getFirst() {
        if(head == null)
            throw new NoSuchElementException();

        return head.data;
    }

    @Override
    public T getLast() {
        if(tail == null)
            throw new NoSuchElementException();

        return tail.data;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<T> current = head;
        for(int i = 0 ; i < index ; ++i)
            current = current.next;

        return current.data;
    }

    @Override
    public Object set(int index, Object element) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        Node<T> current = head;
        for(int i = 0 ; i < index ; i++)
            current = current.next;

        T old = current.data;
        current.data = (T) element;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object o) {
        addLast((T) o);
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for(Node<T> current = head ; current != null ; current = current.next)
            if(current.data.equals(o))
                return true;

        return false;
    }

    @Override
    public boolean remove(Object o) {
        for(Node<T> current = head ; current != null ; current = current.next)
            if(current.data.equals(o)) {
                if(current.prev != null)
                    current.prev.next = current.next;
                else
                    head = current.next;
            if(current.next != null)
                current.next.prev = current.prev;
            else
                tail = current.prev;

            --size;
            return true;
            }

        return false;
    }

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

}