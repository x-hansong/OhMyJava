package com.easy;

/**
 * Created by xhans on 2016/1/29.
 */
public class CountAndSay {
    public String countAndSay(int n){
        String res = "1";

        while (--n > 0){
            StringBuffer sb = new StringBuffer();
            char[] prev = res.toCharArray();
            for (int i = 0; i < prev.length; i++){
                int count = 1;
                while (i + 1 < prev.length && prev[i] == prev[i + 1]){
                    count++;
                    i++;
                }
                sb.append(count).append(prev[i]);
            }
            res = sb.toString();
        }
        return res;
   }
}
