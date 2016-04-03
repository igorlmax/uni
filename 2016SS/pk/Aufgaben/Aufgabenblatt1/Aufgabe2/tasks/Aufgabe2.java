import java.net.SocketPermission;

/*
Aufgabe2) Verzweigungen und Schleifen

Erweitern Sie die main-Methode um folgende Funktionalität:

- Schreiben Sie eine while-Schleife, die alle ungeraden, durch 7
  teilbaren Zahlen von 0-100 (inklusive) aufsummiert.

- Geben Sie das Ergebnis mit "System.out.println()" aus.

Zusatzfragen:

1) Man kann die Aufgabe lösen, indem man alle Zahlen von 1-100
   durchgeht, und mit einem if die aufsummiert, die die genannte
   Bedingung erfüllen, oder die Schleife so schreiben, dass die
   Laufvariable überhaupt nur die Werte annimmt, die die Bedingung
   erfüllen.  Wenn sie die erste Variante gemacht haben, probieren Sie
   noch die zweite, bzw. umgekehrt.  Welche Vor- und Nachteile haben
   die beiden Varianten?

2) Die Schleife summiert Werte zwischen 0 und 100. Wie könnten Sie das
   Programm umbauen damit die Schleife beliebige Intervalle
   aufsummiert?
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        int n = 100;
        int result = 0;

        while(n>0) {
            if (n % 2 == 1 && n % 7 == 0) {
                result += n;
                n -= 1;
            } else {
                n -= 1;
            }
        }
        System.out.println(result);
    }
}
