package Controller;

import Model.Wortpaar;
import Model.Worttrainer;
import Persistenz.WorttrainerSpeicher;
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

    private WorttrainerSpeicher wSpeicher;
    /**
     * Initialisiert die View-Elemente sowie das Model
     */
    public WorttrainerController() {
        this.wPanel = new WorttrainerPanel(this);
        this.wFrame = new WorttrainerFrame("Worttrainer", this.wPanel);
        this.wSpeicher= new WorttrainerSpeicher(this.wModel);
        this.wModel=wSpeicher.load("Worttrainer.txt");
        this.wSpeicher= new WorttrainerSpeicher(this.wModel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.wModel.setEingabeAktuell(this.wPanel.getInpuText());
        if(e.getActionCommand().equals("end")) {
            this.wPanel.inputEnable(false);
            this.wPanel.enableButtonZuruecksetzen(false);
            this.wPanel.enableButtonEnd(false);
            this.wPanel.zeigeEndmeldung();
            this.wSpeicher.save("Worttrainer.txt");
        }
        if(e.getActionCommand().equals("reset")){
            this.wModel.setRichtigeWorte(0);
            this.wModel.setFalscheWorte(0);
            this.wPanel.setTextFalscheWoerter("0");
            this.wPanel.setTextRichtigeWoerter("0");
            this.wPanel.setTextGesamt("0");
        }
        if(e.getActionCommand().equals("eingabe")) {
            if (this.wModel.pruefeEingabe(wModel.getWortpaar(wModel.getIndexAktuell()))) {
                this.wPanel.setTextRichtigeWoerter(wModel.getRichtigeWorte() + "");
                this.wPanel.zeigeRichtigMeldung();
                this.wPanel.setTextGesamt(wModel.getGesamtstand() + "");
                this.wPanel.resetInput();
                this.wPanel.setUrl(wModel.getRandomWortpaar().getUrl());
            } else {
                this.wPanel.setTextFalscheWoerter(wModel.getFalscheWorte() + "");
                this.wPanel.zeigeFehlermeldung();
                this.wPanel.resetInput();
                this.wPanel.setTextGesamt(wModel.getGesamtstand() + "");
            }
        }

    }

    /**
     * Start-Punkt des Worttrainer-Programms
     */
    public static void main (String[] args) {
        WorttrainerController trainer = new WorttrainerController();
        trainer.wPanel.setUrl(trainer.wModel.getRandomWortpaar().getUrl());//Zu Beginn soll standardmäßig eine URL gesetzt
        trainer.wPanel.setTextRichtigeWoerter(trainer.wModel.getRichtigeWorte()+""); //Zu Beginn soll die Statistik geladen werden
        trainer.wPanel.setTextFalscheWoerter(trainer.wModel.getFalscheWorte()+"");
        trainer.wPanel.setTextGesamt(trainer.wModel.getGesamtstand()+"");
    }
}
