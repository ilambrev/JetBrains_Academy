package tictactoe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TicTacToe {
    public static void main(String[] args) {

        char[][] board = {
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
        };

        int movesCounter = 0;

        String gameState = "Draw";

        printBoard(board);

        while (movesCounter < 9 && "Draw".equals(gameState)) {
            movesCounter++;
            char sign;
            if (movesCounter % 2 != 0) {
                sign = 'X';
            } else {
                sign = 'O';
            }
            enterCoordinates(board, sign);
            printBoard(board);
            gameState = checkForWinner(board);
        }

        System.out.println(gameState);
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void enterCoordinates(char[][] board, char sign) {
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
                        board[x][2 * y] = sign;
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

    public static String checkForWinner(char[][] board) {
        StringBuilder combination = new StringBuilder();
        int numberOfWinningCombinationX = 0;
        int numberOfWinningCombinationO = 0;
        int[][] winningCombinations = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        StringBuilder gameState = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            for (int j = 2; j <= 6; j += 2) {
                gameState.append(board[i][j]);
            }
        }

        for (int i = 0; i < winningCombinations.length; i++) {
            for (int j = 0; j < winningCombinations[i].length; j++) {
                int position = winningCombinations[i][j];
                combination.append(gameState.charAt(position));
            }
            if ("XXX".equals(combination.toString())) {
                numberOfWinningCombinationX++;
            } else if ("OOO".equals(combination.toString())) {
                numberOfWinningCombinationO++;
            }
            combination.setLength(0);
        }
        String result;
        if (numberOfWinningCombinationX == 1 && numberOfWinningCombinationO == 0) {
            result = "X wins";
        } else if (numberOfWinningCombinationX == 0 && numberOfWinningCombinationO == 1) {
            result = "O wins";
        } else {
            result = "Draw";
        }
        return result;
    }

}