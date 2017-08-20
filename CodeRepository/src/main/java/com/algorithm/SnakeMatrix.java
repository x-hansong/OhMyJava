package com.algorithm;

import java.util.Scanner;

/**
 * Created by xhans on 2016/4/3.
 */
public class SnakeMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n > 0) {
            int[][] table = new int[n][n];
            int product = n * n;
            int row = 0, col = 0;
            for (int i = 1; i <= product; ) {
                //向右
                while (col < n && table[row][col] == 0) {
                    table[row][col] = i++;
                    col++;
                }
                col--;
                row++;
                //向下
                while (row < n && table[row][col] == 0) {
                    table[row][col] = i++;
                    row++;
                }
                row--;
                col--;
                //向左
                while (col >= 0 && table[row][col] == 0) {
                    table[row][col] = i++;
                    col--;
                }
                col++;
                row--;
                //向上
                while (row >= 0 && table[row][col] == 0) {
                    table[row][col] = i++;
                    row--;
                }
                row++;
                col++;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(table[i][j] + " ");
                }
            }
        }

    }
}

