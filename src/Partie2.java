import java.util.ArrayList;

public class Partie2 {
    public static class Capitaine extends Partie1.Creature {
        private int niveauPourCorrumption;

        public Capitaine(String nom, Partie1.Race race, int age, int niveauPourCorrumption) {
            super(nom, race, age);
            this.niveauPourCorrumption = niveauPourCorrumption;
        }

        @Override
        public void afficherInformations() {
            super.afficherInformations();
            System.out.println("Oh, et je suis un capitaine");
        }
    }

    public static class Vaisseau {
        private Capitaine capitaine;
        private ArrayList<Partie1.Creature> passagers;
        private int nbMaximumPassager;

        public Vaisseau() {
            this.capitaine = new Capitaine("Matt PEAU", Partie1.Race.HUMAIN, 42, 0);
            this.passagers = new ArrayList<>();
            this.nbMaximumPassager = 10;
        }

        public Vaisseau(Capitaine capitaine, ArrayList<Partie1.Creature> passagers, int nbMaximumPassager) {
            this.capitaine = capitaine;
            this.passagers = passagers;
            this.nbMaximumPassager = nbMaximumPassager;
        }

        public boolean ajouterPassager(Partie1.Creature creature) {
            if (passagers.size() < nbMaximumPassager) {
                passagers.add(creature);
                creature.afficherInformations();
                return true;
            } else {
                System.out.println("Désolé, le vaisseau est plein!");
                return false;
            }
        }

        public void ajouterPassagerClandestin(Partie1.Creature creature, int potDeVin) {
            if (potDeVin >= capitaine.niveauPourCorrumption) {
                passagers.add(creature);
            } else {
                System.out.println("Demande rejetée!");
            }
        }
    }

    public static class Controleur {
        private Partie1.Race race;

        public Controleur(Partie1.Race race) {
            this.race = race;
        }

        public boolean verifierVaisseau(Vaisseau vaisseau) {
            if (!vaisseau.capitaine.isAdulte()) {
                System.out.println("Le capitaine n'est pas un adulte!");
                return false;
            }

            if (vaisseau.passagers.size() > vaisseau.nbMaximumPassager) {
                System.out.println("Il y a trop de passagers!");
                return false;
            }

            int nbKlingons = 0;
            int nbKlackons = 0;
            int nbHumains = 0;

            for (Partie1.Creature passager : vaisseau.passagers) {

                if (passager.race == Partie1.Race.KLINGON) {
                    nbKlingons++;
                    if (this.race != Partie1.Race.KLINGON) {
                        System.out.println("Un Klingon détecté et le contrôleur n'est pas Klingon!");
                        return false;
                    }
                }

                if (passager.race == Partie1.Race.KLACKONS) {
                    nbKlackons++;
                    if (nbKlackons > 1) {
                        System.out.println("Il y a plus d'un Klackons!");
                        return false;
                    }
                }

                if (passager.race == Partie1.Race.HUMAIN) {
                    nbHumains++;
                }

                if ((passager.nom == "PEAU") && passager.race != Partie1.Race.HUMAIN)  {
                    System.out.println("Une créature non-humaine porte mon nom!");
                    return false;
                }
            }

            if (nbHumains % 2 != 0) {
                System.out.println("Le nombre d'humains est impair!");
                return false;
            }

        return true;
        }
    }
}
