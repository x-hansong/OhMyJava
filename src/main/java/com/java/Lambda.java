package com.java;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xhans on 2016/4/19.
 */
public class Lambda {
    public static void main(String[] args){
        // 使用lambda表达式
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);
        System.out.println(costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get());
    }
}
