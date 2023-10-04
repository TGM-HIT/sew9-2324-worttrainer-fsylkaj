package View;

import Controller.WorttrainerController;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class WorttrainerPanel extends JPanel {
    /**
     * Diese Klasse erstellt das Layout für den Worttrainer
     * @author Florian Sylkaj
     * @version 2021-30-12
     */
    private JTextField textfeld;

    private JLabel lImage;
    private JLabel richtigeWoerter;
    private JLabel falscheWoerter;
    private JLabel anzahlWoerter;

    private JButton endButton;
    private String url="https://www.zooroyal.at/magazin/wp-content/uploads/2019/10/hund-im-herbst.jpg";

    public WorttrainerPanel(WorttrainerController wc) {
        this.setLayout(new BorderLayout());

        //Eingabe-Bereich
        JPanel input = new JPanel();
        input.setLayout(new GridLayout(2, 1, 5, 5));
        JLabel t = new JLabel(" Welches Wort wird unten dargestellt (Eingabe zum \u00dcberpr\u00fcfen)?  ");
        input.add(t);
        textfeld = new JTextField();
        textfeld.setActionCommand("eingabe");
        textfeld.addActionListener(wc);
        textfeld.setFont(new Font("", Font.PLAIN, 20));
        input.add(textfeld);
        this.add(input, BorderLayout.PAGE_START);

        //Bild-Bereich
        this.drawImage();

        //Menu

        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(4, 2, 5, 5));
        JLabel t1= new JLabel("Statistik");
        JLabel t2 = new JLabel("Richtige W\u00f6rter: ");
        JLabel t3 = new JLabel("Falsche W\u00f6rter: ");
        JLabel t4= new JLabel ("Ingesamt ge\u00fcbt:");
        richtigeWoerter = new JLabel("0", SwingConstants.CENTER);
        anzahlWoerter = new JLabel("0", SwingConstants.CENTER);
        falscheWoerter= new JLabel("0",SwingConstants.CENTER );
        menu.add(t1);
        endButton=new JButton("Speichern und beenden");
        endButton.setActionCommand("end");
        endButton.addActionListener(wc);
        menu.add(endButton);
        menu.add(t2);
        menu.add(richtigeWoerter);
        menu.add(t3);
        menu.add(falscheWoerter);
        menu.add(t4);
        menu.add(anzahlWoerter);

        this.add(menu, BorderLayout.PAGE_END);

    }
    /**
     * Setzt die URL
     */
    public void setUrl(String url) {
        this.url=url;
        this.drawImage(); //Wenn sich die URL geändert hat, Bild neu anzeigen
    }

    /**
     * Zeichnet das Bild mit der entsprechenden URL
     */
    public void drawImage() {
        // Entferne das aktuelle Bild, falls vorhanden
        if (lImage != null) {
            this.remove(lImage);
        }

        ImageIcon icon = null;
        try {
            icon = new ImageIcon(new URL(this.url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = icon.getImage(); // umwandeln in ein Image-Objekt
        image = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH); // skalieren auf gewünschte Größe
        lImage = new JLabel(new ImageIcon(image)); // anzeigen in einem JLabel
        this.add(lImage, BorderLayout.CENTER);
        revalidate(); // Aktualisiere das Panel, um die Änderungen zu übernehmen
        repaint(); // Erzwinge eine erneute Zeichnung des Panels
    }

    /**
     * Gibt den Text aus dem Eingabefeld zurück
     * @return Input des Users
     */
    public String getInpuText() {
        return this.textfeld.getText();
    }

    /**
     * Setzt den Text für die Anzeige der richtigen Wörter
     * @param text
     */
    public void setTextRichtigeWoerter(String text) {
        this.richtigeWoerter.setText(text);
    }
    /**
     * Setzt den Text für die Anzeige der falschen Wörter
     * @param text Der anzuzeigende Text
     */
    public void setTextFalscheWoerter(String text) {
        this.falscheWoerter.setText(text);
    }

    /**
     * Setzt den Text für die Anzahl der gesamten Wörter
     */
    public void setTextGesamt(String text) {
        this.anzahlWoerter.setText(text);
    }

    /**
     * Zeigt eine Nachricht an, in der steht, dass die Antwort richtig ist.
     */
    public void zeigeRichtigMeldung() {
        try {
            URL imageUrl = new URL("https://images.freeimages.com/clg/images/38/383687/green-checkmark-clip-art_f.jpg");

            ImageIcon icon = new ImageIcon(imageUrl);

            Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JOptionPane.showMessageDialog(
                    null,
                    "Die Antwort ist richtig! Bravo!",
                    "Richtige Antwort",
                    JOptionPane.INFORMATION_MESSAGE,
                    scaledIcon
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Zeigt eine Nachricht an, in der steht, dass die Antwort falsch ist und bittet den
     * User das Wort erneut zu erraten
     */
    public void zeigeFehlermeldung() {
        try {
            URL imageUrl = new URL("https://cdn.pixabay.com/photo/2012/04/13/00/14/cross-31176_1280.png");

            ImageIcon icon = new ImageIcon(imageUrl);

            Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JOptionPane.showMessageDialog(
                    null,
                    "Die Antwort ist falsch! Bitte versuche es noch ein Mal!",
                    "Falsche Antwort",
                    JOptionPane.INFORMATION_MESSAGE,
                    scaledIcon
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Leert den Inhalt im Textfeld
     */
    public void resetInput() {
        this.textfeld.setText("");
    }
    /**
     * Aktiviert oder deaktiviert das Eingabefeld
     * @param v true zum Aktivieren, false zum Deaktivieren
     */
    public void inputEnable(boolean v) {
        this.textfeld.setEnabled(v);
    }

    /**
     * Zeigt eine Meldung an, in der mittgeteilt wird, das die Trainingseinheit beendet ist
     */
    public void zeigeEndmeldung() {
        try {
            URL imageUrl = new URL("https://icon-library.com/images/end-icon/end-icon-2.jpg");

            ImageIcon icon = new ImageIcon(imageUrl);

            Image scaledImage = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JOptionPane.showMessageDialog(
                    null,
                    "Du bist am Ende der \u00dcbungseinheit angelangt! Bis bald!",
                    "Ende",
                    JOptionPane.INFORMATION_MESSAGE,
                    scaledIcon
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

