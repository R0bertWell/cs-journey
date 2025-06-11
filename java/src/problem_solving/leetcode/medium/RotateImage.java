package problem_solving.leetcode.medium;

import java.util.*;

public class RotateImage {

    public static void rotate(int[][] matrix) {
        int length = matrix.length;

        // Transpose -> Transform rows in columns
        for(int i = 0; i < length; i++){
            for(int j = i + 1; j < length; j++){
               int temp = matrix[j][i];
               matrix[j][i] = matrix[i][j];
               matrix[i][j] = temp;
            }
        }

        // Reflection -> Draw a mid line in the matrix and swap simmetrically
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length / 2; j++){
                int temp = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

    }

    public static void main(String[] args) {
        rotate(new int[][]{
                new int[]{1,2},
                new int[]{3,4}
        });
        rotate(new int[][]{
                new int[]{1,2,3,4},
                new int[]{5,6,7,8},
                new int[]{9,10,11,12},
                new int[]{13,14,15,16}
        });
    }
}
