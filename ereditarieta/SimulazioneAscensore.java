package ereditarieta;
import java.util.Random;

public class SimulazioneAscensore {
    public static void main(String[] args) {
        int secondi = 100;
        Random random = new Random();

        Ascensore ascensore = new Ascensore(0, 4); // Ascensore parte dal piano 0 con capienza 4
        Piano[] piani = new Piano[10];

        for (int i = 0; i < 10; i++) {
            piani[i] = new Piano(i);
        }

        System.out.println("\n=== STATO INIZIALE ===");
        System.out.println(ascensore);
        for (int i = 0; i < 10; i++) {
            System.out.println(piani[i]);
        }

        for (int t = 0; t < secondi; t++) {
            System.out.println("\n=== Secondo " + (t + 1) + " ===");

            // Generazione casuale di nuove persone
            if (random.nextBoolean()) { // Circa 50% di probabilità di generare una nuova persona
                int pianoPartenza = random.nextInt(10);
                int pianoDestinazione;
                do {
                    pianoDestinazione = random.nextInt(10);
                } while (pianoDestinazione == pianoPartenza); // Assicura che il piano di destinazione sia diverso

                Persona nuovaPersona = new Persona(t, pianoDestinazione);
                piani[pianoPartenza].aggiungiPersonaCoda(nuovaPersona);
                System.out.println("📌 Nuova persona al piano " + pianoPartenza + " con destinazione " + pianoDestinazione);
            }

            // Stato dei piani prima del movimento
            for (int i = 0; i < 10; i++) {
                System.out.println(piani[i]);
            }

            // Simulazione apertura porte, ingresso e uscita persone
            System.out.println("🚪 L'ascensore sta aprendo le porte al piano " + ascensore.getPianoCorrente());
            ascensore.apriPorte();
            System.out.println(ascensore);

            for (Persona p : piani[ascensore.getPianoCorrente()].getCoda()) {
                ascensore.aggiungiPersona(p);
                System.out.println("👤 Persona " + p.getId() + " è salita nell'ascensore con destinazione " + p.getPianoDestinazione());
            }
            piani[ascensore.getPianoCorrente()].getCoda().clear(); // Rimuove dalla coda chi è salito

            ascensore.rimuoviPersoneArrivate();
            System.out.println(ascensore);

            System.out.println("🚪 L'ascensore sta chiudendo le porte.");
            ascensore.chiudiPorte();
            System.out.println(ascensore);

            // Determinazione direzione e movimento
            ascensore.decidiDirezione();
            System.out.println("🔄 Stato dell'ascensore: " + ascensore);
        }

        System.out.println("\n=== SIMULAZIONE TERMINATA ===");
        System.out.println("📊 Stato finale dell'ascensore: " + ascensore);
        for (int i = 0; i < 10; i++) {
            System.out.println(piani[i]);
        }
    }
}