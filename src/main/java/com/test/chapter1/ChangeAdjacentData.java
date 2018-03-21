package com.test.chapter1;

import com.test.Test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 通过只调整链（而不是数据）来交换两个相邻的数据
 * @author: gaobh
 * @date: 2018/2/27 11:14
 * @version: v1.0
 */
public class ChangeAdjacentData {


    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList();
        Test1.makeList1(arrayList, 5);

    }

    public static void theArrayList(Node beforep) {
        Node p, afterp;
        p = beforep.next;
        afterp = p.next;
        beforep.next = afterp;
        afterp.next = p;
    }
}
