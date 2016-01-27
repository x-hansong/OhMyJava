package com.easy;

import com.easy.addbinary.AddBinary;
import com.easy.happynumber.HappyNumber;
import com.easy.myatoi.MyAtoi;
import com.easy.palindromenumber.PalindromeNumber;
import com.easy.plusone.PlusOne;
import com.easy.reverseinteger.ReverseInteger;
import com.easy.titletonumber.TitleToNumber;
import com.easy.uglynumber.UglyNumber;
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

//    @Test
    public void testPalindrome(){
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        logger.debug(String.valueOf(palindromeNumber.isPalindrome(-1001)));
        logger.debug(String.valueOf(palindromeNumber.isPalindrome(1001)));
        logger.debug(String.valueOf(palindromeNumber.isPalindrome(1024)));
        logger.debug(String.valueOf(palindromeNumber.isPalindrome(1024000003)));
    }

//    @Test
    public void testHappyNumber(){
        HappyNumber happyNumber = new HappyNumber();
        logger.debug(String.valueOf(happyNumber.isHappy(19)));
        logger.debug(String.valueOf(happyNumber.isHappy(9)));
        logger.debug(String.valueOf(happyNumber.isHappy(199)));
    }

//    @Test
    public void testAddBinary(){
        AddBinary addBinary = new AddBinary();
        logger.debug(addBinary.addBinary("1111", "1111"));
        logger.debug(addBinary.addBinary("11100111", "110101"));
    }

//    @Test
    public  void testTitleToNumber(){
        TitleToNumber titleToNumber = new TitleToNumber();
        logger.debug(String.valueOf(titleToNumber.titleToNumber("AB")));
    }

//    @Test
    public void testUglyNumber(){
        UglyNumber uglyNumber = new UglyNumber();
        logger.debug(String.valueOf(uglyNumber.isUgly(19)));
        logger.debug(String.valueOf(uglyNumber.isUgly(9)));
    }

    @Test
    public void testPlusOne(){
        PlusOne plusOne = new PlusOne();
        int[] res = plusOne.plusOne(new int[] {9,9,9});
        logger.debug(String.valueOf(res[0]));
    }

}
