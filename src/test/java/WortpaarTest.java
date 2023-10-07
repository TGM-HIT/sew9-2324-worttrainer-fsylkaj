import Model.Wortpaar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Testet die Klasse Wortpaar
 * @author Florian Sylkaj
 * @version 2023-10-07
 */
public class WortpaarTest {
    @DisplayName("Testen ob ungültiges Wort erkannt wird")
    @Test
    public void testWort(){
        Wortpaar wp= new Wortpaar("wort","https://www.tgm.ac.at/");
        assertThrows(IllegalArgumentException.class, () ->{wp.setWord("");});
        assertThrows(IllegalArgumentException.class, () -> {wp.setWord(null);});
    }

    @DisplayName("Testen ob ungültige URL erkannt wird")
    @Test
    public void testUrl() {
        Wortpaar wp= new Wortpaar("wort", "https://www.tgm.ac.at/");
        assertThrows(IllegalArgumentException.class, () ->{wp.setUrl("");});
        assertThrows(IllegalArgumentException.class, () -> {wp.setUrl(null);});
        assertThrows(IllegalArgumentException.class, () -> {wp.setUrl("Url");});
    }
    @DisplayName("Testen ob check eines un/gültigen URL funktioniert")
    @Test
    public void testWordValidierung() {
        Wortpaar wp= new Wortpaar("wort", "https://www.tgm.ac.at/");
        assertTrue(wp.checkWord("Auto"));
        assertFalse(wp.checkWord(""));
        assertFalse(wp.checkWord(null));
    }

    @DisplayName("Testen ob check einer un/gültigen URL funktioniert")
    @Test
    public void testUrlValidierung() {
        Wortpaar wp= new Wortpaar("wort", "https://www.tgm.ac.at/");
        assertTrue(wp.checkURL("https://www.wienerlinien.at/"));
        assertFalse(wp.checkURL("wefgshdjkghljk"));
        assertFalse(wp.checkURL(null));
    }
}
