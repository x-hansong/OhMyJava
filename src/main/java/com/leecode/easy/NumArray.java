package com.leecode.easy;

/**
 * Created by xhans on 2016/2/19.
 */
public class NumArray {
    private int[] sum;

    public NumArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return;
        }
        sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (sum == null){
            return 0;
        }
        if (i == 0){
            return sum[j];
        } else {
            return sum[j] - sum[i - 1];
        }

    }
}
