package com.test;

/**
 * @description
 * @author: gaobh
 * @date: 2018/3/9 16:32
 * @version: v1.0
 */
public class CreateThread3 implements Runnable{

    public static void main(String[] args){
        Thread thread=new Thread(new CreateThread3());
        thread.start();
    }
    @Override
    public void run() {
        System.out.println("Oh,I am Runnable");
    }
}