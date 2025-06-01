package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    public CustomQueue() {
        list = new CustomLinkedList<>();
    }

    @Override
    public boolean add(Object t) {
        if(t == null)
            throw new NullPointerException();

        list.addLast((T) t);
        return true;
    }

    @Override
    public boolean offer(Object t) {
        if(t == null)
            return false;

        list.addLast((T) t);
        return false;
    }

    @Override
    public T remove() {
        if(list.isEmpty())
            throw new NoSuchElementException();
        return list.removeFirst();
    }

    @Override
    public T poll() {
        if(list.isEmpty())
            return null;

        return list.removeFirst();
    }

    @Override
    public T element() {
        if(list.isEmpty())
            throw new NoSuchElementException();

        return list.getFirst();
    }

    @Override
    public T peek() {
        if(list.isEmpty())
            return null;

        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

}