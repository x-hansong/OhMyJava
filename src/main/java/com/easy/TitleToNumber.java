package com.easy;

/**
 * Created by xhans on 2016/1/27.
 */
public class TitleToNumber {
    public int titleToNumber(String s){
        int ans = 0;
        //本质是一个26进制问题
        for (char ch: s.toCharArray()){
            ans = ans * 26 + ch - 'A' + 1;
        }
        return ans;
    }

}
