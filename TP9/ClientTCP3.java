import java.io.*;
import java.net.*;

public class ClientTCP3 {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.out.println("Usage: java ClientTCP3 <message>");
                return;
            }

            Socket socket = new Socket("localhost", 2016);

            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            dOut.writeUTF(args[0]);

            // Recevoir la chaîne inversée du serveur
            DataInputStream dIn = new DataInputStream(socket.getInputStream());
            String reversedMessage = dIn.readUTF();
            System.out.println("Received from server: " + reversedMessage);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
