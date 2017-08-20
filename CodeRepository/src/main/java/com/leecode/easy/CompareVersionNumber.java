package com.leecode.easy;

/**
 * Created by xhans on 2016/1/28.
 */
public class CompareVersionNumber {
    public int compareVersion(String version1, String version2){

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int maxLen = v1.length > v2.length ? v1.length : v2.length;

        for (int i = 0; i < maxLen; i++){
            int a = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            int b = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            if (a > b){
                return 1;
            }else if (a < b){
                return -1;
            }
        }
        return 0;
    }
}
