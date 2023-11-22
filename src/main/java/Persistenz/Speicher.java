package Persistenz;

import Model.Worttrainer;

/**
 * Markiert Klassen, die für die Speicherung zuständig sind
 * @author Florian Sylkaj
 * @version 2023-10-04
 */
public interface Speicher {
    /**
     * Methode für das Speichern
     * @param filename Der filename
     * @param t der Worttrainer
     */
    public void save(String filename, Worttrainer t);

    /**
     * Methode für das Laden
     * @param filename der Filenemae
     * @return der geladene Worttrainer
     */
    public Worttrainer load(String filename);
}
