package com.easy;

import com.easy.myatoi.MyAtoi;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xhans on 2016/1/25.
 */
public class MyAtoiTest {

    private static Logger logger = LoggerFactory.getLogger(MyAtoi.class);
    @Test
    public void testMyAtoi(){
        MyAtoi myAtoi = new MyAtoi();
        logger.debug(String.valueOf(myAtoi.myAtoi("   -15465fdf  ")));
        logger.debug(String.valueOf(myAtoi.myAtoi("")));
        logger.debug(String.valueOf(myAtoi.myAtoi("+-2")));
        logger.debug(String.valueOf(myAtoi.myAtoi("  -0012a42")));
        logger.debug(String.valueOf(myAtoi.myAtoi("-2147483648")));
        logger.debug(String.valueOf(myAtoi.myAtoi("2147483648")));
    }
}
