package com.easy;

/**
 * Created by xhans on 2016/2/7.
 */
public class ValidAnagram {
    public boolean isAnngram(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] mask = new int[256];


        for (char c : cs){
            mask[c]++;
        }

        for (char c : ct){
            if (mask[c] > 0){
                mask[c]--;
            }else {
                return false;
            }
        }
        return true;
    }
}
