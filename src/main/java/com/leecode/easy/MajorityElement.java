package com.leecode.easy;

/**
 * Created by xhans on 2016/2/7.
 */
public class MajorityElement {
    public int majorityElement(int [] nums){
        int candidate = 0;
        int count = 0;

        //题目中有major element 出现次数大于 n/2 的条件，说明count的值大于 n/2
        for (int num : nums){
            if (count == 0){
                candidate = num;
                count++;
            } else if (candidate == num){
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
