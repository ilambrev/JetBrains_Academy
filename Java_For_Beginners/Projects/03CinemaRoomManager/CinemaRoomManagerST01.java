package P03CinemaRoomManager;

public class CinemaRoomManagerST01 {

    public static void main(String[] args) {

        String[][] cinemaSits = new String[8][9];

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
}