package com.algorithm;

import com.algorithm.sorting.QuickSort;
import org.junit.Test;

/**
 * Created by xhans on 2016/3/1.
 */
public class SortTest {
    @Test
    public void testQuickSort(){
        QuickSort<Integer> quickSort = new QuickSort<Integer>();


        quickSort.sort0(new Integer[]{1});
        quickSort.sort0(new Integer[]{1,2});
        quickSort.sort0(new Integer[]{1,2,0});
        quickSort.sort0(new Integer[]{1,2,0,5,2,1,4,6,3,0});
    }
}
