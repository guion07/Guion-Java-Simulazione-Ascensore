package ereditarieta;
import java.util.ArrayList;

public class Ascensore {
    private int pianoCorrente;
    private int capienzaMassima;
    private ArrayList<Persona> personeDentro;
    private boolean porteAperte;

    public Ascensore(int capienzaMassima){
        this.pianoCorrente = 1;
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

    public void apriPorte(){
        porteAperte = true;
            System.out.println("Le porte dell'ascensore sono aperte.");
    }

    public void chiudiPorte(){
        porteAperte = false;
        System.out.println("Le porte dell'ascensore sono chiuse");

    }

    public void aggiungiPersona(Persona p){
        if(personeDentro.size() < capienzaMassima){
            personeDentro.add(p);
            System.out.println("Persona" + p.getid() + "è entrata nell'ascensore.");
        }
        else{
            System.out.println("L'ascensore è pieno, la persona" + p.getid() + "non può entrare nell'ascensore.");
        }
    }
}
