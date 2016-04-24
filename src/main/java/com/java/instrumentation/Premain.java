package com.java.instrumentation;

import java.lang.instrument.Instrumentation;

/**
 * Created by xhans on 2016/4/12.
 */
public class Premain {
    public static void premain(String agentArgs, Instrumentation instrumentation){
        instrumentation.addTransformer(new Transformer());
    }
}
