package com.easy;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by xhans on 2016/2/17.
 */
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Integer prePosOfS = map1.put(s.charAt(i), i);
            Integer prePosOfT = map2.put(t.charAt(i), i);
            //map的put方法返回之前的键值，如果没有键值返回null，因此prePosOfS有可能为null，不能直接比较
            if (!Objects.equals(prePosOfS, prePosOfT)){
                return false;
            }
        }
        return true;
   }
}
