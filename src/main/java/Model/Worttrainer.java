package Model;

import java.util.LinkedList;
import java.util.List;

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
    public void getWortpaar(int i) {
        if(i<= wortpaare.size()-1) {
            this.wortpaare.get(i);
        } else {
            throw new IllegalArgumentException("Ungültiger Index");
        }
    }

    /**
     * Prüft ob die Eingabe mit dem Wort des Woortpaares übereinstimmt. Wenn dies der Fall ist wird
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
     * Gibt die gesamte Anzahl an angeübten Wortpaaren zurück
     * @return die Anzahl der richtigen und falschen Wörter gesamt
     */
    public int getGesamtstand() {
        return this.richtigeWorte + this.falscheWorte;
    }

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
        this.eingabeAktuell = eingabeAktuell;
    }
}
