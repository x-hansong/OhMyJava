package com.leecode.medium;

/**
 * Created by xhans on 2016/2/22.
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;
            int sum = 0;
            //记录每一位1的个数
            for (int j = 0; j < nums.length; j++) {
                if ((bit & nums[j]) != 0){
                    sum++;
                }
            }
            if (sum % 3 == 1){
                result |= bit;
            }
        }

        return result;
    }
}
