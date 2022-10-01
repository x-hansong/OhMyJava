package com.hansong;

import org.apache.commons.math3.distribution.BetaDistribution;

import java.util.Arrays;

public class MabProblem {
    public static void main(String[] args) {
        BetaDistribution betaDistribution = new BetaDistribution(1, 2);
        System.out.println(Arrays.toString(betaDistribution.sample(10)));
    }
}
