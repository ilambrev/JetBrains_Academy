package S057MultidimensionalArray;

import java.util.Scanner;

public class P14MaximumElementInAMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] arrayOfNumbers = new int[n][m];

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            for (int j = 0; j < arrayOfNumbers[i].length; j++) {
                arrayOfNumbers[i][j] = scanner.nextInt();
            }
        }

        int maxNumber = Integer.MIN_VALUE;
        int line = 0;
        int column = 0;

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            for (int j = 0; j < arrayOfNumbers[i].length; j++) {
                if (arrayOfNumbers[i][j] > maxNumber) {
                    maxNumber = arrayOfNumbers[i][j];
                    line = i;
                    column = j;
                }
            }
        }

        System.out.println(line + " " + column);
    }
}
