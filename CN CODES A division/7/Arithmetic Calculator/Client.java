// Client.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 6006);
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            try (Scanner sc = new Scanner(System.in)) {

                System.out.println("Enter operation:");
                System.out.println("+ : Addition");
                System.out.println("- : Subtraction");
                System.out.println("/ : Division");
                System.out.println("* : Multiplication");

                char operator = sc.nextLine().charAt(0); // Using nextLine() to read a line and charAt(0) to get the first character

                System.out.println("Enter operands:");
                int op1 = sc.nextInt(); // Using nextInt() to read an integer
                int op2 = sc.nextInt();

                outToServer.println(operator);
                outToServer.println(op1);
                outToServer.println(op2);
            }

            int result = Integer.parseInt(inFromServer.readLine());
            System.out.println("Operation result from server = " + result);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
