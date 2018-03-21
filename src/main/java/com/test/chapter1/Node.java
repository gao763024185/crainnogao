package com.test.chapter1;


/**
 * @description
 * @author: gaobh
 * @date: 2018/2/27 14:00
 * @version: v1.0
 */
public class Node<T> {
    public Node(T d, Node<T> p, Node<T> n) {
        data = d;
        prev = p;
        next = n;
    }

    public T data;
    public Node<T> prev;
    public Node<T> next;
}
