package com.easy;

import com.easy.myatoi.MyAtoi;
import com.easy.palindromenumber.PalindromeNumber;
import com.easy.reverseinteger.ReverseInteger;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xhans on 2016/1/25.
 */
public class EasyTest {

    private static Logger logger = LoggerFactory.getLogger(MyAtoi.class);
//    @Test
    public void testMyAtoi(){
        MyAtoi myAtoi = new MyAtoi();
        logger.debug(String.valueOf(myAtoi.myAtoi("   -15465fdf  ")));
        logger.debug(String.valueOf(myAtoi.myAtoi("")));
        logger.debug(String.valueOf(myAtoi.myAtoi("+-2")));
        logger.debug(String.valueOf(myAtoi.myAtoi("  -0012a42")));
        logger.debug(String.valueOf(myAtoi.myAtoi("-2147483648")));
        logger.debug(String.valueOf(myAtoi.myAtoi("2147483648")));
    }

//    @Test
    public void testReverseInteger(){
        ReverseInteger reverseInteger = new ReverseInteger();
        logger.debug(String.valueOf(reverseInteger.reverse(-1001)));
        logger.debug(String.valueOf(reverseInteger.reverse(1001)));
        logger.debug(String.valueOf(reverseInteger.reverse(1000000003)));
        logger.debug(String.valueOf(reverseInteger.reverse(-1000000003)));
    }

    @Test
    public void testPalindrome(){
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        logger.debug(String.valueOf(palindromeNumber.isPalindrome(-1001)));
        logger.debug(String.valueOf(palindromeNumber.isPalindrome(1001)));
        logger.debug(String.valueOf(palindromeNumber.isPalindrome(1024)));
        logger.debug(String.valueOf(palindromeNumber.isPalindrome(1024000003)));
    }
}
