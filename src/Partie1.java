public class Partie1 {

    public enum Race {
        HUMAIN(18),
        SPLIT(3),
        KLACKONS(6),
        KLINGON(12),
        PSILON(24),
        BORON(48);

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
            this.race = Race.HUMAIN;
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
