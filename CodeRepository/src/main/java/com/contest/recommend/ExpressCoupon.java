package com.contest.recommend;

/**
 * Created by xhans on 2016/4/20.
 */
public class ExpressCoupon implements Coupon{

    private double threshold;

    public ExpressCoupon(double threshold) {
        this.threshold = threshold;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public double getDiscount(Order order) {
        return order.getExpressFee();
    }
}
