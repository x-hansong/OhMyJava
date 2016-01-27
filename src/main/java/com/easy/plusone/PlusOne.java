package com.easy.plusone;

/**
 * Created by xhans on 2016/1/27.
 */
public class PlusOne {
    public int[] plusOne(int [] digits){
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--){
            int s = digits[i] + carry;
            carry = s / 10;
            digits[i] = s % 10;
            if (carry == 0){
                break;
            }
        }

        if (carry == 1){
            int[] bigdigits = new int[digits.length + 1];
            System.arraycopy(bigdigits, 1, digits, 0, digits.length);
            bigdigits[0] = carry;
            return bigdigits;
        }
        return digits;
    }
}
