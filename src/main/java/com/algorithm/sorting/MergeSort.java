package com.algorithm.sorting;

/**
 * Created by xhans on 2016/3/3.
 */
public class MergeSort<T extends Comparable<? super T>> {

    private void merge(T[] src, T[] tmps, int leftPos, int rightPos, int rightEnd){
        int n = rightEnd - leftPos + 1;
        int tmpIndex = leftPos;
        int leftEnd = rightPos - 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (src[leftPos].compareTo(src[rightPos]) <= 0){
                tmps[tmpIndex++] = src[leftPos++];
            } else {
                tmps[tmpIndex++] = src[rightPos++];
            }
        }
        //移动剩余的部分
        while (leftPos <= leftEnd){
            tmps[tmpIndex++] = src[leftPos++];
        }

        while (rightPos <= rightEnd){
            tmps[tmpIndex++] = src[rightPos++];
        }
        //拷贝回原数组
        for (int i = 0; i < n; i++, rightEnd--) {
            src[rightEnd] = tmps[rightEnd];
        }
    }

    private void mergeSort(T[] src, T[] tmp, int left, int right){
        if (left < right){
            int mid = left + (right - left) / 2;
            mergeSort(src, tmp, left, mid);
            mergeSort(src, tmp, mid + 1, right);
            merge(src, tmp, left, mid + 1, right);
        }
    }

    public void mergeSort(T[] src){
        if (src != null && src.length > 1){
            T[] tmps = (T[]) new Comparable[src.length];
            mergeSort(src, tmps, 0, src.length - 1);
            for (int i = 0; i < src.length; i++) {
                System.out.print(src[i] + " ");
            }
            System.out.println();
        }
    }
}
