package com.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by xhans on 2016/3/10.
 */
public class Reflection {
    static class MyClass {
        public int count;
        public MyClass(int start) {
            count = start;
        }
        public void increase(int step) {
            count = count + step;
        }
    }

    public static void main(String[] args){
         //反射例子
        try {
            Constructor constructor = MyClass.class.getConstructor(int.class);
            MyClass myClass1 = (MyClass) constructor.newInstance(10);
            Method method = MyClass.class.getMethod("increase", int.class);
            method.invoke(myClass1, 5);
            Field field = MyClass.class.getField("count");
            System.out.println("Reflect -> " + field.getInt(myClass1)); //获取域的值
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
