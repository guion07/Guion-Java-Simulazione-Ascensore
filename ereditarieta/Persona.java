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
        if (a.PorteAperte && a.getpianoCorrente() == this.getpianoDestinazione()) {
            System.out.println("Persona " + id + " è salita sull'ascensore al piano " + a.getpianoCorrente());
            a.aggiungiPersona(this);
        }
    }

    public void scendiDaAscensore(Ascensore a) {
        if (a.getpianoCorrente == pianoDestinazione) {
            System.out.println("Persona " + id + " è scesa dall'ascensore al piano " + pianoDestinazione);
            a.rimuoviPersoneArrivate();
        }
    }

    @Override

    public String toString(){
        return "Persona{id=" + id + ", pianoDestinazione=" + pianoDestinazione + "}";
    }
}