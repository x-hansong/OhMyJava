package com.hansong.callback;

/**
 * Created by xhans on 2016/3/16.
 */
public class MyIncrement {
    public void increment(){
        System.out.println("Other operation");
    }

    static void f(MyIncrement mi){
        mi.increment();
    }
}
