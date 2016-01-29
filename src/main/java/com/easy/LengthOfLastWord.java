package com.easy;

/**
 * Created by xhans on 2016/1/29.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s){
        s = s.trim();
        //lastIndexOf 如果找不到对应的字符会返回-1
        return s.length() - 1 - s.lastIndexOf(" ");
    }
}
