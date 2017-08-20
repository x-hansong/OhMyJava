package com.algorithm;

import java.util.Scanner;

/**
 * Created by xhans on 2016/3/25.
 */
public class BigMul {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        if (a.equals("0") || b.equals("0")){
            System.out.println(0);
            return;
        }

        char[] as = new StringBuilder(a).reverse().toString().toCharArray();
        char[] bs= new StringBuilder(b).reverse().toString().toCharArray();

        int[] r = new int[as.length + bs.length];
        for (int i = 0; i < bs.length; i++) {
            for (int j = 0; j < as.length; j++) {
                r[i + j] += (as[j] - '0') * (bs[i] - '0');
            }
        }
        for (int i = 0; i < r.length; i++) {
            if (r[i] > 9){
                r[i + 1] += r[i] % 10;
                r[i] = r[i] % 10;
            }
        }
        int i = r.length - 1;
        while (r[i--] == 0){
        }
        for (int j = i + 1; j >= 0; j--) {
            System.out.print(r[j]);
        }
    }
}
