/**********************************************************************************************************************

 AUFGABENBLATT 5 für alle Übungsgruppen - Allgemeine Informationen

 Das Projekt Aufgabenblatt5 besteht aus fünf Aufgaben in den Klassen
 Aufgabe1 bis Aufgabe5, die Sie erweitern müssen und die in der
 entsprechenden Übungseinheit behandelt werden.

 Die mit [fortgeschritten] markierten Beispiele und Fragen sind für
 die fortgeschrittenen Gruppen gedacht, dürfen aber natürlich auch von
 Teilnehmern anderer Gruppen gelöst werden, was als Übung hilfreich
 für die Ad-Hoc-Aufgaben und den Test sein könnte.  Die
 Ad-Hoc-Aufgaben für die fortgeschrittenen Gruppen sind eventuell
 anspruchsvoller, bei den Tests gibt es keinen Unterschied zwischen den
 fortgeschrittenen und den anderen Gruppen.

 Achten Sie bei der Implementierung von Aufgabe1 bis Aufgabe5 auf
 folgende Punkte:
   
 - Ändern Sie Aufgabe1 bis Aufgabe5 entsprechend der Vorgaben.

 - Ihr Programm sollte sinnvolle Tests enthalten und bestehen.

 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen
   beziehen sich thematisch auf das erstellte Programm.  Sie sollten
   diese Zusatzfragen in der Übung beantworten können.

 - Verwenden Sie zur Ausgabe immer System.out.println().

 - Verwenden Sie keine speziellen Aufrufe aus der Java-API, die die
   Aufgaben vereinfachen würden.

 Abgabe: Alle Änderungen am Projekt in der Übungsumgebung, die bis zum
 gegebenen Termin von Ihnen vorgenommen wurden, werden als Abgabe
 betrachtet.

 ***********************************************************************************************************************/

/*
    Aufgabe1) Neue Uhrzeit

    Die Bewohner der fernen Insel Mirsanmir haben beschlossen, sich
    von der klassischen Uhrzeit zu verabschieden.  Stattdessen führen
    sie eine neue Uhrzeit ein, bei der ein Tag in 8 Achtel, ein Achtel
    in 100 Zentiachtel und ein Zentiachtel in 100 Ticks geteilt wird.

    Objekte der Klasse Aufgabe1 stellen eine Uhr für die neue Uhrzeit
    dar. Implementieren Sie folgende Methoden:

    - get: gibt die aktuelle Uhrzeit als String im Format "a.z.t"
    zurück, wobei a für die Achtel (0 bis 7), z für die Zentiachtel (0
    bis 99, ein oder zwei Stellen) und t für die Ticks (0 bis 99, ein
    oder zwei Stellen) steht.

    - inc:  erhöht die Uhrzeit um ein Tick

    - set: setzt die Uhrzeit auf das Achtel im ersten int-Parameter
    und Zentiachtel im zweiten int-Parameter; Tick wird dabei auf 0
    zurückgesetzt

    Es soll möglich sein, mehrere Uhren der Klasse Aufgabe1 zu
    erzeugen. Ein Konstruktor soll die Anfangszeit auf gleiche Weise
    wie die Methode set setzen. Der Konstruktor und die beschriebenen
    Methoden müssen von außerhalb der Klasse aufgerufen werden können,
    Variablen sollen von außerhalb der Klasse aber nicht direkt
    zugreifbar sein.

    [fortgeschritten]
    Erstellen Sie eine zusätzliche Klasse Datum. Implementieren Sie
    folgende Methoden:

    - get: gibt die aktuelle Datum als String im Format "d.m.j"
    zurück, wobei d für ein Tag, m Monat, j für Jahr steht. Monat und
    Jahr sind wie im gregorianischen Kalender zu implementieren.

    - inc: erhöht das Datum um einen Tag. 29. Februar gibt es nur dann
    wenn:

      - das Jahr durch 4 ganzzahlig teilbar ist.

      - es aber nicht durch 100 ganzzahlig teilbar ist (Ausnahme:
    durch 400 ganzzahlig teilbar).

    - set: setzt das Datum mit drei int-Parameter. Verändert das Datum
    nicht, wenn es ungültig werden würde (z.b. 32.8 oder 29.2.2001).

    Zusatzfragen:
    1. Welche Zwecke haben Objekte und Klassen?
    2. Wie unterscheiden sich Objekte von Klassen?
    3. Wird in dieser Aufgabe Datenkapselung verwendet?
    4. Welchen Sinn hat Datenkapselung generell und speziell in dieser Aufgabe?
    5. Wird in dieser Aufgabe Data-Hiding verwendet?
    6. Welchen Sinn hat Data-Hiding generell und speziell in dieser Aufgabe?
    7. [fortgeschritten] Wie könnte eine Methode aussehen, die eine
    Darstellung des Datums und Uhrzeit in konventioneller Form
    zurückgibt?

*/
public class Aufgabe1 {

    private int a = 0;
    private int z = 0;
    private int t = 0;

    public Aufgabe1(int achtel, int zentiachtel) {
        set(achtel, zentiachtel);
    }

    private void set(int a, int z) {
        if (a >= 0 && a < 8)
            this.a = a;
        else return;

        if (z >= 0 && z < 100)
            this.z = z;
        else return;

        t = 0;
    }

    private String get() {
        return a + "." + z + "." + t;
    }

    private void inc() {
        if (t+1 > 99) {
            z++;
            t = 0;
            if (z > 99) {
                a++;
                z = 0;
                if (a > 7) {
                    a = 0;
                    z = 0;
                    t = 0;
                }
            }
        }
        else {
            t++;
        }
    }

    // just for testing ...
    public static void main(String[] args) {
        Aufgabe1 bar = new Aufgabe1(0, 30);
        System.out.println(bar.get());
        bar.set(4, 50);
        System.out.println(bar.get());

        Aufgabe1 foo = new Aufgabe1(1, 98);
        System.out.println(foo.get());
        foo.inc();
        System.out.println(foo.get());
    }
}
