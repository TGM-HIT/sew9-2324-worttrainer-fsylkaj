package Controller;

import Model.Worttrainer;
import View.WorttrainerFrame;
import View.WorttrainerPanel;

import java.awt.event.*;

/**
 * Übernimmt die Steuerung des Worttrainer-Programms und stellt die
 * Verbindung zwischen Model und View her
 * @author Florian Sylkaj
 * @version 2023-09-30
 */
public class WorttrainerController implements ActionListener {
    private WorttrainerFrame wFrame;
    private WorttrainerPanel wPanel;
    private Worttrainer wModel;
    /**
     * Initialisiert die View-Elemente sowie das Model
     */
    public WorttrainerController() {
        this.wPanel = new WorttrainerPanel(this);
        this.wFrame = new WorttrainerFrame("Worttrainer", this.wPanel);
        this.wModel= new Worttrainer();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Start-Punkt des Worttrainer-Programms
     */
    public static void main (String[] args) {
        new WorttrainerController();
    }
}
