package ereditarieta;
import java.util.ArrayList;

public class Piano {
    private int numeroPiano;
    private ArrayList<Persona> codaPersone;

    public Piano(int numeroPiano) {
        this.numeroPiano = numeroPiano;
        this.codaPersone = new ArrayList<>();
    }

    public int getNumeroPiano() {
        return numeroPiano;
    }

    public ArrayList<Persona> getCoda() {
        return codaPersone;
    }

    public void aggiungiPersonaCoda(Persona p) {
        codaPersone.add(p);
    }

    public Persona rimuoviPersonaCoda() {
        if (!codaPersone.isEmpty()) {
            return codaPersone.remove(0);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Piano " + numeroPiano + " con " + codaPersone.size() + " persone in attesa.";
    }
}
