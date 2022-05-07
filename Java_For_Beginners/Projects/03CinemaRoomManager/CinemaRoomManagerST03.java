package P03CinemaRoomManager;

import java.util.Scanner;

public class CinemaRoomManagerST03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int sitsOnRow = scanner.nextInt();

        String[][] cinemaSits = new String[rows + 1][sitsOnRow + 1];

        arrangeCinemaSits(cinemaSits);
        System.out.println();
        printCinemaSits(cinemaSits);
        System.out.println();
        sellTicket(cinemaSits, rows, sitsOnRow);
        System.out.println();
        printCinemaSits(cinemaSits);

    }

    public static void arrangeCinemaSits(String[][] cinemaSits) {
        for (int i = 0; i < cinemaSits.length; i++) {
            for (int j = 0; j < cinemaSits[i].length; j++) {
                if (i == 0 && j == 0) {
                    cinemaSits[i][j] = " ";
                } else if (i == 0) {
                    cinemaSits[i][j] = Integer.toString(j);
                } else if (j == 0) {
                    cinemaSits[i][j] = Integer.toString(i);
                } else {
                    cinemaSits[i][j] = "S";
                }
            }
        }
    }

    public static void printCinemaSits(String[][] cinemaSits) {
        System.out.println("Cinema:");
        for (int i = 0; i < cinemaSits.length; i++) {
            for (int j = 0; j < cinemaSits[i].length; j++) {
                System.out.print(cinemaSits[i][j]);
                if (j < cinemaSits[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void sellTicket(String[][] cinemaSits, int rows, int sitsOnRow) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int ticketRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int ticketSit = scanner.nextInt();
        System.out.println();
        int totalSitsNumber = rows * sitsOnRow;
        int ticketPrice;

        if (totalSitsNumber > 60 && ticketRow > rows / 2) {
            ticketPrice = 8;
        } else {
            ticketPrice = 10;
        }
        cinemaSits[ticketRow][ticketSit] = "B";
        System.out.println("Ticket price: $" + ticketPrice);
    }
}