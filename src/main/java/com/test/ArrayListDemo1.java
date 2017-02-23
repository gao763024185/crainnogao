package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 高保红 on 2017/2/17.
 */
public class ArrayListDemo1 {
    public static void main(String[] args) {
        //test1
//        System.out.println(test1());
//        System.out.println(test11());
        //test2
//        System.out.println(test2());
        //test3
        System.out.println(test3());
        //test4
        System.out.println("main输出:"+getMap().get("KEY").toString());
    }
    public static int test1() {
        int b = 20;
        try {
            System.out.println("try block");
            return b += 80;
        }
        catch (Exception e) {
            System.out.println("catch block");
        }
        finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
        }
        return b;
    }

    public static String test11() {
        try {
            System.out.println("try block");

            return test12();
        } finally {
            System.out.println("finally block");
        }
    }

    public static String test12() {
        System.out.println("return statement");

        return "after return";
    }

    public static int test2() {
        int b = 20;

        try {
            System.out.println("try block");

            return b += 80;
        } catch (Exception e) {

            System.out.println("catch block");
        } finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }

            return 200;
        }

        // return b;
    }

    public static int test3() {
        int b = 20;

        try {
            System.out.println("try block");

            return b += 80;
        } catch (Exception e) {

            System.out.println("catch block");
        } finally {

            System.out.println("finally block");

            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }

            b = 150;
        }

        return 2000;
    }
    public static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("KEY", "INIT");
        try {
            map.put("KEY", "TRY");
            return map;
        }
        catch (Exception e) {
            map.put("KEY", "CATCH");
        }
        finally {
            map.put("KEY", "FINALLY");
            map = null;
//            System.out.println(map.get("KEY"));
        }
        System.out.println(map.get("KEY"));   //上面return直接返回,所以这句话是不会输出的
        return map;
    }
}

