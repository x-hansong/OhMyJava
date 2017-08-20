package com.contest;

/**
 * Created by xhans on 2016/4/19.
 *
 */
public class Transform {
    public static String trans(String s, int n) {
        // write code here
        char[] chars = s.toCharArray();
        int begin = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == ' '){
                reverseSeq(chars, begin, i);
                begin = i + 1;
            } else {
                chars[i] = reverseCase(chars[i]);
            }
        }
        //反转最后一个单词
        reverseSeq(chars, begin, chars.length);
        //反转整个字符串
        reverseSeq(chars, 0, n);
        return new String(chars);
    }

    public static void reverseSeq(char[] chars, int begin, int end){
        for (int i = begin, j = end - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }

    public static char reverseCase(char ch){
        if (Character.isLowerCase(ch)){
            return Character.toUpperCase(ch);
        } else {
            return Character.toLowerCase(ch);
        }
    }
}
