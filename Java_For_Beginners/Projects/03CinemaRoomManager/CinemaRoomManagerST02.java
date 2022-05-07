package P03CinemaRoomManager;

import java.util.Scanner;

public class CinemaRoomManagerST02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int sitsOnRow = scanner.nextInt();

        int totalSitsNumber = rows * sitsOnRow;

        int totalIncome = 0;

        if (totalSitsNumber <= 60) {
            totalIncome = totalSitsNumber * 10;
        } else {
            int firstHalfOfRows = rows / 2;
            int secondHalfOfRows = rows - firstHalfOfRows;
            totalIncome = firstHalfOfRows * sitsOnRow * 10 +
                    secondHalfOfRows * sitsOnRow * 8;
        }
        System.out.println("Total income:");
        System.out.println("$" + totalIncome);
    }
}