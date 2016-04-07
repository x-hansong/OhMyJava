package com.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xhans on 2016/4/6.
 */
public class Forbidden {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<NumRule> ruleList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String action = scanner.next();
            String ip = scanner.next();
            ruleList.add(NumRule.create(action, ip));
        }
        for (int i = 0; i < m; i++) {
            String ip = scanner.next();

            boolean match = false;
            for (NumRule rule : ruleList){
                if (rule.isAllow && rule.isMatch(ip)){
                    match = true;
                    System.out.println("YES");
                    break;
                } else if (rule.isMatch(ip)){
                    match = true;
                    System.out.println("NO");
                    break;
                }
            }
            if (!match){
                System.out.println("YES");
            }
        }
    }

    //基于位运算比较，超时
    static class NumRule{
        private int[] ips;
        private int mask;
        private boolean isAllow;

        public int[] getIps() {
            return ips;
        }

        public void setIps(int[] ips) {
            this.ips = ips;
        }

        public int getMask() {
            return mask;
        }

        public void setMask(int mask) {
            this.mask = mask;
        }

        public boolean isAllow() {
            return isAllow;
        }

        public void setAllow(boolean allow) {
            isAllow = allow;
        }
        public boolean isMatch(String ip){
            int digit = 8;
            int[] testIps = toNums(ip);
            int i = 0;
            int tmpMask = mask;
            while (tmpMask >= digit){
                if (ips[i] != testIps[i]){
                    return false;
                } else {
                    tmpMask -= digit;
                    i++;
                }
            }
            for (int j = 0; j < tmpMask; j++) {
                int shift = digit - j - 1;
                // 求出第shift+1位的值
                int ipsBit = (ips[i] >> shift) & 1;
                int testIpsBit = (testIps[i] >> shift) & 1;
                if (ipsBit != testIpsBit){
                    return false;
                }
            }
            return true;
        }

        public static int[] toNums(String ip){
            String[] nums = ip.split("\\.");
            int[] ips = new int[4];
            for (int i = 0; i < nums.length; i++) {
                ips[i] = Integer.parseInt(nums[i]);
            }
            return ips;
        }
        public static NumRule create(String action, String ip){
            NumRule rule = new NumRule();
            int index = ip.indexOf('/');
            if (index == -1){
                rule.setMask(32);
                index = ip.length();
            } else {
                rule.setMask(Integer.parseInt(ip.substring(index + 1)));
            }

            rule.setIps(toNums(ip.substring(0, index)));
            if (action.equals("allow")){
                rule.setAllow(true);
            } else {
                rule.setAllow(false);
            }
            return rule;
        }
    }

    //把数据转换为二进制字符串，进行比较。超时
    static class StringRule {
        private String ip;
        private int mask;
        private boolean isAllow;

        public boolean isMatch(String ip){
            String binaryIP = toBinary(ip);

            for (int i = 0; i < mask; i++) {
                char a = this.ip.charAt(i);
                char b = binaryIP.charAt(i);
                if (a != b){
                    return false;
                }
            }
            return true;
        }


        public int getMask() {
            return mask;
        }

        public void setMask(int mask) {
            this.mask = mask;
        }

        public static StringRule create(String action, String ip){
            StringRule rule = new StringRule();
            int index = ip.indexOf('/');
            if (index == -1){
                rule.setMask(32);
                index = ip.length();
            } else {
                rule.setMask(Integer.parseInt(ip.substring(index + 1)));
            }

            rule.setIp(toBinary(ip.substring(0, index)));
            if (action.equals("allow")){
                rule.setAllow(true);
            } else {
                rule.setAllow(false);
            }
            return rule;
        }

        public static String toBinary(String ip){
            String[] nums = ip.split("\\.");
            StringBuilder sb = new StringBuilder();
            for (String str : nums){
                String binary = Integer.toBinaryString(Integer.parseInt(str));
                int left = 8 - binary.length();
                for (int i = 0; i < left; i++) {
                    sb.append('0');
                }
                sb.append(binary);
            }
            return sb.toString();
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }


        public boolean isAllow() {
            return isAllow;
        }

        public void setAllow(boolean allow) {
            isAllow = allow;
        }
    }
}
