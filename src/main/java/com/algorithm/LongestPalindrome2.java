package com.algorithm;

import java.util.Scanner;

/**
 * Created by xhans on 2016/4/10.
 * 找出字符串中的最长回文子串，可以通过删除其中的某些字符来得到回文串
 * 例如：acdacef 的最长回文子串为：aca, ada
 */
public class LongestPalindrome2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            char[] chars = str.toCharArray();
            int maxLen = 1;
            //从左往右扫描，从i开始的子串的最长回文串
            for (int i = 0; i < chars.length; i++) {
                int left = i;
                int right = chars.length - 1;
                int tmpLen = 0;
                while (left < right) {
                    if (chars[left] == chars[right]){
                        tmpLen++;
                        //左右指针同时往中间进1
                        left++;
                        right--;
                    } else {
                        right--;//跳过当前字符
                    }
                }
                //说明此时子串的长度为奇数
                if (left == right){
                    maxLen = Math.max(maxLen, 2 * tmpLen + 1);
                } else if (left - right == 1){//此时子串的长度为偶数
                    maxLen = Math.max(maxLen, 2 * tmpLen);
                }
            }
            //从右往左扫描，从i开始的子串的最长回文串
            for (int i = chars.length - 1; i >= 0; i--) {
                int right = i;
                int left = 0;
                int tmpLen = 0;
                while (left < right) {
                    if (chars[left] == chars[right]){
                        tmpLen++;
                        left++;
                        right--;
                    } else {
                        left++;
                    }
                }
                if (left == right){
                    maxLen = Math.max(maxLen, 2 * tmpLen + 1);
                } else if (left - right == 1){
                    maxLen = Math.max(maxLen, 2 * tmpLen);
                }
            }

            System.out.println(maxLen);
        }
    }
}
