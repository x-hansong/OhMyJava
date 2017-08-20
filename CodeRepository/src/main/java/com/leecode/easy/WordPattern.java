package com.leecode.easy;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by xhans on 2016/2/17.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()){
            return false;
        }
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        HashMap<Character, Integer> patternMap = new HashMap<Character, Integer>();

        for (int i = 0; i < pattern.length(); i++) {
            if (!Objects.equals(patternMap.put(pattern.charAt(i), i),
                                wordMap.put(words[i], i))){
                return false;
            }
        }
        return true;
    }
}
