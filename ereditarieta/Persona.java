package ereditarieta;
public class Persona {
    private int id;
    private int pianoDestinazione;

    public Persona(int id, int pianoDestinazione) {
        this.id = id;
        this.pianoDestinazione = pianoDestinazione;
    }

    public int getId() {
        return id;
    }

    public int getPianoDestinazione() {
        return pianoDestinazione;
    }

    public void saliSuAscensore(Ascensore a) {
        if (a.getPianoCorrente() == a.getPianoDestinazione() && a.isPorteAperte()) {
            a.aggiungiPersona(this);
        }
    }

    public void scendiDaAscensore(Ascensore a) {
        if (a.getPianoCorrente() == pianoDestinazione && a.isPorteAperte()) {
            a.rimuoviPersoneArrivate();
        }
    }

    @Override
    public String toString() {
        return "Persona " + id + " -> Piano " + pianoDestinazione;
    }
}
