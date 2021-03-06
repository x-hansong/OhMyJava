package com.leecode.easy;

/**
 * Created by xhans on 2016/2/15.
 */
public class TrailingZeros {
    public int trailingZeroes(int n) {
        //计算包含的2和5组成的pair的个数就可以了，一开始想错了，还算了包含的10的个数。
        //因为5的个数比2少，所以2和5组成的pair的个数由5的个数决定。
        //观察15! = 有3个5(来自其中的5, 10, 15)， 所以计算n/5就可以。
        //但是25! = 有6个5(有5个5来自其中的5, 10, 15, 20, 25， 另外还有1个5来自25=(5*5)的另外一个5），
        //所以除了计算n/5， 还要计算n/5/5, n/5/5/5, n/5/5/5/5, ..., n/5/5/5,,,/5直到商为0。
        int count_five = 0;
        while ( n > 0) {
            int k = n / 5;
            count_five += k;
            n = k;
        }
        return count_five;
    }
}
