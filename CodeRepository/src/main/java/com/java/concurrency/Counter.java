package com.java.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Counter {

    private volatile int c = 0;

    public synchronized void incr() {
        c++;
    }

    public int getCounterNum() {
        return c;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Counter counter = new Counter();
        //线程A
        CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.incr();
            }
        });
        //线程B
        CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.incr();
            }
        });
        Thread.sleep(1000);
        System.out.println(counter.getCounterNum());
    }
}
