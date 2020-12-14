package server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Scanner;

public class Main {

    private static final String ADDRESS = "127.0.0.1";
    private static final int PORT = 2000;

    public static void main(String[] args) {
        // startDB();
        startServer();
    }

    static void startServer() {
        System.out.println("Server started!");
        try (ServerSocket server = new ServerSocket(PORT, 50, InetAddress.getByName(ADDRESS))) {

            Session session = new Session(server.accept());
            session.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void startDB() {
        Scanner scanner = new Scanner(System.in);
        Database database = Database.getInstance();
        String input;
        while (true) {
            input = scanner.nextLine();
            try {
                System.out.println(database.handleInput(input.split(" ")));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
