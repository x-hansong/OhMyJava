package com.contest.recommend;

import java.math.BigDecimal;

/**
 * Created by xhans on 2016/4/20.
 */
public class DoubleUtils {
    public static int compare(double a, double b){
        return new BigDecimal(a).compareTo(new BigDecimal(b));
    }
}
