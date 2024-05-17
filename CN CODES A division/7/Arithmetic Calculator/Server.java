// Server.java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6006);
            System.out.println("Server started and waiting for connections...");

            while (true) {
                Socket connectionSocket = serverSocket.accept();

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                PrintWriter outToClient = new PrintWriter(connectionSocket.getOutputStream(), true);

                char operator = inFromClient.readLine().charAt(0);
                int op1 = Integer.parseInt(inFromClient.readLine());
                int op2 = Integer.parseInt(inFromClient.readLine());

                int result = 0;
                switch (operator) {
                    case '+':
                        result = op1 + op2;
                        break;
                    case '-':
                        result = op1 - op2;
                        break;
                    case '*':
                        result = op1 * op2;
                        break;
                    case '/':
                        if (op2 != 0)
                            result = op1 / op2;
                        else {
                            System.out.println("Cannot divide by zero!");
                            connectionSocket.close();
                            continue;
                        }
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
