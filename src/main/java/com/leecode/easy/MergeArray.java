package com.leecode.easy;

/**
 * Created by xhans on 2016/2/16.
 */
public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //从尾部从大到小排序
        while (n > 0){
            if (m > 0 && nums1[m - 1] > nums2[n - 1]){
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
    }
}
