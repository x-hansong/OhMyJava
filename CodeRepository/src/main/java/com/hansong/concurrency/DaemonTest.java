package com.hansong.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by xhans on 2016/3/12.
 */
public class DaemonTest {
    static class SimpleDaemons implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println(Thread.currentThread() + " " + this);
                }
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
