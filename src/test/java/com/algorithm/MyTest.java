package com.algorithm;

import com.algorithm.searching.BinarySearch;
import com.algorithm.sorting.MergeSort;
import com.algorithm.sorting.QuickSort;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xhans on 2016/3/1.
 */
public class MyTest {

    Logger logger = LoggerFactory.getLogger(MyTest.class);
//    @Test
    public void testQuickSort(){
        QuickSort<Integer> quickSort = new QuickSort<Integer>();


        quickSort.sort0(new Integer[]{1});
        quickSort.sort0(new Integer[]{1,2});
        quickSort.sort0(new Integer[]{1,2,0});
        quickSort.sort0(new Integer[]{1,2,0,5});
        quickSort.sort0(new Integer[]{1,2,3,4,5,6,7,8});
        quickSort.sort0(new Integer[]{1,2,0,5,2,1,4,6,3,0});
    }

//    @Test
    public void testBinaryTest(){
        BinarySearch<Integer> binarySearch = new BinarySearch<Integer>();

        logger.debug(String.valueOf(binarySearch.binarySearch(new Integer[]{0}, 0)));
        logger.debug(String.valueOf(binarySearch.binarySearch(new Integer[]{}, 0)));
        logger.debug(String.valueOf(binarySearch.binarySearch(new Integer[]{1,2,4,6,8}, 8)));
        logger.debug(String.valueOf(binarySearch.binarySearch(new Integer[]{1,1,3,4,4,4,4}, 4)));
    }

    @Test
    public void testMergeSort(){
        MergeSort<Integer> mergeSort = new MergeSort<Integer>();

        mergeSort.mergeSort(new Integer[]{0, 1});
        mergeSort.mergeSort(new Integer[]{1,3,5,3,1,1,0});
        mergeSort.mergeSort(new Integer[]{3,5,3,1,1,0});
    }

}
