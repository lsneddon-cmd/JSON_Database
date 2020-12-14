package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Session extends Thread {

    private final Socket socket;

    public Session(Socket socketForClient) {
        this.socket = socketForClient;
    }

    @Override
    public void run() {
        try (
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())

        ) {
            System.out.println("Received: " + input.readUTF());
            String message = "A record # 3 was sent!";
            System.out.println("Sent: " + message);
            output.writeUTF(message);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
