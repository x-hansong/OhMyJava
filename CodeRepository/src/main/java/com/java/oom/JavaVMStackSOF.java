package com.java.oom;

/**
 * Created by xhans on 2016/3/18.
 * VM Args : -Xss128k
 */
public class JavaVMStackSOF {
    private int stackLenth = 1;
    
    public void stackLeak(){
        stackLenth++;
        stackLeak();
    }
    
    public static void main(String[] args){
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e){
            System.out.println("stack length : " + oom.stackLenth);
            throw e;
        }
    }
}
