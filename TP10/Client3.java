import java.io.InputStreamReader;
import javax.json.*;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpGet;
import java.io.IOException;
import java.util.Scanner;

public class Client3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Entrez le titre du film (ou 'quit' pour quitter) : ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("quit")) {
                break;
            }

            String omdbApiUrl = "http://www.omdbapi.com/?apikey=751ea6aa&t=" + userInput;

            try (CloseableHttpClient client = HttpClients.createDefault()) {
                HttpGet request = new HttpGet(omdbApiUrl);

                try (CloseableHttpResponse response = client.execute(request)) {
                    System.out.println("Executing request " + request.getRequestLine());
                    System.out.println("Response Line: " + response.getStatusLine());
                    System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        try (InputStreamReader isr = new InputStreamReader(entity.getContent());
                             JsonReader jsonReader = Json.createReader(isr)) {

                            JsonObject jsonObject = jsonReader.readObject();

                            // Afficher les informations essentielles du film
                            System.out.println("Informations du film :");
                            System.out.println("Titre : " + jsonObject.getString("Title"));
                            System.out.println("Année : " + jsonObject.getString("Year"));
                            System.out.println("Réalisateur : " + jsonObject.getString("Director"));

                            // Afficher les acteurs principaux
                            System.out.println("Acteurs principaux : " + jsonObject.getString("Actors"));

                            // Afficher le score des critiques de Rotten Tomatoes
                            JsonArray ratingsArray = jsonObject.getJsonArray("Ratings");
                            for (int i = 0; i < ratingsArray.size(); i++) {
                                JsonObject ratingObject = ratingsArray.getJsonObject(i);
                                System.out.println("Source : " + ratingObject.getString("Source"));
                                System.out.println("Value : " + ratingObject.getString("Value"));
                                // Vérifier le score pour afficher la mention correspondante
                                checkAndDisplayRatingMention(ratingObject.getString("Value"));
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fin du programme.");
    }

    // Fonction pour vérifier le score et afficher la mention correspondante
    private static void checkAndDisplayRatingMention(String ratingValue) {
        // Extraire la partie numérique du score
        int score = Integer.parseInt(ratingValue.replaceAll("[^0-9]", ""));
        // Afficher la mention correspondante
        if (score < 20) {
            System.out.println("Mention : Nul");
        } else if (score >= 20 && score <= 50) {
            System.out.println("Mention : Bof");
        } else if (score > 50 && score <= 70) {
            System.out.println("Mention : Bien");
        } else {
            System.out.println("Mention : Très bien");
        }
    }
}
