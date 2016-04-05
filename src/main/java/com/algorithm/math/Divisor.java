package com.algorithm.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhans on 2016/4/4.
 */
public class Divisor {
    public static Map<Integer, Integer> primeDivisorAndCounts(int x){
        List<Integer> primes = PrimeNumber.primeNumbers(x);
        Map<Integer, Integer> primeDivisors = new HashMap<>();
        //用素数去除x，统计个数
        for (Integer prime : primes){
            if (x < prime){
                break;
            } else {
                int counts = 0;
                while (x % prime == 0){
                    counts++;
                    x /= prime;
                }
                if (counts > 0){
                    primeDivisors.put(prime, counts);
                }
            }
        }
        return primeDivisors;
    }

    public static List<Integer> divisors(int x){
        Map<Integer, Integer> map = primeDivisorAndCounts(x);
        ArrayList<Integer> divisors = new ArrayList<>();
        divisors.add(1);
        for (Map.Entry entry : map.entrySet()){
            int primeDivisor = (int) entry.getKey();
            int counts = (int) entry.getValue();
            int base = 1;
            for (int i = 0; i < counts; i++) {
                base *= primeDivisor;
                int len = divisors.size();
                for (int j = 0; j < len; j++) {
                    divisors.add(divisors.get(j) * base);
                }
            }
        }
        return divisors;
    }
}
