import java.io.*;
import java.net.*;

public class Server {
  private Socket s = null;
  private ServerSocket ss = null;
  private DataInputStream in = null;
  private DataOutputStream out = null;

  public Server(int port) {
    // Network Connection
    try {
      ss = new ServerSocket(port);
      System.out.println("Server Started on " + InetAddress.getLocalHost().getHostAddress());
      System.out.println("Waiting for client...");

      s = ss.accept();
      System.out.println("Client Accepted.");

      in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
      out = new DataOutputStream(s.getOutputStream());

      String m = "";
      while (!m.equals("bye")) {
        try {
          m = in.readUTF();
          System.out.println(m);
          // Validation
          if (isAlpha(m)) {
            System.out.println(m.toUpperCase());
          } else {
            System.out.println("Try Again.");
          }
          


        } catch (IOException i) {
          System.out.println(i);
        }
      }
      System.out.println("Server closing.");

      s.close();
      in.close();
    } catch (IOException i) {
      System.out.println(i);
    }
  }

  public static boolean isAlpha(String s) {
    if (s == null || s.isEmpty()) return false;
    return s.chars().allMatch(Character::isAlphabetic);
  }

  public static void main(String[] args) {
    Server s = new Server(5000);
  }
}
