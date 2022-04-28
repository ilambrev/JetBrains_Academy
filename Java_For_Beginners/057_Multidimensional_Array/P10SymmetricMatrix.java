package S057MultidimensionalArray;

import java.util.Scanner;

public class P10SymmetricMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[][] matrixTranspose = new int[n][n];

        for (int i = 0; i < matrixTranspose.length; i++) {
            for (int j = 0; j < matrixTranspose[i].length; j++) {
                matrixTranspose[j][i] = matrix[i][j];
            }
        }

        boolean matrixIsSymmetric = true;

        for (int i = 0; i < matrixTranspose.length; i++) {
            for (int j = 0; j < matrixTranspose[i].length; j++) {
                if (matrixTranspose[i][j] != matrix[i][j]) {
                    matrixIsSymmetric = false;
                    break;
                }
            }
            if (!matrixIsSymmetric) {
                break;
            }
        }

        if (matrixIsSymmetric) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
