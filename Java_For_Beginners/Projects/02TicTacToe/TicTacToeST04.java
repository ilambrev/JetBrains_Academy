package P02TicTacToe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TicTacToeST04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
        };

        System.out.print("Enter cells: ");
        String gameState = scanner.nextLine().replace('_', ' ');

        for (int i = 0; i < 3; i++) {
            board[i + 1][2] = gameState.charAt(i * 3);
            board[i + 1][4] = gameState.charAt(i * 3 + 1);
            board[i + 1][6] = gameState.charAt(i * 3 + 2);
        }

        printBoard(board);
        enterCoordinates(board);
        printBoard(board);

    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void enterCoordinates(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        boolean correctCoordinates = false;
        while (!correctCoordinates) {
            System.out.print("Enter the coordinates: ");
            String coordinates = scanner.nextLine();
            Pattern pattern = Pattern.compile("(?<x>\\d) +(?<y>\\d)");
            Matcher matcher = pattern.matcher(coordinates);
            if (matcher.matches()) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                if (x == 0 || x > 3 || y == 0 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (board[x][2 * y] == ' ') {
                        board[x][2 * y] = 'X';
                        correctCoordinates = true;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
    }

}