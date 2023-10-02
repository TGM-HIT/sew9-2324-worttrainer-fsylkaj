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

    private String url;

    public WorttrainerPanel(WorttrainerController wc) {
        this.setLayout(new BorderLayout());

        //Eingabe-Bereich
        JPanel input = new JPanel();
        input.setLayout(new GridLayout(2, 1, 5, 5));
        JLabel t = new JLabel(" Welches Wort wird unten dargestellt (Eingabe zum \u00dcberpr\u00fcfen)?  ");
        input.add(t);
        textfeld = new JTextField();
        textfeld.addActionListener(wc);
        textfeld.setFont(new Font("", Font.PLAIN, 20));
        input.add(textfeld);
        this.add(input, BorderLayout.PAGE_START);

        //Bild-Bereich
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(new URL("https://www.pinclipart.com/picdir/middle/20-206356_wenn-hund-clipart.png"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = icon.getImage(); // umwandeln in ein Image-Objekt
        image = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH); // skalieren auf gewünschte Größe
        lImage = new JLabel(new ImageIcon(image)); // anzeigen in einem JLabel
        this.add(lImage, BorderLayout.CENTER);

        //Menu

        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(3, 2, 5, 5));
        JLabel t2 = new JLabel("Richtige W\u00f6rter: ");
        JLabel t3 = new JLabel("Falsche W\u00f6rter: ");
        JLabel t4= new JLabel ("Ingesamt ge\u00fcbt:");
        richtigeWoerter = new JLabel("0", SwingConstants.CENTER);
        anzahlWoerter = new JLabel("0", SwingConstants.CENTER);
        falscheWoerter= new JLabel("0",SwingConstants.CENTER );
        menu.add(t2);
        menu.add(richtigeWoerter);
        menu.add(t3);
        menu.add(falscheWoerter);
        menu.add(t4);
        menu.add(anzahlWoerter);
        this.add(menu, BorderLayout.PAGE_END);
    }

}

