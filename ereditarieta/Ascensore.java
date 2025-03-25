package ereditarieta;
import java.util.ArrayList;

public class Ascensore {
    private int pianoCorrente;
    private int capienzaMassima;
    private ArrayList<Persona> personeDentro;
    private boolean porteAperte;

    public Ascensore(int pianoCorrente, int capienzaMassima) {
        this.pianoCorrente = pianoCorrente;
        this.capienzaMassima = capienzaMassima;
        this.personeDentro = new ArrayList<>();
        this.porteAperte = false;
    }

    public int getPianoCorrente() {
        return pianoCorrente;
    }

    public boolean isPorteAperte() {
        return porteAperte;
    }

    public void apriPorte() {
        porteAperte = true;
    }

    public void chiudiPorte() {
        porteAperte = false;
    }

    public void aggiungiPersona(Persona p) {
        if (personeDentro.size() < capienzaMassima && porteAperte) {
            personeDentro.add(p);
            System.out.println("👤 Persona " + p.getId() + " è salita nell'ascensore.");
        }
    }

    public void rimuoviPersoneArrivate() {
        ArrayList<Persona> personeDaRimuovere = new ArrayList<>();
        for (Persona p : personeDentro) {
            if (p.getPianoDestinazione() == pianoCorrente) {
                personeDaRimuovere.add(p);
                System.out.println("👤 Persona " + p.getId() + " è scesa al piano " + pianoCorrente);
            }
        }
        personeDentro.removeAll(personeDaRimuovere);
    }

    public void salita() {
        if (pianoCorrente < 9) {
            pianoCorrente++;
        }
    }

    public void discesa() {
        if (pianoCorrente > 0) {
            pianoCorrente--;
        }
    }

    public void decidiDirezione() {
        if (pianoCorrente < 9) {
            salita();
        } else {
            discesa();
        }
    }

    @Override
    public String toString() {
        return "Ascensore al piano " + pianoCorrente + " con " + personeDentro.size() + " persone a bordo.";
    }

    public int getPianoDestinazione() {
        return 0;
    }
}
