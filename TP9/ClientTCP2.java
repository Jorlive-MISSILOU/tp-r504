import java.io.*;
import java.net.*;

public class ClientTCP2 {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.out.println("Usage: java ClientTCP2 <message>");
                return;
            }

            Socket socket = new Socket("localhost", 2016);

            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            dOut.writeUTF(args[0]);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
