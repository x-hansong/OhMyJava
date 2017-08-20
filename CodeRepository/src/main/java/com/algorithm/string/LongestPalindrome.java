package com.algorithm.string;

import java.util.Scanner;

/**
 * Created by xhans on 2016/4/3.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            char[] cs = s.toCharArray();
            int maxLen = 1;
            for (int j = 1; j < cs.length; j++) {
                int left = j - 1;
                int right = j;
                while (left >= 0 && right < cs.length && cs[left] == cs[right]) {
                    if (right - left + 1 > maxLen) {
                        maxLen = right - left + 1;
                    }
                    left--;
                    right++;
                }

                left = j - 1;
                right = j + 1;
                while (left >= 0 && right < cs.length && cs[left] == cs[right]) {
                    if (right - left + 1 > maxLen) {
                        maxLen = right - left + 1;
                    }
                    left--;
                    right++;
                }

            }
            System.out.println(maxLen);
        }

    }
}
