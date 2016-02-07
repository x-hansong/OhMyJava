package com.easy;

import java.util.Arrays;

/**
 * Created by xhans on 2016/2/7.
 */
//排序后遍历
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums){
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }
}
