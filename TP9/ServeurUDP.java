import java.io.*;
import java.net.*;

public class ServeurUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket sock = new DatagramSocket(1234);
            while (true) {
                System.out.println("- Waiting for data");
                DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
                sock.receive(receivePacket);

                // Récupérer les informations du client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Convertir les données reçues en chaîne
                String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received: " + receivedData);

                // Envoyer la chaîne reçue au client
                byte[] sendData = receivedData.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                sock.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
