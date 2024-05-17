// Client.java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Replace "server_ip_address" with the actual IP address of the system running the server
            Socket clientSocket = new Socket("192.168.225.99", 7891);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String receivedMessage = inFromServer.readLine();
            System.out.println("Data received: " + receivedMessage);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
