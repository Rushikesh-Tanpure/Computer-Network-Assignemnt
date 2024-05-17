// Server.java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket welcomeSocket = new ServerSocket(7891);
            System.out.println("Listening");
            Socket connectionSocket = welcomeSocket.accept();
            PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream(), true);
            outToClient.println("Hello World");
            connectionSocket.close();
            welcomeSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
