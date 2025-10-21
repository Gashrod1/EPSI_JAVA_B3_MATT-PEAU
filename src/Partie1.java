public class Partie1 {

    public enum Race {
        Humain(18),
        Split(3),
        Klackons(6),
        Klingon(12),
        Psilon(24),
        Boron(48);

        final int ageAdulte;

        Race(int ageAdulte) {
            this.ageAdulte = ageAdulte;
        }

        public boolean estMature(int age) {
            return age >= ageAdulte;
        }
    }

    public static class Creature {
         String nom;
         Race race;
         int age;

        public Creature() {
            this.nom = "PEAU";
            this.race = Race.Humain;
            this.age = 24;
        }

        public Creature(String nom, Race race, int age) {
            this.nom = nom;
            this.race = race;
            this.age = age;
        }

        public boolean isAdulte() {
            return race.estMature(age);
        }

        public void afficherInformations() {
            String adulteOuEnfant = isAdulte() ? "adulte" : "enfant";
            System.out.println("Mon nom est " + nom + ". Je suis un " + race + ". Je suis un " + adulteOuEnfant);
        }
    }
}
