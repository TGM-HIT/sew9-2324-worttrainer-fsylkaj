package Model;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Repräsentiert ein Wortpaar. Dabei wird einem Wort der URL eines Bildes zugeordnet,
 * welches dieses Wort beschreibt
 * @author Florian Sylkaj
 * @version 2023-02-10
 */
public class Wortpaar {
    private String word;
    private String url;

    /**
     * Erzeugt ein Wortpaar
     *
     * @param word Das entsprechende Wort
     * @param url  Das entsprechende
     */
    public Wortpaar(String word, String url) {
        this.setWord(word);
        this.setUrl(url);
    }

    /**
     * Gibt das Wort zurück
     *
     * @return das Wort des Wortpaares
     */
    public String getWord() {
        return word;
    }

    /**
     * Setzt das wort sofern dieses auch gültig ist
     *
     * @param word
     */
    public void setWord(String word) {
        if (checkWord(word)) {
            this.word = word;
        } else {
            throw new IllegalArgumentException("Ungültiges Wort!");
        }
    }

    /**
     * Gibt die URL des Bildes für das Wort
     *
     * @return die URL des Wortpaares
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setzt die Url sofern diese auch syntaktisch korrekt ist
     *
     * @param url
     */
    public void setUrl(String url) {
        if (checkURL(url)) {
            this.url = url;
        } else {
            throw new IllegalArgumentException("Ungültige URL!");
        }
    }

    /**
     * Prüft die Gültigkeit des Wortes (ungleich null und kein Leerstring)
     *
     * @param word Das zu prüfende Wort
     * @return false, wenn das Wort ungültig ist, true im anderen Fall
     */
    public boolean checkWord(String word) {
        if (word != null && !word.equals("")) {
            return true;
        }
        return false;
    }

    /**
     * Prüft, ob die URL syntaktisch korrekt ist
     *
     * @param urltext die zu prüfende url als text
     * @return false, wenn URL ungültig ist, true im anderen Fall
     */
    public boolean checkURL(String urltext) {
        try {
            // Erstelle ein URL-Objekt aus der übergebenen Zeichenfolge
            URL url = new URL(urltext);
            // Überprüfe, ob die URL syntaktisch korrekt ist
            url.toURI();
            if (!isImage(urltext)) {
                String newURL = JOptionPane.showInputDialog(null, "Diese URL verweist leider auf kein Bild mehr! Bitte eine neue URL eingeben");
                checkURL(newURL);
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    boolean isImage(String image_path) {
        Image image = new ImageIcon(image_path).getImage();
        if (image.getWidth(null) == -1) {
            return false;
        } else {
            return true;
        }
    }
}