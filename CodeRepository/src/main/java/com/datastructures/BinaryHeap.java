package com.datastructures;

import java.util.NoSuchElementException;

/**
 * Created by xhans on 2016/2/29.
 */
public class BinaryHeap<T extends Comparable<? super T>>{
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int currentSize;

    public BinaryHeap(){
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity){
        currentSize = 0;
        array = (T[]) new Comparable[capacity + 1];
    }

    public BinaryHeap(T[] items){
        currentSize = items.length;
        array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (T item :
                items) {
            array[i++] = item;
        }
    }

    private void buildHeap(){
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }

    public void insert(T x){
        if (currentSize == array.length - 1){
            enlargeArray(array.length * 2 + 1);
        }

        int hole = ++currentSize;
        //percolate up
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2){
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }


    public boolean isEmpty(){
        return currentSize == 0;
    }

    public T findMin(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return array[1];
    }

    public T deleteMin(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        T minItem = findMin();
        //把最后一位放到最前，然后进行下移操作。
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    public void makeEmpty(){
        currentSize = 0;
    }

    private void enlargeArray(int newSize){
        T[] old = array;
        array = (T[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++) {
            array[i] = old[i];
        }
    }
    private void percolateDown(int hole){
        int child;
        T tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child){
            //child 指向左孩子，child+1指向右孩子
            child = hole * 2;
            //选取左右孩子中较小的一个
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0){
                child++;
            }
            //如果孩子的值小于tmp，上移孩子
            if (array[child].compareTo(tmp) < 0){
                array[hole] = array[child];
            } else {
                break;
            }
        }
        //把tmp放到合适的位置
        array[hole] = tmp;
    }


}
