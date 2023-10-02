package Controller;

import Model.Wortpaar;
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
        this.wModel.setEingabeAktuell(this.wPanel.getInpuText());
        this.wModel.pruefeEingabe(wModel.getWortpaar(0));
        this.wPanel.setTextRichtigeWoerter(wModel.getRichtigeWorte()+"");
        this.wPanel.setTextFalscheWoerter(wModel.getFalscheWorte()+"");
        this.wPanel.setTextGesamt(wModel.getRichtigeWorte()+"");
    }

    /**
     * Start-Punkt des Worttrainer-Programms
     */
    public static void main (String[] args) {
        WorttrainerController trainer= new WorttrainerController();
        System.out.println("Test");
        Wortpaar wp= new Wortpaar("Apfel", "https://media.istockphoto.com/id/184276818/de/foto/roter-apfel.jpg?s=612x612&w=0&k=20&c=HhxNnyYG6mUOA5bJUlDaoznzdIEtiJzQ5H73mG0ZAeU=");
        trainer.wModel.addWortpaar(wp);
        trainer.wPanel.setUrl(wp.getUrl());
    }
}
