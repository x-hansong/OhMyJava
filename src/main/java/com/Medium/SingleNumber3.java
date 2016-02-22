package com.Medium;

/**
 * Created by xhans on 2016/2/22.
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        int[] results = new int[2];

        //获取最后一个1的位置，可以区别两个数
        int lowbit = result & (- result);

        for (int i = 0; i < nums.length; i++) {
            if ((lowbit & nums[i]) == 0) {
                results[0] ^= nums[i];
            } else {
                results[1] ^= nums[i];
            }
        }
        return results;
    }
}
