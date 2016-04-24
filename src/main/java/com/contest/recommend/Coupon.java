package com.contest.recommend;

/**
 * Created by xhans on 2016/4/20.
 */
public interface Coupon {
    //获取减免的费用
    double getDiscount(Order order);
    double getThreshold();
}
