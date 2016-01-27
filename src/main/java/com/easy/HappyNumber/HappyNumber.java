package com.easy.happynumber;

/**
 * Created by xhans on 2016/1/26.
 */
public class HappyNumber {

    public boolean isHappy(int n){
        int[] array = new int[810];
        int sum = n;
        int temp = n;
        while (sum != 1){
            sum = 0;
            while (temp != 0){
                sum += (temp % 10) * (temp % 10);
                temp /= 10;
            }
            array[sum]++;
            if (array[sum] > 1){
                return false;
            }
            temp = sum;
        }
        return true;
    }

}
