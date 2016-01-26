package com.easy.reverseinteger;

/**
 * Created by xhans on 2016/1/25.
 */
public class ReverseInteger {

    public int reverse(int x){
        int rev = 0;

        while (x != 0){
            int remainder = x % 10;
            if ((x > 0 && ((Integer.MAX_VALUE - remainder) / 10) < rev) ||(x < 0 && ((Integer.MIN_VALUE - remainder) / 10 > rev))){
                return 0;
            }
            rev = rev * 10 + remainder;
            x /= 10;
        }
        return rev;
    }


}
