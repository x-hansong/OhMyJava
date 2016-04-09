package com.hiho;

import java.util.Scanner;

/**
 * Created by xhans on 2016/4/5.
 */
public class Hiho1197 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            str = str.trim().toLowerCase();
            StringBuilder sb = new StringBuilder();
            char[] strs = str.toCharArray();
            boolean toUpper = true;
            for (int i = 0; i < strs.length; i++) {
                //跳过空格
                if (strs[i] == ' '){
                    while (strs[i] == ' '){
                        i++;
                    }
                    //, .与字母之间不能存在空格，其他情况补一个空格在后面
                    if (strs[i] != ',' && strs[i] != '.'){
                        sb.append(' ');
                    }
                }
                //.之后的首字母要大写
                if (strs[i] == '.'){
                    toUpper = true;
                }
                //保证,.之后有一个空格
                if (i > 0 && (strs[i - 1] == '.' || strs[i - 1] == ',')){
                    sb.append(' ');
                }
                if (toUpper && Character.isLetter(strs[i])){
                    strs[i] = Character.toUpperCase(strs[i]);
                    toUpper = false;
                }
                sb.append(strs[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
