package S057MultidimensionalArray;

import java.util.Scanner;

public class P13SwapTheColumns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int i = scanner.nextInt();
        int j = scanner.nextInt();

        for (int k = 0; k < matrix.length; k++) {
            int buffer = matrix[k][i];
            matrix[k][i] = matrix[k][j];
            matrix[k][j] = buffer;
        }

        for (int[] rows : matrix) {
            for (int number : rows) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
