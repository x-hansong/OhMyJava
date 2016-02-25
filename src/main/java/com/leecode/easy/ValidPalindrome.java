package com.leecode.easy;

/**
 * Created by xhans on 2016/1/30.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s){
        if (s.equals("")){
            return true;
        }

        char[] chs = s.toLowerCase().toCharArray();

        for (int l = 0, r = chs.length - 1; l < r; l++, r--){
            while ( l < r && !Character.isLetterOrDigit(chs[l])){
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(chs[r])){
                r--;
            }
            if (chs[l] != chs[r]){
                return false;
            }
        }
        return true;
    }
}
