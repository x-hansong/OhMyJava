package com.easy;

/**
 * Created by xhans on 2016/1/27.
 */
public class AddBinary {
    public String addBinary(String a, String b){
        int carry = 0;
        StringBuffer sb = new StringBuffer();

        //基本思想是求和取整取余
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry > 0; i--, j--){
            int sum = 0;
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;
            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            sum += carry;

            carry = sum / 2;
            int remainder = sum % 2;
            sb.append(remainder);
        }

        return sb.reverse().toString();
    }
}
