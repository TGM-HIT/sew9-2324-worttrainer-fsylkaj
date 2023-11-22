package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
        } catch (Exception e) {
            return false;
        }
        if (!isImage(urltext)) {
            JOptionPane.showMessageDialog(null, "Die URL fuer das anzuzeigende Bild ist nicht gueltig!!");
            throw new IllegalArgumentException("Die Bild-URL für das anzuzeigende Bild ist nicht gültig");
        }
        return true;
    }


    /**
     * Hilfsmethode, die überprüft ob sich sich bei der URL wirklich um
     * eine gültige Bilderurl handelt oder nicht
     * @param imageUrl die jeweilige URL, die zu überprüfen ist
     * @return true wenn imageURL gültig ist, false im anderen Fall
     */
    public boolean isImage(String imageUrl) {
        try{
            ImageIcon imageIcon = new ImageIcon(new URL(imageUrl));
            while(imageIcon.getImageLoadStatus()==MediaTracker.LOADING){
                Thread.sleep(500);
            }
            if(!(imageIcon.getImageLoadStatus()==MediaTracker.ABORTED || imageIcon.getImageLoadStatus()==MediaTracker.ERRORED)) return true;
        } catch (MalformedURLException e){
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}