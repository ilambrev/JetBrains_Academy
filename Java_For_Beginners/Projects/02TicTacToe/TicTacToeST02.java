package P02TicTacToe;

import java.util.Scanner;

public class TicTacToeST02 {
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
    }
}