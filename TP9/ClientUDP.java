import java.io.*;
import java.net.*;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            InetAddress serverAddress = InetAddress.getLocalHost();
            System.out.println("Server Address: " + serverAddress.getHostName());

            String messageToSend = "Hello World";
            byte[] sendData = messageToSend.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 1234);
            DatagramSocket sock = new DatagramSocket();
            sock.send(sendPacket);

            // Attendre la réponse du serveur
            DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
            sock.receive(receivePacket);
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from server: " + receivedMessage);

            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
