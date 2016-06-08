/*******************************************************************************

 AUFGABENBLATT 6 für alle Übungsgruppen - Allgemeine Informationen

 Das Projekt Aufgabenblatt6 besteht aus fünf Aufgaben in den Klassen Aufgabe1
 bis Aufgabe5, die Sie erweitern müssen und die in der entsprechenden
 Übungseinheit behandelt werden.

 Die mit [fortgeschritten] markierten Beispiele und Fragen sind für
 die fortgeschrittenen Gruppen gedacht, dürfen aber natürlich auch von
 Teilnehmern anderer Gruppen gelöst werden, was als Übung hilfreich
 für die Ad-Hoc-Aufgaben und den Test sein könnte.  Die
 Ad-Hoc-Aufgaben für die fortgeschrittenen Gruppen sind eventuell
 anspruchsvoller, bei den Tests gibt es keinen Unterschied zwischen den
 fortgeschrittenen und den anderen Gruppen.

 Achten Sie bei der Implementierung von Aufgabe1 bis Aufgabe5 auf
 folgende Punkte:

 - Ändern Sie nur die Klassen Aufgabe1 bis Aufgabe5, lassen Sie alle anderen
   Klassen des Projekts unverändert.

 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen
   sich thematisch auf das erstellte Programm. Sie sollten diese Zusatzfragen
   in der Übung beantworten können.

 - Verwenden Sie zur Ausgabe immer System.out.println().

 - Verwenden Sie keine speziellen Aufrufe aus der Java-API, die die Aufgaben
   vereinfachen würden.

 Abgabe: Alle Änderungen am Projekt in der Übungsumgebung, die bis zum
 gegebenen Termin von Ihnen vorgenommen wurden, werden als Abgabe betrachtet.

 ******************************************************************************/

/*
    Aufgabe1) Listen

    In der Klasse IntList haben Sie eine Listenimplementierung gegeben.
    Dazu sollen Sie folgende zusätzliche Methoden implementieren:

    - search:   (iterativ) Sucht in der Liste nach einem übergebenen Wert.
                Wird der Wert gefunden, dann wird true zurückgeliefert.
                Ansonsten wird false zurückgeliefert. Diese Methode muss
                iterativ in der Klasse IntList implementiert werden.

    - reverseI: (iterativ) Dreht die Liste um. Die Methode muss iterativ
                implementiert werden. Die eigentliche Iteration sollte in der
                Klasse ListNode durchgeführt werden. Bei dieser Methode werden
                keine (!) neuen Knoten erzeugt und die Werte der Knoten dürfen
                nicht überschrieben werden. Die Umkehrung der Liste wird nur
                durch die Neuverkettung der vorhandenen Knoten erreicht!

    - reverseR: (rekursiv) Dreht die Liste um. Die Methode muss rekursiv
                implementiert werden. Die eigentliche Rekursion sollte in der
                Klasse ListNode durchgeführt werden. Bei dieser Methode werden
                keine (!) neuen Knoten erzeugt und die Werte der Knoten dürfen
                nicht überschrieben werden. Die Umkehrung der Liste wird nur
                durch die Neuverkettung der vorhandenen Knoten erreicht!

    - remove:   (iterativ) Entfernt aus der Liste einen übergebenen Wert,
                falls dieser vorhanden ist. Bei erfolgreichem Entfernen wird
                true zurückgegeben, ansonsten false.

    [fortgeschritten]
    Erweitern Sie ListNode um eine Membervariable "int prevSum" (previous sum),
    die die Summe aller vorherigen Elemente der Liste abspeichert, und diese
    bei Veränderung der Liste durch die oben angeführten Methoden wieder
    aktualisiert und anpasst. Der head-Knoten der Liste hat für prevSum den
    Wert 0 gespeichert.

    Zusatzfragen:
    1. Wie entsteht die Ausgabe beim Aufruf der Methode
       System.out.println(list);

    2. Warum ist es sinnvoll beim Iterieren durch Listen sich eine Kopie des
       Zeigers auf den "head"-Knoten zu erstellen?

    3. Erläutern Sie die Vor- und Nachteile von Listen gegenüber Arrays.
*/

class IntList {

    private class ListNode {
        int elem;
        ListNode next = null;

        ListNode(int elem, ListNode next) {
            this.elem = elem;
            this.next = next;
        }

        int getElem() {
            return this.elem;
        }

        ListNode getNext() {
            return this.next;
        }

        void add(int elem) {
            if (this.next == null) {
                this.next = new ListNode(elem, null);
            } else {
                this.next.add(elem);
            }
        }

        ListNode reverseI() {
            /* TODO: add code here */
        }

        ListNode reverseR() {
            /* TODO: add code here */
        }

        public String toString() {
            return this.elem + ((this.next == null) ? "-|" : "->" + this.next);
        }

    }

    private ListNode head = null;

    public boolean empty() {
        return this.head == null;
    }

    public void add(int elem) {
        if (this.empty()) {
            this.head = new ListNode(elem, null);
        } else {
            this.head.add(elem);
        }
    }

    public boolean search(int value) {
        /* TODO: add code here */
    }

    public boolean remove(int value) {
        /* TODO: add code here */
    }

    public int first() {
        return this.head.getElem();
    }

    public void reverseI() {
        /* TODO: add code here */
    }

    public void reverseR() {
        /* TODO: add code here */
    }

    public String toString() {
        return "[" + this.head + "]";
    }
}

public class Aufgabe1 {

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main wird nicht beurteilt
    }
}
///
public class IntList {

    private class ListNode {
        int elem;
        ListNode next = null;

        ListNode(int elem, ListNode next) {
            this.elem = elem;
            this.next = next;
        }

        int getElem() {
            return this.elem;
        }

        ListNode getNext() {
            return this.next;
        }

        void add(int elem) {
            if (this.next == null) {
                this.next = new ListNode(elem, null);
            } else {
                this.next.add(elem);
            }
        }

        ListNode reverseR() {
            if (this.next == null) {
                return this;
            }
            ListNode tail = this.next.reverseR();
            this.next.next = this;
            this.next = null;
            return tail;
        }

        public String toString() {
            return this.elem + ((this.next == null) ? "-|" : "->" + this.next);
        }

    }

    private ListNode head = null;

    public boolean empty() {
        return this.head == null;
    }

    public void add(int elem) {
        if (this.empty()) {
            this.head = new ListNode(elem, null);
        } else {
            this.head.add(elem);
        }
    }

    public boolean search(int value) {
        if (this.empty()) {
            return false;
        }
        for (ListNode node = this.head; node != null; node = node.getNext()) {
            if (node.getElem() == value) {
                return true;
            }
        }
        return false;
    }


    public int first() {
        return this.head.getElem();
    }

    public void reverseI() {
        ListNode prev = null;
        ListNode next = null;
        ListNode help = this.head;
        while (help != null) {
            next = help.next;
            help.next = prev;
            prev = help;
            help = next;
        }
        this.head = prev;
    }

    public void reverseR() {
        this.head = this.head.reverseR();
    }

    public String toString() {
        return "[" + this.head + "]";
    }
}
