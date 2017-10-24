package com.test;

/**
 * Created by 高保红 on 2017/9/3.
 */
public class ThreadLocalExample {
    public static class MyRunnable implements Runnable {
        private ThreadLocal threadLocal = new ThreadLocal();
        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));
            try {
                Thread.sleep(000);
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
        }
    }
    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);
        thread1.start();
        thread2.start();
    }
}

