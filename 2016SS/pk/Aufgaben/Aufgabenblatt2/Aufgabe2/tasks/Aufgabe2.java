/*
    Aufgabe2) Eingabe

    Erweitern Sie die main-Methode so, dass wiederholt Werte eingelesen werden,
    bis die Zahl 0 eingegeben
    wird. Dann wird das Programm beendet. Zuvor wird noch die Summe aller 
    eingelesenen Zahlen ausgegeben, falls alle eingelesenen Werte ganze Zahlen
    waren. In allen anderen Fällen wird nichts ausgegeben.

    Zusatzfragen:
    1. Warum muss eine ungültige Eingabe (keine ganze Zahl) aus dem
    Input-Stream entfernt werden?
    2. Woran kann man erkennen, dass ein eingelesener Wert eine ganze Zahl ist?
    3. Woran kann man feststellen, ob eine frühere Eingabe ungültig war?
*/

import java.util.Scanner;

public class Aufgabe2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int summe = 0;
        boolean allesInts = true;

        while (true) {
            try {
                int eingabe = scanner.nextInt();
                if (eingabe == 0) {
                    break;
                }
                else {
                    summe += eingabe;
                }
            } catch (Exception e) {
                allesInts = false;
                scanner.next();
                continue;
            }

        }

        if (allesInts == true) {
            System.out.println(summe);
        }
    }
}
