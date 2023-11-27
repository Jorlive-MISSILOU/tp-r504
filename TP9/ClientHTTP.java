import java.io.*;
import java.net.*;

public class ClientHTTP {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ClientHttp <hostname>");
            return;
        }

        try {
            Socket socket = new Socket(args[0], 80);

            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            InputStreamReader isw = new InputStreamReader(socket.getInputStream());
            BufferedWriter bufOut = new BufferedWriter(osw);
            BufferedReader bufIn = new BufferedReader(isw);

            String request = "GET / HTTP/1.0\r\n\r\n"; // requête HTTP
            bufOut.write(request, 0, request.length());
            bufOut.flush();

            String line = bufIn.readLine(); // lecture ligne par ligne
            while (line != null) {
                // tant qu'il y a des données reçues,
                System.out.println(line); //... les afficher
                line = bufIn.readLine();
            }

            bufIn.close();
            bufOut.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
