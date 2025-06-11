package problem_solving.leetcode.medium;

import java.util.HashMap;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            HashMap<Character, Integer> tempRowMap = new HashMap<>();
            HashMap<Character, Integer> tempColMap = new HashMap<>();

            for (int j = 0; j < 9; j++) {
                // Validate row
                char row = board[i][j];
                if (row != '.') {
                    if (tempRowMap.containsKey(row)) {
                        return false;
                    }
                    tempRowMap.put(row, 1);
                }

                // Validate column
                char col = board[j][i];
                if (col != '.') {
                    if (tempColMap.containsKey(col)) {
                        return false;
                    }
                    tempColMap.put(col, 1);
                }
            }
        }

        // Validate Boxes
//        int[][] starts = {
//            new int[]{0, 0}, new int[]{0, 3}, new int[]{0, 6},
//            new int[]{3, 0}, new int[]{3, 3}, new int[]{3, 6},
//            new int[]{6, 0}, new int[]{6, 3}, new int[]{6, 6},
//        };
//
//        for(int[] start : starts){
//            HashMap<Character, Integer> gridRowMap = new HashMap<>();
//            for(int row = start[0]; row < start[0] + 3; row++){
//                for(int col = start[1]; col < start[1] + 3; col++){
//                    char value = board[row][col];
//                    if(gridRowMap.containsKey(value)){
//                        return false;
//                    } else if(value != '.') {
//                        gridRowMap.put(value, 1);
//                    }
//                }
//            }
//        }

        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                HashMap<Character, Integer> gridMap = new HashMap<>();
                for (int i = boxRow; i < boxRow + 3; i++) {
                    for (int j = boxCol; j < boxCol + 3; j++) {
                        char value = board[i][j];
                        if (value != '.') {
                            if (gridMap.containsKey(value)) {
                                return false;
                            }
                            gridMap.put(value, 1);
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board));

        char[][] board2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board2));

    }
}
