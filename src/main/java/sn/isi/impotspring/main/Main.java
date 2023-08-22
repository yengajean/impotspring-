/*package sn.isi.samaneespring.main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class Main {

    // Méthode pour générer le hachage SHA-1 du mot de passe
    public static String hashWithSHA1(String input) {
        // Vérifier si l'algorithme SHA-1 est disponible
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = sha1.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Définir la propriété système pour le générateur de nombres aléatoires
        System.setProperty("java.security.egd", "file:/dev/urandom");

        // Générer le hachage SHA-1 du mot de passe
        String rawPassword = "motDePasseAEncoder";
        String hashedPassword = hashWithSHA1(rawPassword);

        // Afficher le résultat (vous devez l'enregistrer dans la base de données)
        System.out.println("Mot de passe en clair : " + rawPassword);
        System.out.println("Mot de passe crypté avec SHA-1 : " + hashedPassword);

        // Votre code ici...
    }
}
*/