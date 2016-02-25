package com.leecode.easy;

/**
 * Created by xhans on 2016/2/19.
 */
public class MyStrStr {
    //基于next数组
    public int KMP(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        char[] t = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int[] next = getPartialMatchTable(needle);

        int tIndex = 0;
        int pIndex = 0;

        while (tIndex + pIndex < t.length){
            if (p[pIndex] == t[tIndex + pIndex]){
                //如果匹配指针已经到达模式串的最后一个元素
                if (pIndex == p.length - 1){
                    return tIndex;
                } else {
                    pIndex++;
                }
            } else {
                if (next[pIndex] > -1){
                    tIndex = tIndex + pIndex - next[pIndex];
                    pIndex = next[pIndex];
               } else {
                    pIndex = 0;
                    tIndex++;
                }
            }
        }
        return -1;
    }

    private int[] getPartialMatchTable(String ps){
        char[] p = ps.toCharArray();
        int[] table = new int[p.length];

        int pos = 2;
        int cnd = 0;

        table[0] = -1;
        if (p.length > 1){
            table[1] = 0;
        }

        while (pos < p.length){
            //如果当前字符的前一个字符匹配前面的短前缀
            if (p[pos - 1] == p[cnd]){
                table[pos] = cnd + 1;
                cnd++;
                pos++;
            } else if (cnd > 0){//如果不匹配，就让候选下标退到前面
                cnd = table[cnd];
            } else {//如果已经退到-1时候，就让它等于0
                table[pos] = 0;
                pos++;
            }
        }
        return table;
    }

    private int[][] getFail(String ps){
        char[] p = ps.toCharArray();
        int MAX_CHAR = 256;

        int[][] dfa = new int[MAX_CHAR][p.length];

        //绘制状态转移表
        dfa[p[0]][0] = 1;
        for (int i = 1, preState = 0; i < p.length; i++) {
            //拷贝前一个状态的值
            for (int j = 0; j < MAX_CHAR; j++) {
                dfa[j][i] = dfa[j][preState];
            }
            dfa[p[i]][i] = i + 1;
            //记录前一个状态
            preState = dfa[p[i]][preState];
        }
        return dfa;
    }
    //基于DFA
    public int KMP2(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        char[] t = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int[][] dfa = getFail(needle);

        int tIndex, pIndex;
        //把搜索串输入状态机
        for (tIndex = 0, pIndex = 0; tIndex < t.length && pIndex < p.length; tIndex++) {
            pIndex = dfa[t[tIndex]][pIndex];
        }
        //达到最后状态
        if (pIndex == p.length) {
            return tIndex - p.length;
        } else {
            return -1;
        }
    }

}
