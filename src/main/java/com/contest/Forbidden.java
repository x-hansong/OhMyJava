package com.contest;

import java.util.*;

/**
 * Created by xhans on 2016/4/6.
 */
public class Forbidden {
    public static void main(String[] args) {
        solveWithTrie();
    }


    public static void solveWithTrie() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String action = scanner.next();
            String ip = scanner.next();
            if (action.equals("allow")) {
                trie.insert(ip, (byte) 1);
            } else {
                trie.insert(ip, (byte) 2);
            }
        }

        for (int i = 0; i < m; i++) {
            String ip = scanner.next();
            if (trie.isAllow(ip)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    public static void solveWithRule() {
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
            for (NumRule rule : ruleList) {
                if (rule.isAllow && rule.isMatch(ip)) {
                    match = true;
                    System.out.println("YES");
                    break;
                } else if (rule.isMatch(ip)) {
                    match = true;
                    System.out.println("NO");
                    break;
                }
            }
            if (!match) {
                System.out.println("YES");
            }
        }
    }

    public static int toInt(String ip) {
        String[] nums = ip.split("\\.");
        int result = 0;
        int digit = 32;
        for (String num : nums) {
            int x = Integer.parseInt(num);
            digit -= 8;
            result |= (x << digit);
        }
        return result;
    }

    static class Trie {
        private int seq;
        private Node root = new Node((byte) 0);

        class Node {
            byte flag;//0代表普通节点，1代表允许规则终点，2代表禁止规则终点
            int seq;//规则顺序
            Node[] next = new Node[2];

            Node(byte flag) {
                this.flag = flag;
            }

        }

        public void insert(String ip, byte flag) {
            seq++;
            int mask = 32;
            int index = ip.indexOf('/');
            //检测是否有掩码
            if (index != -1) {
                mask = Integer.parseInt(ip.substring(index + 1));
            } else {
                index = ip.length();
            }
            //把ip地址转化为二进制形式
            String binary = toBinary(ip.substring(0, index));

            char[] binarys = binary.toCharArray();

            Node node = root;

            for (int i = 0; i < mask; i++) {
                int pos = binarys[i] - '0';
                if (node.next[pos] == null) {
                    node.next[pos] = new Node((byte) 0);
                }
                node = node.next[pos];
            }
            //后面的规则不能覆盖前面的
            if (node.flag == 0) {
                node.flag = flag;
            }
            if (node.seq == 0) {
                node.seq = seq;
            }
        }

        public boolean isAllow(String ip) {
            String binary = toBinary(ip);
            char[] binarys = binary.toCharArray();

            Node node = root;
            int seq = Integer.MAX_VALUE;
            boolean isAllow = true;
            int i = 0;
            int pos = 0;
            while (node != null) {
                //字典树最多会有33个节点，而ip的二进制最多只有32位
                //另一种避免判断的方法是在ip的二进制后面补一个0
                if (i < binarys.length) {
                    pos = binarys[i] - '0';
                }
                if (node.flag == 1) {
                    if (node.seq < seq) {
                        isAllow = true;
                        seq = node.seq;
                    }
                } else if (node.flag == 2) {
                    if (node.seq < seq) {
                        isAllow = false;
                        seq = node.seq;
                    }
                } else {
                    //flag=0说明是普通节点，直接跳过即可。
                }
                node = node.next[pos];
                i++;
            }

            return isAllow;
        }
    }

    //基于位运算比较，超时
    static class NumRule {
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

        public boolean isMatch(String ip) {
            int digit = 8;
            int[] testIps = toNums(ip);
            int i = 0;
            int tmpMask = mask;
            while (tmpMask >= digit) {
                if (ips[i] != testIps[i]) {
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
                if (ipsBit != testIpsBit) {
                    return false;
                }
            }
            return true;
        }

        public static int[] toNums(String ip) {
            String[] nums = ip.split("\\.");
            int[] ips = new int[4];
            for (int i = 0; i < nums.length; i++) {
                ips[i] = Integer.parseInt(nums[i]);
            }
            return ips;
        }

        public static NumRule create(String action, String ip) {
            NumRule rule = new NumRule();
            int index = ip.indexOf('/');
            if (index == -1) {
                rule.setMask(32);
                index = ip.length();
            } else {
                rule.setMask(Integer.parseInt(ip.substring(index + 1)));
            }

            rule.setIps(toNums(ip.substring(0, index)));
            if (action.equals("allow")) {
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

        public boolean isMatch(String ip) {
            String binaryIP = toBinary(ip);

            for (int i = 0; i < mask; i++) {
                char a = this.ip.charAt(i);
                char b = binaryIP.charAt(i);
                if (a != b) {
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

        public static StringRule create(String action, String ip) {
            StringRule rule = new StringRule();
            int index = ip.indexOf('/');
            if (index == -1) {
                rule.setMask(32);
                index = ip.length();
            } else {
                rule.setMask(Integer.parseInt(ip.substring(index + 1)));
            }

            rule.setIp(toBinary(ip.substring(0, index)));
            if (action.equals("allow")) {
                rule.setAllow(true);
            } else {
                rule.setAllow(false);
            }
            return rule;
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

    public static String toBinary(String ip) {
        String[] nums = ip.split("\\.");
        StringBuilder sb = new StringBuilder(35);
        for (String str : nums) {
            String binary = Integer.toBinaryString(Integer.parseInt(str));
            int left = 8 - binary.length();
            for (int i = 0; i < left; i++) {
                sb.append('0');
            }
            sb.append(binary);
        }
        return sb.toString();
    }
}
