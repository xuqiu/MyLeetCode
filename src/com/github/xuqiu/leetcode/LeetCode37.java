package com.github.xuqiu.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author yinzhennan
 * @version V1.0
 * @since 2022-06-16 18:14
 */
public class LeetCode37 {
    private static final Set<String> ZONE_POS_SET = Set.of("00","01","02","10","11","12","20","21","22");
    public void solveSudoku(char[][] board) {
        Sudoku sudoku = solveSudoku(new Sudoku(board));
        for (int y = 0; y < 9; y++) {
            System.arraycopy(sudoku.data[y], 0, board[y], 0, 9);
        }
    }

    public Sudoku solveSudoku(Sudoku sudoku) {
        //        System.out.println(sudoku);
        if (sudoku.solved()){
            return sudoku;
        }
        List<Possible> possibles = new ArrayList<>();
        for (char c = '1'; c <= '9'; c++) {
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    Possible possible = analyze(c, y, x, sudoku);
                    if(possible == null){
                        continue;
                    }
                    if(possible.sure()){
                        sudoku.draw(possible);
                        return solveSudoku(sudoku);
                    }else{
                        possibles.add(possible);
                    }
                }
            }
        }
        final Possible possible = possibles.stream().min(Comparator.comparingInt(Possible::optionNum)).orElse(null);
        if (possible == null) {
            return null;
        }
        return sudoku.drawMeta(possible).stream().map(this::solveSudoku).filter(Objects::nonNull).findFirst().orElse(null);
    }

    private Possible analyze(char c, int zy, int zx, Sudoku sudoku) {
        Set<String> zonePosSet = new HashSet<>(ZONE_POS_SET);
        //clear self zone
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (sudoku.data[zy*3+y][zx*3+x] == c) {
                    return null;
                }
                if (sudoku.data[zy*3+y][zx*3+x] != '.') {
                    zonePosSet.remove(y + String.valueOf(x));
                }
            }
        }
        //clear by same line/column zones
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (sudoku.data[zy*3+y][(zx+1)%3*3+x] == c || sudoku.data[zy*3+y][(zx+2)%3*3+x] == c) {
                    zonePosSet.removeAll(Set.of(y+"0",y+"1",y+"2"));
                }
                if (sudoku.data[(zy+1)%3*3+y][zx*3+x] == c || sudoku.data[(zy+2)%3*3+y][zx*3+x] == c) {
                    zonePosSet.removeAll(Set.of("0"+x,"1"+x,"2"+x));
                }
            }
        }
        if(zonePosSet.isEmpty()) {
            return null;
        }
        List<List<Integer>> possiblePos = zonePosSet.stream()
            .map(yx -> List.of(zy*3+Integer.parseInt(yx.substring(0,1)), zx*3+Integer.parseInt(yx.substring(1,2)))).collect(Collectors.toList());
        return new Possible(c, possiblePos);
    }

    public static class Sudoku{
        private final char[][] data;
        public Sudoku(char[][] data){
            this.data = data;
        }

        public void draw(Possible possible) {
            data[possible.positions.get(0).get(0)][possible.positions.get(0).get(1)]=possible.c;
        }
        public List<Sudoku> drawMeta(Possible possible) {
            return possible.positions.stream().map(position -> {
                final Sudoku sudoku = deepCopy();
                sudoku.data[position.get(0)][position.get(1)]=possible.c;
                return sudoku;
            }).collect(Collectors.toList());
        }
        @Override
        public String toString(){
            StringBuilder result = new StringBuilder();
            for (char[] datum : data) {
                result.append("\n");
                for (char i : datum) {
                    result.append(i).append("  ");
                }
            }
            return result.toString();
        }

        public boolean solved() {
            for (char[] datum : data) {
                for (char c : datum) {
                    if (c == '.') {
                        return false;
                    }
                }
            }
            return true;
        }

        Sudoku deepCopy(){
            char[][] newData = new char[9][9];
            for (int y = 0; y < 9; y++) {
                System.arraycopy(data[y], 0, newData[y], 0, 9);
            }
            return new Sudoku(newData);
        }
    }
    public static class Possible{
        char c;
        List<List<Integer>> positions;
        public Possible(char c, List<List<Integer>> positions){
            this.c=c;
            this.positions=positions;
        }
        boolean sure(){
            return positions.size() == 1;
        }
        int optionNum(){
            return positions.size();
        }
    }

}
