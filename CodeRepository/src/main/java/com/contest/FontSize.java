package com.contest;

import java.util.Scanner;

/**
 * Created by xhans on 2016/4/6.
 */
public class FontSize {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- != 0){
            int p = scanner.nextInt();
            int pages = scanner.nextInt();
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            int[] ps = new int[p];
            for (int i = 0; i < p; i++) {
                ps[i] = scanner.nextInt();
            }
            int fontSize = Math.min(w, h);
            while (fontSize > 0){
                int sum = 0;
                int numInRow = w / fontSize;
                int numInCol = h / fontSize;
                for (int i = 0; i < ps.length; i++) {
                    sum += ps[i];
                    int left = ps[i] % numInRow;
                    //此时说明需要补空格
                    if (left != 0){
                        sum += numInRow - left;
                    }
                }
                int page = sum / (numInCol * numInRow);
                if (page < pages){
                    break;
                }
                fontSize--;
            }

            System.out.println(fontSize);
        }
    }
}
