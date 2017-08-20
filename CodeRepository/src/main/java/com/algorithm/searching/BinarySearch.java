package com.algorithm.searching;

/**
 * Created by xhans on 2016/3/3.
 */
public class BinarySearch<T extends Comparable<? super T>> {
    public int binarySearch(T[] array, T key){
        if (array != null && array.length > 0){
            int left = 0;
            int right = array.length;
            while (left < right){
                int mid = left + (right - left) / 2;
                if (array[mid].compareTo(key) < 0){
                    left = mid + 1;
                } else if (array[mid].compareTo(key) > 0){
                    right = mid;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
