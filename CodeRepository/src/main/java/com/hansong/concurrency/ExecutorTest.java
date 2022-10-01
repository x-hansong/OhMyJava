package com.hansong.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by xhans on 2016/3/12.
 */
public class ExecutorTest {
    static class LiftOff implements Runnable{
        protected int countDown = 10;
        private static int taskCount = 0;
        private final int id = taskCount++;
        public LiftOff(){}
        public LiftOff(int countDown){
            this.countDown = countDown;
        }

        public String status(){
            return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
        }
        @Override
        public void run() {
            while (countDown-- > 0){
                System.out.print(status());
                Thread.yield();
            }

        }
    }

    static class SleepingTask extends LiftOff{
        public void run(){
            while (countDown-- > 0){
                System.out.print(status());
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    System.err.println("Interrupted");
                }
            }
        }
    }
    
    public static void main(String[] args){
        //CachedThreadPool 创建需要的线程数量，直到有线程可以重用为止
        ExecutorService exec = Executors.newCachedThreadPool();
        //FixedThreadPool 创建指定的线程数量，重用固定数量的线程
//        ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
//            exec.execute(new LiftOff());
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
