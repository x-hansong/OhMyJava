package com.java.concurrency;

import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class FIFOMutex {

    private final AtomicInteger lock = new AtomicInteger(0);
    private final Queue<Thread> waiters = new ConcurrentLinkedDeque<>();

    public void lock() {
        Thread current = Thread.currentThread();
        waiters.add(current);

        //当前线程如果不是在队头就直接阻塞
        //如果当前线程在队头就尝试获取锁，如果获取不到也阻塞
        while (waiters.peek() != current ||
                !lock.compareAndSet(0, 1)) {
            LockSupport.park(this);
        }
        waiters.remove(); //拿到锁之后退出等待队列
    }

    public void unlock() {
        lock.set(0);
        LockSupport.unpark(waiters.peek()); //唤醒队头的线程去尝试获取锁
    }

    public static Integer m = 1;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FIFOMutex lock = new FIFOMutex();
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
