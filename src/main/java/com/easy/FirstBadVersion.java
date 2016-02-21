package com.easy;

/**
 * Created by xhans on 2016/2/21.
 */
public class FirstBadVersion {
    private boolean isBadVersion(int n){
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
