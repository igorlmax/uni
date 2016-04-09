/******************************************************************************

 AUFGABENBLATT 2 - Allgemeine Informationen

 Das Projekt Aufgabenblatt2 besteht aus fünf Aufgaben in den Klassen Aufgabe1 
 bis Aufgabe5.

 Achten Sie bei der Implementierung von Aufgabe1-Aufgabe5 auf folgende Punkte:

 - Ihr Programm sollte kompilierbar und ausführbar sein.
 - Bei jeder Aufgabe finden Sie Zusatzfragen. Diese Zusatzfragen beziehen sich 
   thematisch auf das erstellte Programm. Sie sollten diese Zusatzfragen in der
   Übung beantworten können.
 - Verwenden Sie bei allen Ausgaben immer System.out.println().
 - Verwenden Sie für die Lösung der Aufgaben keine speziellen Aufrufe aus der 
   Java-API, die die Aufgaben verkürzen würden.

 Abgabe: Die Abgabe erfolgt durch Editieren bzw. Hochladen der java-Dateien in 
 Ihr Home-Verzeichnis bis zum angegebenen Termin.

 *****************************************************************************/
/*
    Aufgabe1) Typen und Typumwandlungen

    Erweitern Sie die main-Methode um folgende Funktionalität:
    - Deklarieren und initialisieren Sie je eine lokale Variable mit den Werten
          0xe, 030, 18L, 4.44e1, 55.5, 66e-1f, 7.7f, 'F'
      und sorgen Sie dafür, dass die Variablen dieselben Typen haben wie diese 
      Literale.
    - Erzeugen Sie durch Verwendung des Operators + einen String, der die Werte
     in den Variablen in der oben gegebenen
      Reihenfolge enthält, jeweils getrennt durch ", ". Geben Sie den String 
      mittels System.out.println(...) aus.
    - Berechnen Sie das ganzzahlige Produkt aller Werte in diesen Variablen, 
      wobei Nachkommastellen so früh wie möglich abgeschnitten werden. 
      Vermeiden Sie einen Überlauf des Ergebnisses. Geben Sie das Produkt 
      mittels System.out.println(...) aus.
    - Berechnen Sie die Summe aller Werte in diesen Variablen und wandeln Sie 
      das Ergebnis am Ende der Berechnung in eine ganze Zahl um. Geben Sie die 
      ganzzahlige Summe mittels System.out.println(...) aus.
    - Wandeln Sie jeden Wert in den Variablen in einen Wert vom Typ byte um und
      berechnen Sie die Summe der umgewandelten Werte. Geben Sie die Summe
      mittels System.out.println(...) aus.

    Zusatzfragen: 
    
    1. Wodurch erklären sich die Unterschiede zwischen den beiden
    berechneten Summen? 
    
    2. Warum ist der aus den Variablen erzeugte String nicht
    gleich der oben vorgegebenen Zeile mit Literalen? 
    
    3. Von welchem Typ ist der
    zuletzt ausgegebene Wert? 
    
    4. Wann wird ein Wert automatisch in einen Wert
    eines anderen Typs umgewandelt, wann benötigt man ein Cast? 
    
    5. Wieviel Speicher belegt ein Wert eines elementaren Typs mindestens (je 
    nach Typ)?
    
    6. Welchen Wertebereich kann ein elementarer Typ abdecken (je nach Typ)?
*/
public class Aufgabe1 {

    public static void main(String[] args) {
        int var1 = 0xe;
        int var2 = 030;
        long var3 = 18L;
        double var4 = 4.44e1;
        double var5 = 55.5;
        float var6 = 66e-1f;
        float var7 = 7.7f;
        char var8 = 'F';

        String string = var1 + ", " + var2 + ", " + var3 + ", " + var4 + ", " + var5 + ", " + var6 + ", " + var7 + ", " + var8;
        System.out.println(string);

        double produkt = var1*var2*var3*var4*var5*var6*var7*var8;
        System.out.println(produkt);
        long produktlong = (long) produkt;
        System.out.println(produktlong);


        double summe = var1 + var2 + var3 + var4 + var5 + var6 + var7 + var8;
        System.out.println(summe);
        int summeint = (int) summe;
        System.out.println(summeint);

        byte var1byte = (byte) var1;
        byte var2byte = (byte) var2;
        byte var3byte = (byte) var3;
        byte var4byte = (byte) var4;
        byte var5byte = (byte) var5;
        byte var6byte = (byte) var6;
        byte var7byte = (byte) var7;
        byte var8byte = (byte) var8;

        int summebyte = var1byte + var2byte + var3byte + var4byte + var5byte + var6byte + var7byte + var8byte;
        System.out.println(summebyte);
    }
}
