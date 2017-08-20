package com.algorithm.math;

/**
 * Created by xhans on 2016/4/4.
 */
public class GCD {
    public static int gcd(int a, int b){
        while (b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
