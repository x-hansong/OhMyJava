package com.leecode.easy;

/**
 * Created by xhans on 2016/2/7.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                count++;
            }else {
                nums[i - count] = nums[i];
            }
        }

        for (int i = 0; i < count; i++){
            nums[nums.length - i - 1] = 0;
        }
    }
}
