public class Client1 {
    public static void main(String[] args) {
        // Vérification du nombre d'arguments
        if (args.length < 1) {
            System.out.println("Usage: java Client1 <arg1> [arg2] [arg3] ...");
            System.exit(1); // Quitter le programme avec un code d'erreur
        }

        // Récupération des arguments et traitement
        String arg1 = args[0];
        // ... Traiter d'autres arguments au besoin

        // Votre code ici

        // Exemple : Afficher les arguments
        System.out.println("Arguments fournis :");
        for (String arg : args) {
            System.out.println(arg);
        }

        // Fin de votre code
    }
}
