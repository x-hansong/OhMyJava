package com.hansong.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleSpinLock {

    private final AtomicInteger lock = new AtomicInteger(0);

    public void lock() {
        //用CAS操作忙等待
        while (!lock.compareAndSet(0, 1)) ;
    }

    public void unlock() {
        lock.set(0);
    }

    public static Integer m = 1;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleSpinLock lock = new SimpleSpinLock();
        //线程A
        CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 10000; i++) {
                lock.lock();
                m++;
                lock.unlock();
            }
        });
        //线程B
        CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 10000; i++) {
                lock.lock();
                m++;
                lock.unlock();
            }
        });
        Thread.sleep(1000);
        System.out.println(m);
    }
}
