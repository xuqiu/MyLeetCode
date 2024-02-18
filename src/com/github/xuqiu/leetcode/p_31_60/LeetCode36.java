package com.github.xuqiu.leetcode.p_31_60;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-06-16 18:15
 */
public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            //row
            char[] row = board[i];
            //column
            char[] column = {board[0][i],board[1][i],board[2][i],board[3][i],board[4][i],board[5][i],board[6][i],board[7][i],board[8][i]};
            //zone
            char[] zone = {
                board[(i/3)*3+0][(i%3)*3],board[(i/3)*3+0][(i%3)*3+1],board[(i/3)*3+0][(i%3)*3+2],
                board[(i/3)*3+1][(i%3)*3],board[(i/3)*3+1][(i%3)*3+1],board[(i/3)*3+1][(i%3)*3+2],
                board[(i/3)*3+2][(i%3)*3],board[(i/3)*3+2][(i%3)*3+1],board[(i/3)*3+2][(i%3)*3+2]};
            if (conflict(row)||conflict(column)||conflict(zone)) {
                return false;
            }
        }
        return true;
    }

    private static boolean conflict(char[] chars) {
        Set<Character> charSet = new HashSet<>();
        for (char aChar : chars) {
            if (aChar == '.') {
                continue;
            }
            if (charSet.contains(aChar)) {
                return true;
            }
            charSet.add(aChar);
        }
        return false;
    }
    @Test
    public void test(){
        System.out.println(isValidSudoku(new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        }));
    }
}
