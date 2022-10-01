package com.hansong;

import org.apache.commons.lang.RandomStringUtils;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by xhans on 2016/4/20.
 */
public class MethodHandleTest {

    static class ClassA{
        public void println(String s){
            System.out.println(s);
        }
    }
    public static void main(String[] args) throws Throwable {
        Object object = System.currentTimeMillis() % 2 == 0  ? System.out : new ClassA();
        getPrintlnMH(object).invokeExact("method handle");
        System.out.println(RandomStringUtils.randomAlphanumeric(32));
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", methodType).bindTo(receiver);
    }
}
