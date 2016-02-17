package com.easy;

import org.junit.Assert;
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

//    @Test
    public void testPlusOne(){
        PlusOne plusOne = new PlusOne();
        int[] res = plusOne.plusOne(new int[] {9,9,9});
        logger.debug(String.valueOf(res[0]));
    }

//    @Test
    public void testValidParentheses(){
        ValidParetheses validParetheses = new ValidParetheses();
        Assert.assertTrue(validParetheses.isValid("()(){}[]"));
        Assert.assertFalse(validParetheses.isValid(")((){}[]"));
        Assert.assertFalse(validParetheses.isValid("({)}"));
    }

//    @Test
    public void testCompareVersion(){
        CompareVersionNumber compareVersionNumber = new CompareVersionNumber();
        Assert.assertTrue(compareVersionNumber.compareVersion("1.0", "1.0") == 0);
        Assert.assertTrue(compareVersionNumber.compareVersion("1.0.1", "1.0") == 1);
        Assert.assertTrue(compareVersionNumber.compareVersion("1.0.1", "2.0") == -1);
    }

//    @Test
    public void testCountAndSay(){
        CountAndSay countAndSay = new CountAndSay();
        Assert.assertEquals(countAndSay.countAndSay(1), "1");
        Assert.assertEquals(countAndSay.countAndSay(2), "11");
        Assert.assertEquals(countAndSay.countAndSay(3), "21");
        Assert.assertEquals(countAndSay.countAndSay(4), "1211");
    }

//    @Test
    public void testLengthOfLastWord(){
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        Assert.assertTrue(lengthOfLastWord.lengthOfLastWord("  hello world  ") == 5);
        Assert.assertTrue(lengthOfLastWord.lengthOfLastWord("world") == 5);
    }

//    @Test
    public void testValidPalindrome(){
        ValidPalindrome validPalindrome = new ValidPalindrome();
        Assert.assertTrue(validPalindrome.isPalindrome(""));
        Assert.assertTrue(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(validPalindrome.isPalindrome("race a car"));
        Assert.assertFalse(validPalindrome.isPalindrome("0P"));
    }

//    @Test
    public void testMajorityElement(){

        MajorityElement majorityElement = new MajorityElement();
        Assert.assertEquals(3,majorityElement.majorityElement(new int[] {3,3,2,2,3,3,4,4}));
        Assert.assertEquals(3,majorityElement.majorityElement(new int[] {3,3,2,3,2,4,4,3,3}));
    }

//    @Test
    public void testMergeSortedLists(){
        MergeSortedList mergeSortedList = new MergeSortedList();


    }

//    @Test
    public void testRectangleArea(){
        RectangleArea rectangleArea = new RectangleArea();

        Assert.assertEquals(16, rectangleArea.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }

    @Test
    public void testContainsDuplicate2(){
        ContainsDuplicate2 c = new ContainsDuplicate2();

        Assert.assertTrue(c.containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));
    }
}
