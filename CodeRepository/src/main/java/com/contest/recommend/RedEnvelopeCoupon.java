package com.contest.recommend;

/**
 * Created by xhans on 2016/4/20.
 */
public class RedEnvelopeCoupon implements Coupon{

    private double threshold;
    private double discount;

    public RedEnvelopeCoupon(double threshold, double discount) {
        this.threshold = threshold;
        this.discount = discount;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double getDiscount(Order order) {
        return discount;
    }
}
