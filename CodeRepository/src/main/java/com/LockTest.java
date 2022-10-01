package com;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class LockTest {
    public static Integer m = 1;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //A线程
        new Thread(() -> {
            synchronized (m) {
                try {
                    m.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(m);
            }
        }).start();
        //B线程
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (m) {
                m.notify();
                System.out.println("唤醒A");
            }
        }).start();

    }
}