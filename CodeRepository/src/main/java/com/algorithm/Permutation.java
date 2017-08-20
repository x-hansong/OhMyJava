package com.algorithm;

/**
 * Created by xhans on 2016/3/4.
 */
public class Permutation {
    public void permutation(char[] str){
        if (str != null && str.length > 1){
            permutationWithDuplicate(str, 0);
        }
    }

    private void permutation(char[] str, int begin){
       if (begin == str.length - 1){
            print(str);
       } else {
            for (int i = begin; i < str.length; i++) {
                swap(str, i, begin);
                permutation(str, begin + 1);
                swap(str, i, begin);
            }
        }
    }

    private void swap(char[] str, int i, int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    private void print(char[] str){
         for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
        System.out.println();
    }

    //在[begin, end)的区间中是否存在与str[end]相等的字符
    private boolean isSwap(char[] str, int begin, int end){
        for (int i = begin; i < end; i++) {
            if (str[i] == str[end]){
                return false;
            }
        }
        return true;
    }

    private void permutationWithDuplicate(char[] str, int begin){
        if (begin == str.length - 1){
            print(str);
       } else {
            for (int i = begin; i < str.length; i++) {
                //跳过重复字符
                if (isSwap(str, begin, i)) {
                    //交换
                    swap(str, i, begin);
                    //递归下一部分
                    permutation(str, begin + 1);
                    //复原
                    swap(str, i, begin);
                }
            }
        }
    }
}
