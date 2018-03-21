package com.test;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @description 简单模拟ArrayList实现迭代器
 * @author: gaobh
 * @date: 2018/2/23 14:45
 * @version: v1.0
 */
public class MyArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * list大小
     */
    private int theSize;
    /**
     * 数组
     */
    private T[] theItems;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[index];
    }

    public T set(int index, T newVal) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = theItems[index];
        theItems[index] = newVal;
        return old;
    }

    /**
     * list容量的扩充
     *
     * @param newCapacity
     */
    public void ensureCapacity(int newCapacity) {
        //收缩基础数组
        if (newCapacity < theSize) {
            return;
        }
        //原始数组的引用
        T[] old = theItems;
        //新数组分配内存 创建一个泛型类型限界的数组 使用一个数组进行类型转换
        theItems = (T[]) new Object[newCapacity];
        //将原始数组拷贝到新数组中
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    /**
     * 添加到表的末端
     *
     * @param x
     * @return
     */
    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    /**
     * 添加到指定位置 代价昂贵
     *
     * @param index
     * @param x
     */
    public void add(int index, T x) {
        //容量不足扩充容量为原来的两倍
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        //增加元素后，其后元素向后移动一个单元
        for (int i = theSize; i > index; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[index] = x;
        theSize++;
    }

    /**
     * 删除指定位置元素
     */
    public T remove(int index) {
        T removedItem = theItems[index];
        //删除元素后，其后元素向前移动一个单元
        for (int i = index; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removedItem;
    }

    /**
     * 迭代器
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator4();
    }

    /**
     * 顶级类：迭代器版本1 不能使用
     * 原因：theItems和size()不是ArrayListIterator类的一部分
     */
    class ArrayListIterator1 implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            //此处毫无意义
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

    /**
     * 顶级类：迭代器版本2 几乎能够使用
     * 原因：无法使用theItems是私有的，内部类无法使用
     */
    class ArrayListIterator2<T> implements Iterator<T> {
        private int current = 0;
        private MyArrayList<T> theList;

        /**
         * 让迭代器来存储ArrayList的引用来解决在迭代器中没有数组的问题
         * 作为第二个数据域，通过ArrayListIterator的一个新的单参数构造器而被初始化
         *
         * @param list
         */
        public ArrayListIterator2(MyArrayList<T> list) {
            theList = list;
        }

        @Override
        public boolean hasNext() {
            return current < theList.size();
        }

        /**
         * theItems是MyArrayList中的私有域，
         * 而ArrayListIterator是一个不同的类，因此在next方法中访问theItems是非法的
         * 修正：改变theItems在MyArrayList中的可见性（即改成public，但违法了面向编程的基本原则，数据尽可能的隐蔽）
         *
         * @return
         */
        @Override
        public T next() {
            return theList.theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

    /**
     * 嵌套类（必须用static修饰）：迭代器版本3 能够运行
     * 可以被外部类MyArrayList访问，其他不可访问
     * 嵌套类被认为是MyArrayList的一部分
     */
    private static class ArrayListIterator3<T> implements Iterator<T> {

        private int current = 0;
        private MyArrayList<T> theList;

        public ArrayListIterator3(MyArrayList<T> list) {
            theList = list;
        }

        @Override
        public boolean hasNext() {
            return current < theList.size();
        }

        @Override
        public T next() {
            return theList.theItems[current++];
        }

        @Override
        public void remove() {
//            MyArrayList.this.remove(--current);
        }
    }

    /**
     * 内部类：迭代器版本4 能够使用
     * 同于版本1 区别在于 1是顶级类 4 是内部类
     */
    private class ArrayListIterator4 implements Iterator<T> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
