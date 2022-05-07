package cinema;

import java.util.Scanner;

public class CinemaRoomManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int sitsOnRow = scanner.nextInt();

        String[][] cinemaSits = new String[rows + 1][sitsOnRow + 1];

        arrangeCinemaSits(cinemaSits);
        System.out.println();

        int input = 1;

        while (input != 0) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println();
                    printCinemaSits(cinemaSits);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    sellTicket(cinemaSits, rows, sitsOnRow);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    cinemaStats(cinemaSits);
                    System.out.println();
                    break;
            }
        }
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

        int ticketRow = 0;
        int ticketSit;
        boolean ticketFree = false;

        while (!ticketFree) {
            System.out.println("Enter a row number:");
            ticketRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            ticketSit = scanner.nextInt();
            System.out.println();
            if ((ticketRow < 1 || ticketRow > rows) || (ticketSit < 1 || ticketSit > sitsOnRow)) {
                System.out.println("Wrong input!");
                System.out.println();
                continue;
            }
            if ("S".equals(cinemaSits[ticketRow][ticketSit])) {
                cinemaSits[ticketRow][ticketSit] = "B";
                ticketFree = true;
            } else {
                System.out.println("That ticket has already been purchased!");
                System.out.println();
            }
        }

        System.out.println("Ticket price: $" + calculateTicketPrice(cinemaSits, ticketRow));
    }

    public static int calculateTicketPrice(String[][] cinemaSits, int ticketRow) {
        int ticketPrice;
        int rows = cinemaSits.length - 1;
        int sitsOnRow = cinemaSits[0].length - 1;
        int totalSitsNumber = rows * sitsOnRow;

        if (totalSitsNumber > 60 && ticketRow > rows / 2) {
            ticketPrice = 8;
        } else {
            ticketPrice = 10;
        }
        return ticketPrice;
    }

    public static void cinemaStats(String[][] cinemaSits) {
        int numberOfSoldTickets = 0;
        double percentage;
        int currentIncome = 0;
        int totalIncome = 0;
        int totalNumberOfTickets = (cinemaSits.length - 1) * (cinemaSits[0].length - 1);

        for (int i = 1; i < cinemaSits.length; i++) {
            for (int j = 1; j < cinemaSits[i].length; j++) {
                int ticketPrice = calculateTicketPrice(cinemaSits, i);
                totalIncome += ticketPrice;
                if ("B".equals(cinemaSits[i][j])) {
                    numberOfSoldTickets++;
                    currentIncome += ticketPrice;
                }
            }
        }

        percentage = numberOfSoldTickets * 100.0 / totalNumberOfTickets;

        System.out.println("Number of purchased tickets: " + numberOfSoldTickets);
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

}