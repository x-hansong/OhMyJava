package com.leecode.easy;

/**
 * Created by xhans on 2016/1/26.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x){
        if (x < 0){
            return false;
        }
        int div = 1;
        //获取数字的长度-1
        while (x / div >= 10){
            div *= 10;
        }
        while (x != 0){
            int l = x / div;
            int r = x % 10;
            if (r != l){
                return false;
            }
            //去头去尾,顺序很重要，先取余，再整除。思考1001的例子。
            x = (x % div) / 10;
            //数字长度减2
            div /= 100;
        }

        return true;
    }
}
