package View;
import javax.swing.*;
import java.util.Locale;

/**
 * Stellt einen Rahmen für die Worttrainer-GUI zur Verfügung
 * @author Florian Sylkaj
 * @version 2023-09-30
 */
public class WorttrainerFrame extends JFrame {
    /**
     * Initialisiert den Rahmen für den Worttrainer im Zentrum des Bildschirms in minimaler
     * Größe
     * @param titel der Titel im Fenster
     * @param layoutPanel der Inhalt für das Fenster
     */
    public WorttrainerFrame(String titel, JPanel layoutPanel) {
        super(titel);
        Locale.setDefault(new Locale("de", "DE"));
        this.add(layoutPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
