package com.hansong.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xhans on 2016/3/23.
 */
public class HashMapTest {
    static class MyOject{
        private int i;

        MyOject(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
    public static void main(String[] args){
        HashMap<MyOject, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(new MyOject(i), i);
        }
        for (Map.Entry<MyOject, Integer> entry : map.entrySet()){
            MyOject i = entry.getKey();
            i.setI(10);
        }
        System.out.println(map.get(new MyOject(10)));
    }
}
