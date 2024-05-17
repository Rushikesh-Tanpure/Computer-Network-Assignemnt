import java.io.*;

public class Selective {

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Please enter the No. of Frames: ");
    int frames = Integer.parseInt(br.readLine());

    System.out.println("Please enter the Window Size: ");
    int window = Integer.parseInt(br.readLine());
    int count = 0;

    boolean loop = true;
    int sent = 0;

    while (loop) {
      for (int i = sent; i < Math.min(sent + window, frames); i++) {
        System.out.println("Frame " + i + " has been sent.");
      }

      System.out.println("Please enter the Acknowledgement not received.");
      int ack = Integer.parseInt(br.readLine());

      System.out.println("Frame " + ack + " has been sent.");
      
      if (ack == frames) {
        loop = false;
      } else {
        sent = count += window;
        ;
      }
    }
  }
}
