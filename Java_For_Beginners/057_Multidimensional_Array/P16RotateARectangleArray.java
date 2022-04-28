package S057MultidimensionalArray;

import java.util.Scanner;

public class P16RotateARectangleArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] numbersArray = new int[n][m];

        for (int i = 0; i < numbersArray.length; i++) {
            for (int j = 0; j < numbersArray[i].length; j++) {
                numbersArray[i][j] = scanner.nextInt();
            }
        }

        int[][] rotatedArray = new int[m][n];

        for (int i = 0; i < rotatedArray.length; i++) {
            for (int j = 0; j < rotatedArray[i].length; j++) {
                rotatedArray[i][j] = numbersArray[rotatedArray[i].length - 1 - j][i];
            }
        }

        for (int i = 0; i < rotatedArray.length; i++) {
            for (int j = 0; j < rotatedArray[i].length; j++) {
                System.out.print(rotatedArray[i][j]);
                if (j < rotatedArray[i].length - 1) {
                    System.out.print(" ");
                } else if (i < rotatedArray.length - 1) {
                    System.out.println();
                }
            }
        }
    }
}
