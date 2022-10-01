package com.hansong;

/**
 * Created by xhans on 2016/3/22.
 */
public class VolatileTest {
    public static volatile int race = 0;
    public static void increase(){
        race++;
//        System.out.println(Thread.currentThread());
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args){
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                       increase();
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(race);
    }
}
