package com.test.chapter1;

import java.util.Iterator;
import java.util.List;

/**
 * @description
 * @author: gaobh
 * @date: 2018/2/27 11:07
 * @version: v1.0
 */
public class PrintLots {
    public void main(String[] args) {

    }

    public static <T> void printLots(List<T> L, List<Integer> P) {
        Iterator<T> iterL = L.iterator();
        Iterator<Integer> iterP = P.iterator();
        T itemL = null;
        Integer itemP = 0;
        int start = 0;
        while (iterL.hasNext() && iterP.hasNext()) {
            itemP = iterP.next();
            System.out.println("Looking for position " + itemP);
            while (start < itemP && iterL.hasNext()) {
                start++;
                itemL = iterL.next();
                System.out.println(itemL);
            }
        }
    }
}
