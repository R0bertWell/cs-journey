package problem_solving.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public static List<Integer> spiralOrderFirst(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int height = matrix.length;
        int width = matrix[0].length;

        int total = height * width;
        int w = 0, h = 0;
        int w_i = 1, h_i = 1;
        int w_l_b = 0, w_r_b = 0, h_t_b = 0, h_d_b = 0;
        boolean w_h = true;
        while(total > 0){
            spiral.add(matrix[h][w]);
            total--;
            if(total == 0) break;

            if(w_h){
                if((w_i == 1 && w < (width - 1 - w_r_b)) || (w_i == -1 && w > w_l_b)){
                    w += w_i;
                } else {
                    if(w_i == 1){
                        h_t_b++;
                    } else {
                        h_d_b++;
                    }
                    w_i *= -1;
                    w_h = false;
                    h += h_i;
                }
            } else {
                if((h_i == 1 && h < (height - 1 - h_d_b)) || (h_i == -1 && h > h_t_b)){
                    h += h_i;
                } else {
                    if(h_i == 1){
                        w_r_b++;
                    } else {
                        w_l_b++;
                    }
                    h_i *= -1;
                    w_h = true;
                    w += w_i;
                }
            }
        }

        return spiral;
    }

    public static List<Integer> spiralOrderBetter(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int height = matrix.length;
        int width = matrix[0].length;
        int total_elements = height * width;


        int row_index = 0, col_index = 0;
        int row_direction = 1, col_direction = 1;
        int remainingRows = width;
        int remainingCols = height;
        while(total_elements > 0){
            int tempRemainRows = remainingRows;
            int tempRemainCols = remainingCols;

            while(tempRemainRows > 0){
                spiral.add(matrix[col_index][row_index]);
                total_elements--;
                tempRemainRows--;

                if(tempRemainRows == 0) break;

                row_index += row_direction;
            }

            tempRemainCols--;
            col_index += col_direction;

            while(tempRemainCols > 0){
                spiral.add(matrix[col_index][row_index]);
                total_elements--;
                tempRemainCols--;

                if(tempRemainCols == 0) break;

                col_index += col_direction;
            }

            col_direction *= -1;
            row_direction *= -1;

            row_index += row_direction;

            remainingRows--;
            remainingCols--;
        }

        return spiral;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Direita
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Baixo
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Esquerda (verifica se ainda tem linha)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Cima (verifica se ainda tem coluna)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{
                new int[]{1,2,3,4},
                new int[]{5,6,7,8},
                new int[]{9,10,11,12},
                new int[]{13,14,15,16},
                new int[]{17,18,19,20},
                new int[]{21,22,23,24}
        }));
        System.out.println(spiralOrderBetter(new int[][]{
                new int[]{1,2,3,4},
                new int[]{5,6,7,8},
                new int[]{9,10,11,12},
                new int[]{13,14,15,16},
                new int[]{17,18,19,20},
                new int[]{21,22,23,24}
        }));

        System.out.println("==================================");

        System.out.println(spiralOrderBetter(new int[][]{
                new int[]{1,2,3,4},
                new int[]{5,6,7,8},
                new int[]{9,10,11,12}
        }));
        System.out.println("==================================");

        System.out.println(spiralOrderBetter(new int[][]{
                new int[]{1,2,3,},
                new int[]{4,5,6,},
                new int[]{7,8,9}
        }));
    }
}
