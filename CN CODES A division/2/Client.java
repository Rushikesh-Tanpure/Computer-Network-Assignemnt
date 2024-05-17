//code for client

import java.io.*;
import java.net.*;

public class Client {
    Socket s;
    DataInputStream din;
    DataOutputStream dout;

    public Client() {
        try {
            String serverName = "192.168.252.146"; 
            s = new Socket(serverName, 10);
            System.out.println(s);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            ClientChat();
        } catch (Exception e) {
            System.out.println(e);
        }
    } 

    public void ClientChat() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1;
        do {
            s1 = br.readLine();
            dout.writeUTF(s1);
            dout.flush();
            System.out.println("Server Message:" + din.readUTF());
        } while (!s1.equals("stop"));
    }

    public static void main(String as[]) {
        new Client();
    }
}