/*
Aufgabe4) Schleifen und Methoden

Erweitern Sie die Klasse "Aufgabe4" um die statische Methode
"calcCrossSum", die die Quersumme einer übergebenen Zahl berechnet.

- Der Methode wird ein positiver ganzzahliger Wert übergeben.

- Die Methode liefert das Ergebnis der Quersumme als ganzzahligen Wert
  zurück.

Zusatzfragen:

1) Welcher positiver ganzzahliger Wert muss der Methode übergeben
werden damit die höchstmögliche Quersumme berechnet wird?

*/
public class Aufgabe4 {

    public static int calcCrossSum(int zahl) {
        int quersumme = 0;
        int ziffer = 0;
        while (zahl != 0) {
            ziffer = zahl % 10;
            quersumme += ziffer;
            zahl = zahl / 10;
        }
        return quersumme;
    }

    public static void main(String[] args) {
        System.out.println(calcCrossSum(1999999999));

        int max = 0;

        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            if (calcCrossSum(i) > max) {
                max = calcCrossSum(i);
                System.out.println(i + ":" + max);
            }
        }
        System.out.println("Finished");
    }
}
