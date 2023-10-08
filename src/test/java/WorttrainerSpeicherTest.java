import Model.Wortpaar;
import Model.Worttrainer;
import Persistenz.WorttrainerSpeicher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Testet die Speichern- und Lade Funktion des Worttrainers
 * @author Florian Sylkaj
 * @version 2023-10-08
 */
public class WorttrainerSpeicherTest {
    @DisplayName ("Test mithilfe eines Testfiles, ob der Worttrainer auch richtig geladen wird")
    @Test
    public void testLaden() {
        Worttrainer wt= new Worttrainer();
        WorttrainerSpeicher ws= new WorttrainerSpeicher(wt);
        wt= ws.load("testfile.txt");
        assertEquals("Apfel", wt.getWortpaar(0).getWord());
        assertEquals("https://images.eatsmarter.de/sites/default/files/styles/576x432/public/apfel-576x432.jpg", wt.getWortpaar(0).getUrl());
        assertEquals("Kirsche", wt.getWortpaar(1).getWord());
        assertEquals("https://proto.gr/sites/www.proto.gr/files/styles/colorbox/public/images/fruits/cherries.jpg?itok=mDWbqXnf", wt.getWortpaar(1).getUrl());
        assertEquals(4, wt.getRichtigeWorte());
        assertEquals(5, wt.getFalscheWorte());
    }

    @DisplayName("Testet ob der Worttrainer entsprechend gespeichert wird")
    @Test
    public void testSpeicherung() {
        Worttrainer wt= new Worttrainer();
        Wortpaar wp1= new Wortpaar("Hund", "https://www.stuttgarter-nachrichten.de/media.media.9ca6ab91-ea15-4a8b-ae48-4694e2a84006.original1024.jpg");
        Wortpaar wp2= new Wortpaar("Katze","https://media.os.fressnapf.com/cms/2020/05/Ratgeber-Katze-Gesundheit-KatzeWiese_1200x527.jpg?t=seoimg_937" );
        wt.addWortpaar(wp1);
        wt.addWortpaar(wp2);
        wt.setRichtigeWorte(5);
        wt.setFalscheWorte(4);
        WorttrainerSpeicher ws= new WorttrainerSpeicher(wt);
        assertDoesNotThrow(()-> ws.save("WorttrainerTest.txt"), "Ungültiger Pfad");
        Worttrainer wt2= null;
        wt2 = ws.load("WorttrainerTest.txt");
        //Testen ob geladene Elemente dem gespeicherten Worttrainer entsprechen
        assertEquals(wt.getWortpaar(0).getWord(), wt2.getWortpaar(0).getWord());
        assertEquals(wt.getWortpaar(0).getUrl(), wt2.getWortpaar(0).getUrl());
        assertEquals(wt.getWortpaar(1).getWord(), wt2.getWortpaar(1).getWord());
        assertEquals(wt.getWortpaar(1).getUrl(), wt2.getWortpaar(1).getUrl());
        assertEquals(wt.getRichtigeWorte(), wt2.getRichtigeWorte());
        assertEquals(wt.getFalscheWorte(), wt2.getFalscheWorte());
    }
}
