package com.test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @description 简单模拟LinkedList实现迭代器
 * @author: gaobh
 * @date: 2018/2/26 9:57
 * @version: v1.0
 */
public class MyLinkedList<T> implements Iterable<T> {

    /**
     * 私有嵌套类
     * Node类是私有的，故其数据成员是否可见无关紧要，MyLinkedList之外的类见不到Node类
     *
     * @param <T>
     */
    private static class Node<T> {
        public Node(T d, Node<T> p, Node<T> n) {
            data = d;
            prev = p;
            next = n;
        }

        public T data;
        public Node<T> prev;
        public Node<T> next;
    }

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, T x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    public T get(int idx) {
        return getNode(idx).data;
    }

    public T set(int idx, T newVal) {
        Node<T> p = getNode(idx);
        T oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public T remove(int idx) {
        return remove(getNode(idx));
    }

    private void addBefore(Node<T> p, T x) {
        Node<T> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    private T remove(Node<T> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        return p.data;
    }

    private Node<T> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    private Node<T> getNode(int idx, int lower, int upper) {
        Node<T> p;
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }
        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = beginMarker.next;
        private int expectedmodCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if (modCount != expectedmodCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedmodCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            expectedmodCount++;
            okToRemove = false;
        }
    }

    public boolean contains(T x) {
        Node<T> p = beginMarker.next;
        while (p != endMarker && p.data.equals(x)) {
            p = p.next;
        }
        return (p != endMarker);
    }

    private int theSize;
    /**
     * 自从构造以来对链表所做改变的次数
     */
    private int modCount = 0;
    private Node<T> beginMarker;
    private Node<T> endMarker;
}
