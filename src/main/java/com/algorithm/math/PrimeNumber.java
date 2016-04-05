package com.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhans on 2016/4/4.
 */
public class PrimeNumber {
    public static List<Integer> primeNumbers(int n){
        boolean[] table = new boolean[n + 1];
        //把3之后的奇数标记为true
        for (int i = 3; i < table.length; i += 2) {
            table[i] = true;
        }
        //n范围内的质数不会超过sqrt(n)个
        int len = (int) Math.sqrt(n);
        for (int i = 3; i <= len; i++) {
            if (table[i]){
                for (int j = i + i; j < n; j += i) {
                    table[j] = false;
                }
            }
        }
        ArrayList<Integer> primeList = new ArrayList<>();
        if (n > 1){
            primeList.add(2);
            for (int i = 0; i < table.length; i++) {
                if (table[i]){
                    primeList.add(i);
                }
            }
        }
        return primeList;
    }
}
