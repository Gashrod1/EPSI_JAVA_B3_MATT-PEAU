public class Main {
    public static void main(String[] args) {
        // --- Création du capitaine adulte ---
        Partie2.Capitaine capitaine = new Partie2.Capitaine("Jean-Luc", Partie1.Race.HUMAIN, 40, 50);

        // --- Création du vaisseau ---
        Partie2.Vaisseau vaisseau = new Partie2.Vaisseau(capitaine, new java.util.ArrayList<>(), 6);

        // --- Création de passagers valides ---
        Partie1.Creature humain1 = new Partie1.Creature("Alice", Partie1.Race.HUMAIN, 25);
        Partie1.Creature humain2 = new Partie1.Creature("Bob", Partie1.Race.HUMAIN, 30);
        Partie1.Creature klackon = new Partie1.Creature("Zorx", Partie1.Race.KLACKONS, 10);
        Partie1.Creature psilon = new Partie1.Creature("Mentor", Partie1.Race.PSILON, 30);

        // --- Ajout des passagers ---
        System.out.println("\n=== Ajout des passagers ===");
        vaisseau.ajouterPassager(humain1);
        vaisseau.ajouterPassager(humain2);
        vaisseau.ajouterPassager(klackon);
        vaisseau.ajouterPassager(psilon);

        // --- Création du contrôleur (Humain) ---
        Partie2.Controleur controleur = new Partie2.Controleur(Partie1.Race.HUMAIN);

        // --- Vérification du vaisseau ---
        System.out.println("\n=== Vérification du vaisseau ===");
        boolean resultat = controleur.verifierVaisseau(vaisseau);

        System.out.println("\nRésultat de la vérification : " + (resultat ? "✅ Vaisseau validé !" : "❌ Vaisseau refusé !"));
    }
}
