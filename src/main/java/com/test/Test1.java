package com.test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

/**
 * @description
 * @author: gaobh
 * @date: 2018/2/23 10:49
 * @version: v1.0
 */
public class Test1 {
    public static void main(String[] args) {
        int N = 50000;
        List<Integer> list1 = new ArrayList<>();

        makeList1(list1, N);
//        makeList2(list1, N);
//        long startTimeArr = System.currentTimeMillis();
//        sum(list1, N);
//        long endTimeArr = System.currentTimeMillis();
//        System.out.println("ArrayList程序运行时间：" + (endTimeArr - startTimeArr) + "ms");

        List<Integer> list2 = new LinkedList<>();

        makeList1(list2, N);
//        makeList2(list2, N);
//        long startTimeLink = System.currentTimeMillis();
//        sum(list2, N);
//        long endTimeLink = System.currentTimeMillis();
//        System.out.println("LinkedList程序运行时间：" + (endTimeLink - startTimeLink) + "ms");

        long startTimeArr = System.currentTimeMillis();
//        getOddFromList(list1);
        removeEventsVer3(list1);
        long endTimeArr = System.currentTimeMillis();
        System.out.println("ArrayList程序运行时间：" + (endTimeArr - startTimeArr) + "ms");

        long startTimeLink = System.currentTimeMillis();
//        getOddFromList(list2);
        removeEventsVer3(list2);
        long endTimeLink = System.currentTimeMillis();
        System.out.println("LinkedList程序运行时间：" + (endTimeLink - startTimeLink) + "ms");
    }

    /**
     * list 尾部添加数据
     *
     * @param lst
     * @param N
     */
    public static void makeList1(List<Integer> lst, int N) {
        lst.clear();
        for (int i = 0; i < N; i++) {
            lst.add(i);
        }
        printList(lst);
    }

    /**
     * list 首部添加数据
     *
     * @param lst
     * @param N
     */
    public static void makeList2(List<Integer> lst, int N) {
        lst.clear();
        for (int i = 0; i < N; i++) {
            lst.add(0, i);
        }
    }

    /**
     * 计算list中的数的和
     *
     * @param lst
     * @param N
     * @return
     */
    public static int sum(List<Integer> lst, int N) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += lst.get(i);
        }
        System.out.println("total：" + total);
        return total;
    }


    /**
     * 删除表中的偶数
     *
     * 对于ArrayList和LinkedList都是要花费二次时间的
     * @param lst
     */
    public static void getOddFromList(List<Integer> lst) {
        System.out.println("打印list：");
        int i = 0;
        while (i < lst.size()) {
            if (lst.get(i) % 2 == 0) {
                lst.remove(i);
            } else {
                i++;
            }
        }
        printList(lst);
    }


    /**
     * 删除表中的偶数
     * 对于ArrayList是要花费二次时间的;LinkedList只花费常数时间
     * @param lst
     */
    public static void removeEventsVer3(List<Integer> lst) {
        Iterator<Integer> itr = lst.iterator();
        while (itr.hasNext()) {
            if (itr.next() % 2 == 0) {
                itr.remove();
            }
        }
        printList(lst);
    }

    /**
     * 打印list
     * @param lst
     */
    public static void printList(List<Integer> lst){
        Iterator<Integer> iter = lst.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + "##");
        }
    }
}
