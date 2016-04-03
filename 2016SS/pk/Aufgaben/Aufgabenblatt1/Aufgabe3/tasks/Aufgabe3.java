/*
Aufgabe3) Schleifen und Methoden

Erweitern Sie die Klasse "Aufgabe3" um die statische Methode
"isSumDiv", die Zahlen zwischen einem Intervall aufsummiert und prüft
ob diese Summe durch eine weitere Zahl teilbar ist.

- Der Methode werden zwei ganzzahlige Zahlen als Intervallgrenzen
  übergeben (beide Grenzen werden inklusive verwendet und start<end).

- Der Methode wird eine weitere ganzzahlige Zahl als Divisor übergeben.

- Die Methode liefert den boolschen Wert "true" zurück, falls die
  Summe aller Zahlen im Intervall durch den übergebenen Divisor
  teilbar ist, ansonsten "false".

Zusatzfragen:

1) Warum verwendet man im allgmeinen Methoden? Warum nicht alles
direkt in "main" programmieren?

2) Darf eine Methode mehr als eine return-Anweisung enthalten?
*/
public class Aufgabe3 {

    public static boolean isSumDiv(int start, int end, int divisor) {
        int sum = 0;

        if (start > end) {
            return false;
        }
        if (divisor == 0) {
            return false;
        }

        for (int i=start; i<=end; i++) {
            sum += i;
        }

        if (sum % divisor == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
      System.out.println(isSumDiv(6,1,1));
    }
}
