package com.java;

/**
 * Created by xhans on 2016/3/6.
 */
public class ConcurrentControl {

    public static void main(String[] args){
        MyThread1 mt = new MyThread1();
        new Thread(mt, "票贩子A").start();
        new Thread(mt, "票贩子B").start();
        new Thread(mt, "票贩子C").start();
        new Thread(mt, "票贩子D").start();
        new Thread(mt, "票贩子E").start();
    }

    //同步代码块
    static class MyThread implements Runnable{

        private int ticket = 10;
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (this){
                    if (this.ticket > 0) {
                        try {
                            Thread.sleep(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()
                                + "卖票，ticket = " + this.ticket--);
                    }
                }
            }
        }
    }

    //同步方法
    static class MyThread1 implements Runnable{
        private int ticket = 10;
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                this.sale();
            }
        }

        private synchronized void sale(){
            if (this.ticket > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()
                        + "卖票，ticket = " + this.ticket--);
            }

        }
    }
    }
