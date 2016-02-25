package com.leecode.easy;

/**
 * Created by xhans on 2016/1/25.
 */
public class MyAtoi {

    public int myAtoi(String str) {
        int max = Integer.MAX_VALUE;
        int length = str.length();
        int sign = 1;
        int result = 0;
        int i = 0;

        if (length > 0) {
            while (i < length && str.charAt(i) == ' ') {
                i++;
            }

            if (str.charAt(i) == '-') {
                sign = -1;
                max = Integer.MIN_VALUE;
            }

            //跳过符号
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                i++;
            }

            for (; i < length; i++) {
                char ch = str.charAt(i);
                if (!Character.isDigit(ch)) {
                    break;
                }

                //判断是否溢出
                if (((max - (parseToInt(ch) * sign)) / 10) * sign >= result) {
                    result = result * 10 + parseToInt(ch);
                } else {
                    return max;
                }
            }
        }
        return sign * result;

    }

    private int parseToInt(char ch) {
        return ch - '0';
    }
}

