package com.algorithm.sorting;

/**
 * Created by xhans on 2016/3/1.
 */
public class QuickSort<T extends Comparable<? super T>> {
    private int partition0(T[] a, int left, int right){
        int i = left - 1;
        int j = right + 1;
        T p = a[left];

        while (true){
            while (a[++i].compareTo(p) < 0) {}
            while (a[--j].compareTo(p) > 0) {}

            if (i < j){
                swap(a, i, j);
            } else {
                return j;
            }
        }
    }

    private void swap(T[] a, int i, int j){
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void sort0(T[] a, int left, int right){
        if (left < right){
            int mid = partition0(a, left, right);
            sort0(a, left, mid);
            sort0(a, mid + 1, right);
        }
    }

    public void sort0(T[] a){
        sort0(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
