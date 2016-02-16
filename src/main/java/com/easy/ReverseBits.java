package com.easy;

/**
 * Created by xhans on 2016/2/16.
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev = rev << 1;
            rev = rev | (n >> i & 1);
        }
        return rev;
    }
}
