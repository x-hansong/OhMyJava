package com.leecode.medium;

/**
 * Created by xhans on 2016/2/23.
 */
public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int rightProduct = 1;
        int leftProduct = 1;

        //错位累乘
        for (int i = 0; i < nums.length; i++) {
            output[i] = rightProduct;
            rightProduct *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0 ; i--) {
            output[i] *= leftProduct;
            leftProduct *= nums[i];
        }
        return output;
    }
}
