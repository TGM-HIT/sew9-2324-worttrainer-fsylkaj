import Model.Wortpaar;
import Model.Worttrainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Testet die Logik des Worttrainers
 * @author Florian Sylkaj
 * @version 2023-
 */
public class WorttrainerTest  {
    @DisplayName("Test ob nur gültige Wortpaare hinzugefüt werden")
    @Test
    public void testAddWortpaar() {
       Worttrainer wt= new Worttrainer();
       assertThrows(IllegalArgumentException.class, () ->{wt.addWortpaar(null);});
    }

    @DisplayName("Test ob kein ungültiger Inde angegeben werden kann")
    @Test
    public void testInvalidIndexWortpaar() {
        Worttrainer wt= new Worttrainer();
        Wortpaar wp1= new Wortpaar("Hund", "https://www.stuttgarter-nachrichten.de/media.media.9ca6ab91-ea15-4a8b-ae48-4694e2a84006.original1024.jpg");
        Wortpaar wp2= new Wortpaar("Katze","https://media.os.fressnapf.com/cms/2020/05/Ratgeber-Katze-Gesundheit-KatzeWiese_1200x527.jpg?t=seoimg_937" );
        wt.addWortpaar(wp1);
        wt.addWortpaar(wp2);
        assertEquals(wp1,wt.getWortpaar(0));
        assertEquals(wp2, wt.getWortpaar(1));
        assertThrows(IllegalArgumentException.class, () -> {wt.getWortpaar(2);});
    }
    @DisplayName("Test ob nur gültige aktuelle zu vergleichende Eingaben gesetzt werden können")
    @Test
    public void testEingabeAktuellSetzen() {
        Worttrainer wt= new Worttrainer();
        Wortpaar wp1= new Wortpaar("Hund", "https://www.stuttgarter-nachrichten.de/media.media.9ca6ab91-ea15-4a8b-ae48-4694e2a84006.original1024.jpg");
        wt.addWortpaar(wp1);
        assertThrows(IllegalArgumentException.class, () -> {wt.setEingabeAktuell(null);});
    }

    @DisplayName("Test ob die Prüfung der Eingabe mit dem aktuellen Wort stimmt")
    @Test
    public void testEingabeUerbpruefung() {
        Worttrainer wt= new Worttrainer();
        Wortpaar wp1= new Wortpaar("Hund", "https://www.stuttgarter-nachrichten.de/media.media.9ca6ab91-ea15-4a8b-ae48-4694e2a84006.original1024.jpg");
        Wortpaar wp2= new Wortpaar("Katze","https://media.os.fressnapf.com/cms/2020/05/Ratgeber-Katze-Gesundheit-KatzeWiese_1200x527.jpg?t=seoimg_937" );
        wt.addWortpaar(wp1);
        wt.addWortpaar(wp2);
        //Falsche Eingabbe prüfen
        wt.setEingabeAktuell("Hond");
        assertFalse(wt.pruefeEingabe(wt.getWortpaar(0)));
        assertFalse(wt.pruefeEingabe(wt.getWortpaar(1)));
        wt.setEingabeAktuell("Hund");
        assertTrue(wt.pruefeEingabe(wt.getWortpaar(0)));
        wt.setEingabeAktuell("Katze");
        assertTrue(wt.pruefeEingabe(wt.getWortpaar(1)));
    }

    @DisplayName("Test ob die Statistik des Worttrainers richtig funktioniert")
    @Test
    public void testStatistikWorttrainer() {
        Worttrainer wt= new Worttrainer();
        Wortpaar wp1= new Wortpaar("Hund", "https://www.stuttgarter-nachrichten.de/media.media.9ca6ab91-ea15-4a8b-ae48-4694e2a84006.original1024.jpg");
        Wortpaar wp2= new Wortpaar("Katze","https://media.os.fressnapf.com/cms/2020/05/Ratgeber-Katze-Gesundheit-KatzeWiese_1200x527.jpg?t=seoimg_937" );
        wt.addWortpaar(wp1);
        wt.addWortpaar(wp2);
        wt.setEingabeAktuell("Hond");
        wt.pruefeEingabe(wt.getWortpaar(0));
        wt.setEingabeAktuell("Hund");
        wt.pruefeEingabe(wt.getWortpaar(0));
        wt.setEingabeAktuell("Katze");
        wt.pruefeEingabe(wt.getWortpaar(1));
        //Anzahl der falschen Wörter muss 1 in dem Fall 1 sein
        assertEquals(wt.getFalscheWorte(), 1);
        //Anzahl der richtigen Wörter indem Fall 2
        assertEquals(wt.getRichtigeWorte(),2);
        //Gesamtstand indem Fall 3
        assertEquals(wt.getGesamtstand(),3);

    }
}
