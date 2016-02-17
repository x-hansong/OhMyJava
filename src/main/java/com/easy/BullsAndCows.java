package com.easy;

/**
 * Created by xhans on 2016/2/17.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {

        int bulls = 0;
        int cows = 0;
        int[] secretCounts = new int[10];
        int[] guessCounts = new int[10];


        for (int i = 0; i < secret.length(); i++) {
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            int sInt = a - '0';
            int gInt = b - '0';
            if (a == b){
                bulls++;
            } else {
                secretCounts[sInt]++;
                guessCounts[gInt]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCounts[i], guessCounts[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
