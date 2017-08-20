package com.leecode.easy;

/**
 * Created by xhans on 2016/3/2.
 */
public class FirstMin {
    public int firstMin(int[] nums){
        if (nums != null && nums.length > 0){
            int left = 0;
            int right = nums.length - 1;
            int min = left;
            while (nums[left] >= nums[right]){
                if (right - left == 1){
                    min = right;
                    break;
                }
                int mid = left + (right - left) / 2;

                //如果三个数相等的话，就只能顺序找了。
                if (nums[left] == nums[mid] && nums[right] == nums[mid]){
                    return minNum(nums, left, right);
                }
                if (nums[left] <= nums[mid]){
                    left = mid;
                } else if (nums[right] >= nums[mid]){
                    right = mid;
                }
            }
            return nums[min];
        } else {
            return -1;
        }
    }
    private int minNum(int[] nums, int left, int right){
        int min = nums[left];
        for (int i = 1; i <= right; i++) {
            if (nums[i] < min){
                min = nums[i];
            }
        }
        return min;
    }
}
