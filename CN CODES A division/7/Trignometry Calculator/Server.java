// Server.java
import java.io.*;
import java.net.*;
import java.lang.Math;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("Server started and waiting for connections...");

            while (true) {
                Socket connectionSocket = serverSocket.accept();

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream(), true);

                char op = inFromClient.readLine().charAt(0);
                double angle = Double.parseDouble(inFromClient.readLine());

                double result = 0;
                switch (op) {
                    case '1':
                        result = Math.sin(Math.toRadians(angle));
                        break;
                    case '2':
                        result = Math.cos(Math.toRadians(angle));
                        break;
                    case '3':
                        result = Math.tan(Math.toRadians(angle));
                        break;
                    default:
                        System.out.println("Unsupported Operation!");
                        connectionSocket.close();
                        continue;
                }

                System.out.println("Operation result: " + result);
                outToClient.println(result);

                connectionSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
