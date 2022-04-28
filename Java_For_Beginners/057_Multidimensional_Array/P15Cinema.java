package S057MultidimensionalArray;

import java.util.Scanner;

public class P15Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int sits = scanner.nextInt();

        int[][] cinemaSits = new int[rows][sits];

        for (int i = 0; i < cinemaSits.length; i++) {
            for (int j = 0; j < cinemaSits[i].length; j++) {
                cinemaSits[i][j] = scanner.nextInt();
            }
        }

        int numberOfTickets = scanner.nextInt();
        int rowWithFreeSeats = 0;

        for (int i = 0; i < cinemaSits.length; i++) {
            int adjacentSits = 0;
            for (int j = 0; j < cinemaSits[i].length; j++) {
                if (adjacentSits == numberOfTickets) {
                    rowWithFreeSeats = i + 1;
                    break;
                }
                if (cinemaSits[i][j] == 0) {
                    adjacentSits++;
                } else {
                    adjacentSits = 0;
                }
            }
            if (rowWithFreeSeats > 0) {
                break;
            }
        }

        System.out.println(rowWithFreeSeats);
    }
}
