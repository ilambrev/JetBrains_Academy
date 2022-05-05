package S057MultidimensionalArray;

import java.util.Scanner;

public class P11FillTheMatrixByNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] array = new int[n][n];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Math.abs(j - i);
            }
        }
        System.out.println();
    }
}
