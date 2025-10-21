public class Main {
    public static void main(String[] args) {
        // Création du capitaine
        Partie2.Capitaine capitaine = new Partie2.Capitaine("Kirk", Partie1.Race.Humain, 35, 50);

        // Création du vaisseau
        Partie2.Vaisseau vaisseau = new Partie2.Vaisseau(capitaine, new java.util.ArrayList<>(), 5);

        // Création de passagers
        Partie1.Creature c1 = new Partie1.Creature("Spock", Partie1.Race.Klingon, 20);
        Partie1.Creature c2 = new Partie1.Creature();
        Partie1.Creature c3 = new Partie1.Creature("Zorg", Partie1.Race.Klackons, 7);
        Partie1.Creature c4 = new Partie1.Creature("TropJeune", Partie1.Race.Humain, 10);

        // Ajout de passagers
        System.out.println("\n=== Ajout des passagers ===");
        vaisseau.ajouterPassager(c1);
        vaisseau.ajouterPassager(c2);
        vaisseau.ajouterPassager(c3);
        vaisseau.ajouterPassager(c4);

        // Tentative d'ajout clandestin
        Partie1.Creature clandestin = new Partie1.Creature("Sneaky", Partie1.Race.Split, 5);
        System.out.println("\n=== Tentative d'ajout clandestin ===");
        vaisseau.ajouterPassagerClandestin(clandestin, 60); // pot-de-vin > niveau de corruption (ok)

        // Création du contrôleur
        Partie2.Controleur controleur = new Partie2.Controleur(Partie1.Race.Humain);

        // Vérification du vaisseau
        System.out.println("\n=== Vérification du vaisseau ===");
        boolean resultat = controleur.verifierVaisseau(vaisseau);
        System.out.println("\nRésultat de la vérification : " + (resultat ? "✅ Vaisseau validé" : "❌ Vaisseau refusé"));
    }
}
