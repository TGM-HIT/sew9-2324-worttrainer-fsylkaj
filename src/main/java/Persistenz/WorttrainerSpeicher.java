package Persistenz;

import Model.Wortpaar;
import Model.Worttrainer;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Ist für das Speichern und Laden des Worttrainers zustädnig
 * @author Florian Sylkaj
 * @version 2023-10-04
 */
public class WorttrainerSpeicher implements Speicher {
    /**
     * Speichert den aktuellen Zustand des Worttrainers, dazu zählen
     * die Wortpaare sowie die Statistik
     * @param filename Der Pfad des Files als Text
     */
    @Override
    public void save(String filename, Worttrainer trainer) {
        File f = new File(filename);
        PrintWriter outputstream = null;
        try {
            outputstream = new PrintWriter(f);
            for (int i = 0; i < trainer.getWortpaarList().size(); i++) {
                Wortpaar wAktuell = trainer.getWortpaar(i);
                outputstream.println(wAktuell.getWord());
                outputstream.println(wAktuell.getUrl());
            }
            outputstream.println(trainer.getRichtigeWorte());
            outputstream.println(trainer.getFalscheWorte());
            outputstream.println(trainer.getGesamtstand());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (outputstream != null) {
                outputstream.close();
            }
        }
    }

    /**
     * Lädt den Worttrainer aus dem Speicher und gibt den Zustand des Worttrainers
     * zurück.
     * @param filename Der Pfad des Files als Text
     * @return Der geladene Worttrainer
     */
    @Override
    public Worttrainer load(String filename) {
        Worttrainer t = new Worttrainer();
        try (Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
            //Solange  es eine nächste Zeile gibt und solange diese in dieser Zeile kein Int-Wert gibt
            while (s.hasNext() && !(s.hasNextInt())) {
                String wort = s.nextLine();
                String url = s.nextLine();
                Wortpaar wp= new Wortpaar(wort, url);
                t.addWortpaar(wp);
            }
            int richtigeWorte=0;
            int falscheWorte=0;
            richtigeWorte= s.nextInt();
            s.nextLine(); //Nächste Zeile
            falscheWorte= s.nextInt();
            t.setRichtigeWorte(richtigeWorte);
            t.setFalscheWorte(falscheWorte);
            return t;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
