package com.hansong.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private AtomicInteger c = new AtomicInteger(0);

    public void incr() {
        c.incrementAndGet();
    }

    public int getCounterNum() {
        return c.get();
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