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
        if(this.wModel.pruefeEingabe(wModel.getWortpaar(wModel.getIndexAktuell()))) {
            this.wPanel.setTextRichtigeWoerter(wModel.getRichtigeWorte() + "");
            this.wPanel.zeigeRichtigMeldung();
            this.wPanel.setTextGesamt(wModel.getGesamtstand()+"");
            if(wModel.getIndexAktuell()==wModel.getAnzahlWortpaare()) {
                wPanel.zeigeEndmeldung();
                wPanel.inputEnable(false);
            } else {
                this.wPanel.resetInput();
                this.wPanel.setUrl(wModel.getWortpaarAktuell().getUrl());
            }
        } else {
            this.wPanel.setTextFalscheWoerter(wModel.getFalscheWorte()+"");
            this.wPanel.zeigeFehlermeldung();
            this.wPanel.resetInput();
            this.wPanel.setTextGesamt(wModel.getGesamtstand()+"");
        }

    }

    /**
     * Start-Punkt des Worttrainer-Programms
     */
    public static void main (String[] args) {
        WorttrainerController trainer= new WorttrainerController();
        System.out.println("Test");
        trainer.wModel.addWortpaar(new Wortpaar("Apfel", "https://media.istockphoto.com/id/184276818/de/foto/roter-apfel.jpg?s=612x612&w=0&k=20&c=HhxNnyYG6mUOA5bJUlDaoznzdIEtiJzQ5H73mG0ZAeU="));
        trainer.wModel.addWortpaar(new Wortpaar("Bus", "https://en.higer.com/uploadfiles/2021/01/20210120151022187.png?S0xRNjEyNUtBLnBuZw=="));
        trainer.wModel.addWortpaar(new Wortpaar("Hund", "https://www.zooplus.de/magazin/wp-content/uploads/2017/03/fotolia_66749097.jpg"));
        trainer.wModel.addWortpaar(new Wortpaar("Katze", "https://s1.1zoom.me/big0/292/Cats_White_background_Lying_down_Glance_566909_1280x864.jpg"));
        trainer.wModel.addWortpaar(new Wortpaar("Auto", "https://assets.adac.de/image/upload/c_scale,f_auto,q_auto,t_2:1-default,w_1500/v1/ADAC-eV/KOR/Bilder/PR/neuheiten-2023-audi-q8-etron-2212_kfqvtu"));
        trainer.wModel.addWortpaar(new Wortpaar("Zug", "https://imgl.krone.at/scaled/2259031/v5c8d45/full.jpg"));
        trainer.wPanel.setUrl(trainer.wModel.getWortpaar(0).getUrl()); //Erste URL des Panels standardmäßig setzen
    }
}
