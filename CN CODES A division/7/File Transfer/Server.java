// Server.java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        System.out.println("Listening");
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket connectionSocket = serverSocket.accept();
            
            byte[] buffer = new byte[256];
            int bytesRead;
            
            FileInputStream fileInputStream = new FileInputStream("sample_file.txt");
            OutputStream outputStream = connectionSocket.getOutputStream();
            
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            
            outputStream.close();
            fileInputStream.close();
            serverSocket.close();
            System.out.println("File sent successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//Multiple Client

// // Server.java
// import java.io.*;
// import java.net.*;

// public class Server {
//     public static void main(String[] args) {
//      System.out.println("Listening");
//         try {
//             ServerSocket serverSocket = new ServerSocket(5000);
            
//             while (true) {
//                 Socket connectionSocket = serverSocket.accept();
                
//                 // Create a new thread to handle each client
//                 Thread clientHandler = new Thread(new ClientHandler(connectionSocket));
//                 clientHandler.start();
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }

// class ClientHandler implements Runnable {
//     private Socket connectionSocket;

//     public ClientHandler(Socket connectionSocket) {
//         this.connectionSocket = connectionSocket;
//     }

//     @Override
//     public void run() {
//         try {
//             byte[] buffer = new byte[256];
//             int bytesRead;
            
//             FileInputStream fileInputStream = new FileInputStream("sample_file.txt");
//             OutputStream outputStream = connectionSocket.getOutputStream();
            
//             while ((bytesRead = fileInputStream.read(buffer)) != -1) {
//                 outputStream.write(buffer, 0, bytesRead);
//             }
            
//             outputStream.close();
//             fileInputStream.close();
//             connectionSocket.close();
//             System.out.println("File sent to client: " + connectionSocket.getInetAddress());
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }
