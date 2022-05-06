package P02TicTacToe;

import java.util.Scanner;

public class TicTacToeST03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', '_', ' ', '_', ' ', '_', ' ', '|'},
                {'|', ' ', '_', ' ', '_', ' ', '_', ' ', '|'},
                {'|', ' ', '_', ' ', '_', ' ', '_', ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
        };

        System.out.print("Enter cells: ");
        String gameState = scanner.nextLine();

        for (int i = 0; i < 3; i++) {
            board[i + 1][2] = gameState.charAt(i * 3);
            board[i + 1][4] = gameState.charAt(i * 3 + 1);
            board[i + 1][6] = gameState.charAt(i * 3 + 2);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        boolean correctNumberOfSigns = correctNumberOfSigns(gameState);
        boolean emptyCells = checkForEmptyCells(gameState);
        String winner = checkForWinner(gameState);

        if (!correctNumberOfSigns || "Impossible".equals(winner)) {
            System.out.println("Impossible");
        } else if (!"Draw".equals(winner)) {
            System.out.println(winner);
        } else if (!emptyCells) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }

    public static boolean correctNumberOfSigns(String gameState) {
        int numberOfX = 0;
        int numberOfO = 0;
        for (int i = 0; i < gameState.length(); i++) {
            if (gameState.charAt(i) == 'X') {
                numberOfX++;
            } else if (gameState.charAt(i) == 'O') {
                numberOfO++;
            }
        }
        return Math.abs(numberOfX - numberOfO) >= 0 && Math.abs(numberOfX - numberOfO) <= 1;
    }

    public static boolean checkForEmptyCells(String gameState) {
        int numberOfEmptyPosition = 0;
        for (int i = 0; i < gameState.length(); i++) {
            if (gameState.charAt(i) == '_') {
                numberOfEmptyPosition++;
            }
        }
        return numberOfEmptyPosition != 0;
    }

    public static String checkForWinner(String gameState) {
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
        if (numberOfWinningCombinationX == 0 && numberOfWinningCombinationO == 0) {
            result = "Draw";
        } else if (numberOfWinningCombinationX == 1 && numberOfWinningCombinationO == 0) {
            result = "X wins";
        } else if (numberOfWinningCombinationX == 0 && numberOfWinningCombinationO == 1) {
            result = "O wins";
        } else {
            result = "Impossible";
        }
        return result;
    }

}