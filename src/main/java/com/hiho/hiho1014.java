package com.hiho;

import java.util.Scanner;

/**
 * Created by xhans on 2016/4/8.
 */
public class Hiho1014 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(scanner.next());
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.println(trie.getPrefixNum(scanner.next()));
        }
    }

    public static class Trie{

        public Node root = new Node();
        class Node{
            int num;//记录以本节点开头的数量
            Node[] next = new Node[26];//可以利用ch-'a'的下标来表示节点表示的值
        }
        public void insert(String word){
            Node node = root;
            node.num++;
            int len = word.length();
            char[] words = word.toCharArray();
            for (int i = 0; i < len; i++) {
                char ch = words[i];
                int pos = ch - 'a';
                if (node.next[pos] == null){
                    node.next[pos] = new Node();
                    node = node.next[pos];
                } else {
                    node = node.next[pos];
                }
                node.num++;
            }
        }
        public int getPrefixNum(String prefix){
            int result = 0;
            Node node = root;
            int len = prefix.length();
            char[] prefixs = prefix.toCharArray();
            for (int i = 0; i < len; i++) {
                int pos = prefixs[i] - 'a';
                if (node.next[pos] != null){
                    node = node.next[pos];
                } else {
                    return 0;
                }
                if (i == prefix.length() - 1){
                    result = node.num;
                }
            }
            return result;
        }
    }
}
