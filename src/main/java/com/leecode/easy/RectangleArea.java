package com.leecode.easy;

/**
 * Created by xhans on 2016/2/16.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C - A) * (D - B) + (G - E) * (H - F);
        //两种情况：一种是有重叠，一种是没有重叠
        if (A >= G || B >= H || C <= E || D <= F){
            return total;
        } else {
            //重叠部分的坐标
            int bottomLeftX = Math.max(A, E);
            int bottomLeftY = Math.max(B, F);

            int topRightX = Math.min(C, G);
            int topRightY = Math.min(D, H);

            return total - (topRightX - bottomLeftX) * (topRightY - bottomLeftY);
        }

    }
}
