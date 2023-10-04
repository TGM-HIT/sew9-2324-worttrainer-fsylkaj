package Persistenz;

import Model.Worttrainer;

/**
 * Markiert Klassen, die für die Speicherung zuständig sind
 * @author Florian Sylkaj
 * @veriosn 2023-10-04
 */
public interface Speicher {
    public void save(String filename);
    public Worttrainer load(String filename);
}
