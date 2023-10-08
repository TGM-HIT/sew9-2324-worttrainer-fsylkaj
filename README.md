# Worttrainer 
## Allgemein
Der Worttrainer ist ein interaktives Rechtschreibtrainingstool, das speziell für Kinder entwickelt wurde. 
Die Anwendung ermöglicht es die Rechtschreibfähigkeiten auf spielerische Weise zu verbessern. Im Wesentlichen 
wird ein Bild angezeigt. Aufgabe ist es das passende Wort zu finden und dieses auch sprachnormisch richtig 
zu schreiben. Dieses Programm bezieht sich nur auf die deutsche Rechtschreibung.

## Verwendung 
Im Folgenden wird beschrieben wie das Rechtschreibübungsprogramm funktioniert 
1. Start des Worttrainer-Programms
2. Bild wird angezeigt 
3. Zugehörige Wort in das Eingabefeld eingeben 
4. Enter klicken 
5. Wort wird überprüft
6. Rückmeldung
   - Richtig geschrieben 
     - Nächstes Wortpaar ist an der Reihe
   - Falsch geschrieben
     - Dasselbe Wortpaar ist weiterhin gefragt, solange bis es richtig geschrieben wurde
7. Anpassung der Statistik

## Funktionen
Im Folgenden werden die Kernfunktionen, die dem User zur Verfügung stehen erläutert 
1. Wort eingeben
   - Es kann ein Wort in einem vorgesehenen Textfeld eingegeben werden
2. Eingabe absenden 
   - Die getätigte Eingabe kann mittels Enter an das Backend gesendet werden
3. Eingabe überprüfen
   - Die getätigte Eingabe kann auf Rechtschreibung überprüft werden
4. Worttrainer beenden 
   - Der Worttrainer kann durch Klick eines Buttons beendet werden
5.Statistik zurücksetzen 
   - Die Statistik kann auf den Ursprungszustand zurückgesetzt werden
__________________________________________________________________________
## Struktur
Das Programm ist in 4 wesentliche Teilbereich aufgeteilt. Das MVC-Pattern wurde angewedent und zusätzlich
wurde auch die Persistenz berücktsichtigt. Die Teilbereiche beinhalten folgende Klassen. 
- Model
  - Wortpaar 
  - Worttrainer
- View 
  - WorttrainerFrame
  - WortrainerPanel
- Controller
  - WorttrainerController
- Persistence
  - WorttrainerSpeicher 

### Model
Das Model setzt sich aus den Klassen Wortpaar und Worttrainer zusammen. Ein Wortpaar besteht aus einem 
Wort und einer URL. Diese URL verweist auf ein Bild, welches das entsprechende wort referenziert.<br>
Die Klasse Worttrainer bildet die Logik der Anwendung und speichert mehrere Wortpaare 
in einer Liste. Sie prüft die vom GUI-gesendeten Eingaben des Users und verwaltet die Statistik. Zum Worttrainer 
können auch jederzeit neue Wortpaare hinzugefügt werden. 


### View 
Die View setzt sich aus den Klassen WorttrainerFrame und WorttrainerPanel zusammen. Die Frame-Klasse
stellt einen Rahmen für die GUI zur Verfügung. Das eigentliche Design der GUI findet in der 
Klasse WorttrainerPanel statt. Diese verwendet ein Borderlayout. Im oberen Bereich gibt es ein Eingabefeld, mittig 
wird das Bild angezeigt. Ganz unten wird die Statistik tabellarisch mit hilfe eines GridLayout angezeigt. Zusätzlich 
gibt es nich einen Button zum Beenden und Speichern des Spielstands sowie eine Button zurücksetzen mit dem 
die bisher aufgezeichnete Statistik gelöscht werden kann. Zusätzlich beinhaltet das WorttrainerPanel auch 
Methoden, mit denen die URL sowie der anzuzeigende Text der Statistik bei Änderungen geändert werden kann.


### Persistence 
Die Wortpaare die der Worttrainer verwaltet, sowie die aktuelle Statistik des Trainings wird persistent in einem .txt-File
gespeichert. Das Speichern wird mittels PrintWriter umgesetzt. Im File sind zuerst die Wortpaare aufgelistet, also 
zuerst das Wort und die jeweilige URL. Nach allen Wörtern wird die anzahl der richtigen Versuche, die anzahl der 
falschen Versuche und der Gesamtstand der Versuche gespeichert. Der Aufbau des Textfiles sieht wie folgt aus: <br>
````
Apfel
https://images.eatsmarter.de/sites/default/files/styles/576x432/public/apfel-576x432.jpg
Kirsche
https://proto.gr/sites/www.proto.gr/files/styles/colorbox/public/images/fruits/cherries.jpg?itok=mDWbqXnf
4
5
9
````

Das Textfile kann demgemäß auch wieder geladen werden. Dazu kommt die Klasse Scanner zum Einsatz. Dabei werden 
die Wortpaare nach und nach eingelesen und zum Schluss noch die Statistik.

### Controller 
Die Klasse Worttrainer Controller enthält die Main-Methode und ist verantwortlich für die Steuerung 
des Programmflusses sowie für die Koordination zwischen dem Model und der View. Basierend auf den Benutzerinteraktionen 
aktualisiert sie das Model. Ändert sich etwas im Model wie zum Beispiel das ausgewählte Wortpaar oder 
die Anzahl der richtigen Wörter, so leitet der Controller dies an die View weiter. Des Weiteren wird der Worttrainer hier
auch zu Beginn der Ausführung der main-Methode geladen und zum Schluss gespeichert.
