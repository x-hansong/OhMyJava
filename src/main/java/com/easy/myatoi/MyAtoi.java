package com.easy.myatoi;

/**
 * Created by xhans on 2016/1/25.
 */
public class MyAtoi {

    public int myAtoi(String str) {
        boolean isPositive = true;
        str = str.trim();//去除前后空格
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuffer data = new StringBuffer();
        if (stringBuffer.length() == 0 || !isDigitsAndSign(stringBuffer.charAt(0))) {
            return 0;
        }
        //删除非数字字符
        boolean end = false;
        for (int i = 0; i < stringBuffer.length() && !end; i++) {
            char ch = stringBuffer.charAt(i);
            if (isDigitsAndSign(ch)) {
                data.append(ch);
            } else {
                end = true;
                break;
            }
        }

        //反转字符串
        data.reverse();
        long sum = 0;
        int length = data.length();
        for (int i = 0; i < length; i++) {
            char ch = data.charAt(i);
            if (Character.isDigit(ch)) {
                sum += parseToInt(ch) * Math.pow(10, i);
            } else if (length - i != 1) {//排除多个字符的情况
                return 0;
            } else if (ch == '-') {
                isPositive = false;
            }
        }

        long result = 0;
        if (isPositive) {
            result = sum;
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) result;
            }
        } else {
            result = -sum;
            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int) result;
            }
        }
    }

    private int parseToInt(char ch) {
        return ch - 48;
    }

    private boolean isDigitsAndSign(char ch) {
        if (Character.isDigit(ch) || ch == '-' || ch == '+')
            return true;
        return false;
    }

}
