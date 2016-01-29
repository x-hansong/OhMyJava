package com.easy;

/**
 * Created by xhans on 2016/1/28.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs){

        StringBuffer sb = new StringBuffer();
        if (strs.length == 0){
            return "";
        }
        String minStr = strs[0];
        for (String str:strs){
            if (str.length() < minStr.length()){
                minStr = str;
            }
        }

        boolean end = false;
        for (int i = 0; i < minStr.length(); i++){
            for (String str: strs){
                if (minStr.charAt(i) != str.charAt(i)){
                    end = true;
                    break;
                }
            }
            if (end){
                break;
            }else {
                sb.append(minStr.charAt(i));
            }
        }
        return sb.toString();
    }
}
