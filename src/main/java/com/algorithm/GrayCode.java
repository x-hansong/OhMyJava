package com.algorithm;

import java.util.Arrays;

/**
 * Created by xhans on 2016/4/12.
 */
public class GrayCode {

    public static char[][] grayIter(int n){
        int m = 2 << (n - 1);
        char[][] code = new char[m][n];

        code[0] = new char[n];
        Arrays.fill(code[0], '0');

        int rightMost = n - 1;
        boolean changeRightMost = true;
        //第一步：改变最右边的位元值
        //第二步：改变右起第一个为1的位元的左边位元
        //一直迭代到结束
        for (int i = 1; i < m; i++) {
            //拷贝前一个格雷码
            code[i] = Arrays.copyOf(code[i - 1], n);
            if (changeRightMost){
                code[i][rightMost] = code[i][rightMost] == '0' ? '1' : '0';
                changeRightMost = false;
            } else {
                int rightMostOne = rightMost;

                for (int j = rightMost; j >= 0; j--) {
                    if (code[i][j] == '1'){
                        rightMostOne = j;
                        break;
                    }
                }
                int preRightMostOne = rightMostOne - 1;
                code[i][preRightMostOne] = code[i][preRightMostOne] == '0' ? '1' : '0';
                changeRightMost = true;
            }
        }
        return code;
    }

    public static String[] grayRecur(int n){
        String[] code = new String[2 << (n - 1)];

        if (n == 1){
            code[0] = "0";
            code[1] = "1";
            return code;
        }

        String[] last = grayRecur(n - 1);

        for (int i = 0; i < last.length; i++) {
            code[i] = "0" + last[i];
            code[code.length - i - 1] = "1" + last[i];
        }

        return code;
    }

}
