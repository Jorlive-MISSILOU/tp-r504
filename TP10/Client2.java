import java.io.InputStreamReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpGet;
import java.io.IOException;

import javax.json.*;

public class Client2 {
    public static void main(String[] args) {
        // Vérification du nombre d'arguments
        if (args.length == 0) {
            System.out.println("Erreur : Au moins un argument est requis.");
            System.exit(1); // Quitter le programme avec un code d'erreur
        }

        // Création de l'URL avec la clé API fournie par l'enseignant
        String omdbApiUrl = "http://www.omdbapi.com/?apikey=751ea6aa&t=" + args[0];

        // Création du client HTTP et de la requête GET
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(omdbApiUrl);

            // Exécution de la requête et affichage de la réponse
            try (CloseableHttpResponse response = client.execute(request)) {
                System.out.println("Executing request " + request.getRequestLine());
                System.out.println("Response Line: " + response.getStatusLine());
                System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

                // Récupérer le contenu JSON
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    try (InputStreamReader isr = new InputStreamReader(entity.getContent());
                         JsonReader jsonReader = Json.createReader(isr)) {

                        // Utiliser le parser JSON pour obtenir un objet JsonObject
                        JsonObject jsonObject = jsonReader.readObject();

                        // Accéder aux propriétés de l'objet JSON
                        String title = jsonObject.getString("Title");
                        String year = jsonObject.getString("Year");
                        String director = jsonObject.getString("Director");

                        // Afficher les informations du film
                        System.out.println("Informations du film :");
                        System.out.println("Titre : " + title);
                        System.out.println("Année : " + year);
                        System.out.println("Réalisateur : " + director);
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
