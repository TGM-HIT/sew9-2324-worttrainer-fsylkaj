package Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Repräsentiert die Logik des Worttrainer-Programms
 * @author Florian Sylkaj
 * @version 2023-10-02
 */
public class Worttrainer {
    private List<Wortpaar> wortpaare;
    private int richtigeWorte;
    private int falscheWorte;
    private String eingabeAktuell;
    private int indexWortpaarAktuell=0;
    /**
     * Konstruktor, der die Liste für die Wortpaare im Worttrainer initialisiert
     */
    public Worttrainer() {
        this.wortpaare= new LinkedList<>();
    }

    /**
     * Fügt ein Wortpaar zum Worttrainer hinzu
     * @param wortpaar Das hinzuzfügende Wortpaar
     */
    public void addWortpaar(Wortpaar wortpaar) {
        if(wortpaar!=null) {
            this.wortpaare.add(wortpaar);
        } else {
            throw new IllegalArgumentException("Wortpaar darf nicht null sein");
        }
    }

    /**
     * Gibt das Wortpaar an der jeweiligen Stelle zurück
     * @param i index des Wortpaares
     */
    public Wortpaar getWortpaar(int i) {
        if(i<= wortpaare.size()-1) {
            return this.wortpaare.get(i);
        } else {
            throw new IllegalArgumentException("Ungültiger Index");
        }
    }

    /**
     * Gibt den Index des Wortpaares, das gerade gewählt ist zurpück
     * @return der aktuelle Index des Wortpaares
     */
    public int getIndexAktuell(){
        return this.indexWortpaarAktuell;
    }

    /**
     * Gibt das aktuell gewählte Wortpaar zurück
     * @return Das aktuell gewählte Wortpaar
     */
    public Wortpaar getWortpaarAktuell() {
        return getWortpaar(indexWortpaarAktuell);
    }
    /**
     * Gibt die Anzahl der zu übenden Wörter zurück
     * @return Länge der Liste der gespeicherten Wortpaare
     */
    public int getAnzahlWortpaare() {
        return this.wortpaare.size();
    }

    /**
     * Liefert ein zufälliges Wortpaar aus der Liste an Wortpaaren
     * @return ein Wortpaar aus der Liste
     */
    public Wortpaar getRandomWortpaar() {
        Random rand = new Random();

        int min = 0;
        int max = this.wortpaare.size()-1;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        this.indexWortpaarAktuell=randomNum;
        return this.wortpaare.get(randomNum);
    }

    /**
     * Prüft ob die Eingabe mit dem Wort des aktuellen Woortpaares übereinstimmt. Wenn dies der Fall ist wird
     * die Statistik angepasst, dass heißt ein Punkt zur Anzahl der richtigen Wörter addiert. Wenn dies
     * nicht der Fall ist, wird ein Punkt zur Anzahl der falschen Wörter addiert.
     * @param wortpaarAktuell Das aktuelle ausgewählte Wortpaar
     * @return true, wenn die Eingabe korrekt ist, false im anderen Fall
     */
    public boolean pruefeEingabe(Wortpaar wortpaarAktuell) {
        if(this.eingabeAktuell.equals(wortpaarAktuell.getWord())){
            this.richtigeWorte++;
            return true;
        } else {
            this.falscheWorte++;
            return false;
        }
    }
    /**
     * Gibt die Liste an Wortpaaren zurück
     * @return die Liste an Wortpaaren
     */
    public List<Wortpaar> getWortpaarList() {
        return this.wortpaare;
    }
    /**
     * Gibt die gesamte Anzahl an angeübten Wortpaaren zurück
     * @return die Anzahl der richtigen und falschen Wörter gesamt
     */
    public int getGesamtstand() {
        return this.richtigeWorte + this.falscheWorte;
    }

    /**
     * Gibt den Index jenes Wortpaares aus der Liste an, welches gerade ausgewählt ist
     * @return die Anzahl der richtig geschriebenen Wörter
     */
    public int getRichtigeWorte() {
        return richtigeWorte;
    }

    public void setRichtigeWorte(int richtigeWorte) {
        this.richtigeWorte = richtigeWorte;
    }

    public int getFalscheWorte() {
        return falscheWorte;
    }

    public void setFalscheWorte(int falscheWorte) {
        this.falscheWorte = falscheWorte;
    }

    public String getEingabeAktuell() {
        return eingabeAktuell;
    }

    public void setEingabeAktuell(String eingabeAktuell) {
        if(eingabeAktuell!=null) {
            this.eingabeAktuell=eingabeAktuell;
        } else {
            throw new IllegalArgumentException("Eingabe darf nicht null sein");
        }
    }


}
