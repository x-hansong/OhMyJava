package com.leecode.easy;

/**
 * Created by xhans on 2016/2/16.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] col = new boolean[9][9];
        boolean[][] row = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.'){
                    continue;
                }
                int num = ch - '1';
                if (row[i][num]){
                    return false;
                } else {
                    row[i][num] = true;
                }

                if (col[j][num]){
                    return false;
                } else {
                    col[j][num] = true;
                }

                int s = (i / 3) * 3 + j / 3;
                if (box[s][num]){
                    return false;
                } else {
                    box[s][num] = true;
                }
            }
        }

        return true;
    }
}
