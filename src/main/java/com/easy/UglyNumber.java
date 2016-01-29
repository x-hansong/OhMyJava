package com.easy;

/**
 * Created by xhans on 2016/1/27.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num <= 0){
            return false;
        }
        int[] div = {2, 3, 5};
        for (int n : div) {
            while (num % n == 0) {
                num /= n;
            }
        }
        return num == 1;
    }

}
