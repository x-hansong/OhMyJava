package com.easy;

/**
 * Created by xhans on 2016/2/16.
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counts = 0;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 1){
                counts++;
            }
        }
        return counts;
    }
}
