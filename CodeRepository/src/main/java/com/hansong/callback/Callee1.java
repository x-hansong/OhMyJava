package com.hansong.callback;

/**
 * Created by xhans on 2016/3/16.
 */
public class Callee1 implements Incrementable {

    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println(i);

    }
}
