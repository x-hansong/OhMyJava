package com.leecode.easy;

/**
 * Created by xhans on 2016/2/21.
 */
public class ColumnTitle {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n != 0){
            char ch = (char) ((n - 1) % 26 + 'A');
            sb.append(ch);
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
