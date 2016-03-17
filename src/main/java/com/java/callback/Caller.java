package com.java.callback;

/**
 * Created by xhans on 2016/3/16.
 */
public class Caller {
    private Incrementable callbackRefernce;

    public Caller(Incrementable cbh){
        callbackRefernce = cbh;
    }

    void go (){
        callbackRefernce.increment();
    }
}
