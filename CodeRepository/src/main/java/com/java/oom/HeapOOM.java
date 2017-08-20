package com.java.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhans on 2016/3/18.
 * VM args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject{}

    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }

}
