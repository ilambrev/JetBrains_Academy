package P01ChattyBot;

import java.util.Scanner;

public class ChattyBotST02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! My name is Johnnie.");
        System.out.println("I was created in 2022.");
        System.out.println("Please, remind me your name.");

        String name = scanner.nextLine();

        System.out.println("What a great name you have, " + name + "!");
    }
}