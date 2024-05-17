// Client.java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("192.168.225.99", 6666);
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter operation:");
            System.out.println("1: sin");
            System.out.println("2: cos");
            System.out.println("3: tan");
            char op = inFromUser.readLine().charAt(0);

            System.out.println("Enter angle in degrees:");
            double angle = Double.parseDouble(inFromUser.readLine());

            outToServer.println(op);
            outToServer.println(angle);

            double result = Double.parseDouble(inFromServer.readLine());
            System.out.println("Operation result from server = " + result);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
