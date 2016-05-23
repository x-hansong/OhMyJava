package com.contest.recommend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhans on 2016/4/20.
 */
public class CouponRecommend {
    private List<Coupon> coupons;
    private boolean isSort;

    public CouponRecommend() {
        coupons = new ArrayList<>();
        isSort = false;
    }

    public void addCoupon(Coupon coupon){
        coupons.add(coupon);
        isSort = false;
    }

    private void sortCoupon(){
//        Collections.sort(coupons, (o1, o2) -> DoubleUtils.compare(o1.getThreshold(), o2.getThreshold()));
    }

    public Coupon getCoupon(Order order){
        if (!isSort){
            sortCoupon();
        }
        Coupon recommendCoupon = new RedEnvelopeCoupon(0, 0);
        for (Coupon coupon : coupons){
            if (DoubleUtils.compare(order.getItemsFee(), coupon.getThreshold()) >= 0){
                if (DoubleUtils.compare(coupon.getDiscount(order), recommendCoupon.getDiscount(order)) > 0){
                    recommendCoupon = coupon;
                }
            } else {
                break;
            }
        }
        return recommendCoupon;
    }
}
