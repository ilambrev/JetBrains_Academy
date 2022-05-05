package S057MultidimensionalArray;

import java.util.Scanner;

public class P12TheStarFigure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[][] array = new String[n][n];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ".";
            }
        }

        int m = n / 2;

        for (int i = 0; i < array.length; i++) {
            array[i][m] = "*";
        }

        for (int i = 0; i < array[m].length; i++) {
            array[m][i] = "*";
        }

        for (int i = 0; i < array.length; i++) {
            array[i][i] = "*";
            array[i][array.length - 1 - i] = "*";
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
