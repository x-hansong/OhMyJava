package com.leecode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by xhans on 2016/2/22.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }
    public int singleNumber1(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }
    public int singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        Object[] array = set.toArray();
        return (Integer)array[0];
    }
}
