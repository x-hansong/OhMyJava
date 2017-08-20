package com.algorithm;

/**
 * Created by xhans on 2016/3/4.
 */
public class Queen {
    private boolean isValid(int[] array, int k){
        for (int i = 0; i < k; i++) {
            if (Math.abs(array[i] - array[k]) == Math.abs(i - k) //判断是否同一对角线
                    || array[i] == array[k]){ //判断是否同列
                return false;
            }
        }
        return true;
    }

    public int queens(int[] array, int k){
        if (k == array.length){
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                array[k] = i + 1;
                if (isValid(array, k)){
                    count += queens(array, k + 1);
                }
            }
            return count;
        }
    }
}
