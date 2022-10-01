package com.hansong.oom;

/**
 * Created by xhans on 2016/3/18.
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args){
//        List<String> list = new ArrayList<>();

//        int i = 0;
//        while (true){
//            jdk 6会把字符串存放在永久代中，jdk7以后则不是，所以在jdk7中运行不会出现错误。
//            list.add(String.valueOf(i++).intern());
//        }
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
        
    }
    
    
}
