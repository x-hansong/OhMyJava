package com.hiho;

import java.util.*;

/**
 * Created by xhans on 2016/4/4.
 */
public class Hiho1284 {
    static List<Integer> primes = primeNumbers(1000000);
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        Map<Integer, Integer> nmap = primeDivisorAndCounts(n);
        Map<Integer, Integer> mmap = primeDivisorAndCounts(m);

        int sameCount = 1;

        for (Map.Entry<Integer, Integer> entry : nmap.entrySet()){
            int divisor = entry.getKey();
            int counts = 0;
            if (mmap.containsKey(divisor)){
                int nc = entry.getValue();
                int mc = mmap.get(divisor);
                counts = nc < mc ? nc : mc;
            }
            sameCount *= counts + 1;
        }

        int nDiviorsCount = 1;
        for (Map.Entry<Integer, Integer> entry: nmap.entrySet()){
            nDiviorsCount *= entry.getValue() + 1;
        }
        int mDiviorsCount = 1;
        for (Map.Entry<Integer, Integer> entry: mmap.entrySet()){
            mDiviorsCount *= entry.getValue() + 1;
        }
        
        int maxCount = nDiviorsCount * mDiviorsCount;
        
        int maxDivisor = gcd(maxCount, sameCount);
        
        System.out.println(maxCount / maxDivisor + " " + sameCount / maxDivisor);


    }
    public static Map<Integer, Integer> primeDivisorAndCounts(long x){
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
    public static int gcd(int a, int b){
        while (b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
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
