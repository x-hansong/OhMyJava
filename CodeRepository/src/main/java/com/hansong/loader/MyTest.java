package com.hansong.loader;

import java.lang.reflect.Method;

public class MyTest {

    public static void main(String[] args) throws Exception {
        //这里取AppClassLoader的父加载器也就是ExtClassLoader作为MyClassLoaderCustom的jdkClassLoader
        MyClassLoaderCustom myClassLoaderCustom = new MyClassLoaderCustom(Thread.currentThread().getContextClassLoader().getParent());
        Class testAClass = myClassLoaderCustom.loadClass("com.hansong.loader.TestA");
        Method mainMethod = testAClass.getDeclaredMethod("main", String[].class);
        mainMethod.invoke(null, new Object[]{args});
    }

    public static void parentFirst(String[] args) throws Exception {
        MyClassLoaderParentFirst myClassLoaderParentFirst = new MyClassLoaderParentFirst();
        Class testAClass = myClassLoaderParentFirst.findClass("com.java.loader.TestA");
        Object object = testAClass.newInstance();
        if (object instanceof TestA) {
            ((TestA) object).hello();
        } else {
            Method mainMethod = testAClass.getDeclaredMethod("main", String[].class);
            mainMethod.invoke(null, new Object[]{args});
        }
    }

    public static void custom(String[] args) throws Exception {
        MyClassLoaderCustom myClassLoaderCustom = new MyClassLoaderCustom(Thread.currentThread().getContextClassLoader().getParent());
        Class testAClass = myClassLoaderCustom.loadClass("com.hansong.loader.TestA");
        Method mainMethod = testAClass.getDeclaredMethod("main", String[].class);
        mainMethod.invoke(null, new Object[]{args});
    }
}
