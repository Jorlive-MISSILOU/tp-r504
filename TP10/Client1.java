import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpGet;

public class Client1 {
    public static void main(String[] args) {
        // Vérification du nombre d'arguments
        if (args.length == 0) {
            System.out.println("Erreur : Au moins un argument est requis.");
            System.exit(1); // Quitter le programme avec un code d'erreur
        }

        // Création du client HTTP et de la requête GET
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            String url = "http://" + args[0];
            HttpGet request = new HttpGet(url);

            // Exécution de la requête et affichage de la réponse
            try (CloseableHttpResponse response = client.execute(request)) {
                System.out.println("Executing request " + request.getRequestLine());
                System.out.println("Response Line: " + response.getStatusLine());
                System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

                // Récupérer le contenu HTML
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    try (BufferedReader rd = new BufferedReader(new InputStreamReader(entity.getContent()))) {
                        // Lire le contenu ligne par ligne et le stocker dans un StringBuffer
                        StringBuffer result = new StringBuffer();
                        String line;
                        while ((line = rd.readLine()) != null) {
                            result.append(line);
                            result.append("\n"); // Ajouter un saut de ligne
                        }

                        // Afficher la page à l'écran
                        String page = result.toString();
                        System.out.println("Page reçue du serveur :");
                        System.out.println(page);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Exemple : Afficher les arguments
        System.out.println("Arguments fournis :");
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
