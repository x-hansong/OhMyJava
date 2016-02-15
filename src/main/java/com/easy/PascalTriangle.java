package com.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhans on 2016/2/15.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (numRows != 0) {
            for (int i = 0; i < numRows; i++) {
                lists.add(new ArrayList<Integer>());
            }
            //初始化第一行
            lists.get(0).add(1);
            //利用规律，除了第一列和最后一列都为1，其他的：t[i, j] = t[i-1,j-1] + t[i-1, j]
            for (int i = 1; i < numRows; i++) {
                List<Integer> preList = lists.get(i - 1);
                List<Integer> curList = lists.get(i);
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || i == j) {
                        curList.add(1);
                    } else {
                        curList.add(preList.get(j - 1) + preList.get(j));
                    }
                }
            }
        }

        return lists;

    }
}
