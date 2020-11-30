package server;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = Database.getInstance();
        String input;
        while (true) {
            input = scanner.nextLine();
            System.out.println(database.handleInput(input.split(" ")));
        }
    }
}
