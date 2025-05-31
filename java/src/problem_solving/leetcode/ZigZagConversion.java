package problem_solving.leetcode;

public class ZigZagConversion {

    public static String zigZagConversion(String s, int rows){
        if(rows == 0) return null;
        if(rows == 1 || rows > s.length()) return s;

        int length = s.length();
        char[][] matrix = new char[rows][(s.length() / 2) + 1];
        int counter = 0;
        int i = 0, j = 0;
        boolean bottom = false;
        while(counter < length){
            matrix[i][j] = s.charAt(counter);
            counter++;

            if(!bottom){
                i++;
                if(i == rows - 1) bottom = true;
            } else {
                i--;
                j++;
                if(i == 0) bottom = false;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int k = 0; k < rows; k++) {
            for(char c : matrix[k]){
                if(c != 0 ){
                    stringBuilder.append(c);
                }
            }
        }
        String finalString = stringBuilder.toString();

        System.out.println(finalString.length() == s.length());

        return finalString;
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        int direction = 1; // 1 para baixo, -1 para cima

        for (char c : s.toCharArray()) {
            rows[currRow].append(c);
            currRow += direction;

            if (currRow == numRows - 1 || currRow == 0) {
                direction *= -1;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(zigZagConversion("PAYPALISHIRING", 3));
        System.out.println(zigZagConversion("PAYPALISHIRING", 4));
        System.out.println(zigZagConversion("PAYPALISHIRING", 5));
        System.out.println(zigZagConversion("PAYPALISHIRING", 1));
        System.out.println(zigZagConversion("PAYPALISHIRING", 2));
        System.out.println(zigZagConversion("A", 1));
        System.out.println(zigZagConversion("HADUKEN,SHURIUKEN,PEPEPEE", 2));
        System.out.println(zigZagConversion("HADUKEN,SHURIUKEN,ASDASDASDASDASDASDASDASDASDASDASDASDSADA", 20));
        System.out.println("-------------------------------------");
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("PAYPALISHIRING", 5));
        System.out.println(convert("PAYPALISHIRING", 1));
        System.out.println(convert("PAYPALISHIRING", 2));
        System.out.println(convert("A", 1));
        System.out.println(convert("HADUKEN,SHURIUKEN,PEPEPEE", 2));
        System.out.println(convert("HADUKEN,SHURIUKEN,ASDASDASDASDASDASDASDASDASDASDASDASDSADA", 20));

    }
}
