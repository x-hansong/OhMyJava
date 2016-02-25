package com.leecode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhans on 2016/2/21.
 */
public class SummaryRange {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> list = new ArrayList<String>();
        //j记录区间头部，i记录区间尾部
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i + 1 == nums.length || nums[i] + 1 != nums[i + 1]) {
                String str;
                if (i == j) {//说明区间不等于0
                    str = nums[j] + "";
                } else {
                    str = nums[j] + "->" + nums[i];
                }
                list.add(str);
                j = i + 1;//对齐i和j
            }
        }

        return list;
    }
}
