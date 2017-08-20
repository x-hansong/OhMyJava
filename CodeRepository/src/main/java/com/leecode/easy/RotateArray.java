package com.leecode.easy;

/**
 * Created by xhans on 2016/2/21.
 */
public class RotateArray {
    //第一种解法：反转前半部分和后半部分，最后整个反转
    public void rotate(int[] nums, int k) {
        k = k % nums.length;//题目很坑爹，会出现k大于n的情况
        reverse(nums, 0, nums.length - k);
        reverse(nums, nums.length - k, nums.length);
        reverse(nums, 0, nums.length);
    }
    private void reverse(int[] nums, int start, int end){
        int mid = start + (end - start) / 2;
        for (int i = start; i < mid; i++) {
            int j = start + end - i - 1;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    //第二种解法：把数组看做环状
    public void rotate1(int[] nums, int k) {
        int index = 0;
        int next = 0;
        int cur = nums[0];
        int n = nums.length;

        //下面的取余操作：1.把数组看做环状，2.k有可能大于n，防止越界
        for (int i = 0; i < n; i++) {
            index = (index + k) % n;

            int temp = nums[index];
            nums[index] = cur;
            cur = temp;

            next = (next + k) % n;
            if (next == 0) {
                index = (index + 1) % n;
                cur = nums[index];
            }
        }

    }
}
