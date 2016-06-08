/*
    Aufgabe2) Sortieren & Suchen

    Implementieren Sie in dieser Aufgabe in der gegebenen Klasse Aufgabe2
    folgende statische Methoden:

    - sort:       Diese Methode soll den Sortieralgorihtmus "QuickSort"
                  implementieren. Sie müssen den Sortieralgorithmus selbst
                  ausimplementieren und dürfen keinen entsprechenden Aufruf aus
                  der Java-API verwenden.

    - binSearch:  Dieser Methode wird ein sortiertes Array übergeben.
                  Zusätzlich erhält die Methode einen Wert nach dem gesucht
                  werden soll. Es soll eine binäre Suche implementiert werden,
                  die true zurückliefert falls das Element enthalten ist,
                  ansonsten false.

    [fortgeschritten]
    Implementieren Sie zusätzlich folgende statische Sortier-Methode
    "void sortAlternative(int[] array)", die folgende Funktionalität erfüllt:

    - Man beginnt mit dem Sortiervorgang an der Position i=1 und vergleicht in
      jedem Schritt den Wert an dieser Position mit seinem Vorgänger (i und i-1)

    - Sind die zwei Werte in der richtigen Reihenfolge aufsteigend sortiert,
      dann wird die Position um eins erhöht.

    - Sind die zwei Werte nicht in der richtigen Reihenfolge, dann werden sie
      vertauscht. Die Position wird um eins erniedrigt, falls i>1, ansonsten
      wird die Position um eins erhöht.

    - Der Algorithmus terminiert, wenn man an der letzten Position im Array
      ankommt und der Wert an dieser Position in der richtigen Reihenfolge ist.

    Zusatzfragen:
    1. Welche API-Aufrufe bietet Java für das Sortieren von Arrays an?

    2. Welcher Sortieralgorithmus wird in der Java (1.8) für das Sortieren von
       Arrays verwendet?

    3. Warum ist die Wahl des Pivot-Elements entscheidend für die Performance
       des Quicksort Algorithmus?

    4. Warum muss das Array für die binäre Suche sortiert sein?

    5. Wie geht man vor wenn man in einem absteigend sortierten Array die
       Binärsuche anwenden will?
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Aufgabe2 {

    public static void sort(int[] array) {
        quicksort(array, 0,array.length-1);
    }

    public static void quicksort(int[]array, int low, int high) {
        int i = low;
        int j = high;
        int pivot = array[(low + high) / 2];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (pivot < array[j]) {
                j--;
            }

            if (i <= j) {
                int h = array[i];
                array[i] = array[j];
                array[j] = h;

                i++;
                j--;
            }
        }

        if (low < i - 1) {
            quicksort(array, low, i - 1);
        }
        if (i < high) {
            quicksort(array, i, high);
        }
    }


    public static boolean binSearch(int[] array, int elem) {
        int first = 0;
        int last = array.length - 1;
        while (first <= last) {
            int current = (first + last) / 2;
            if (array[current] > elem) {
                last = current - 1;
            } else if (array[current] == elem) {
                return true;
            } else {
                first = current + 1;
            }
        }
        return false;
    }

    // just for testing ...
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    // just for testing ...
    public static void main(String[] args) {
        int[] myarray = new int[10];
        for(int i=0; i<myarray.length; i++){
            myarray[i] = (int)(Math.random()*100);
        }
        printArray(myarray);
        sort(myarray);
        printArray(myarray);

        System.out.println(binSearch(myarray, 114));

        myarray[3] = 114;
        printArray(myarray);
        System.out.println(binSearch(myarray, 114));

        sort(myarray);
        printArray(myarray);
        System.out.println(binSearch(myarray, 114));
    }
}
//////
/*
    Aufgabe1) Sortieren & Suchen

    Implementieren Sie in der gegebenen Klasse Aufgabe1 folgende statische
    Methoden:

    - sort:      Diese Methode soll den Sortieralgorithmus "QuickSort"
                 implementieren. Sie müssen den Sortieralgorithmus selbst
                 ausimplementieren und dürfen keinen entsprechenden Aufruf aus
                 der Java-API verwenden.
    - binSearch: Dieser Methode wird ein sortiertes Array übergeben. Zusätzlich
                 erhält die Methode einen Wert nach dem gesucht werden soll. Es
                 soll eine binäre Suche implementiert werden, die true
                 zurückliefert falls das Element enthalten ist, ansonsten false.
    - sortAlternative:
        + Methode beginnt mit dem Sortiervorgang an der Position i=1 und
          vergleicht in jedem Schritt den Wert an dieser Position mit seinem
          Vorgänger (i und i-1)
        + Sind die zwei Werte in der richtigen Reihenfolge aufsteigend sortiert,
          dann wird die Position um eins erhöht.
        + Sind die zwei Werte nicht in der richtigen Reihenfolge, dann werden
          sie vertauscht. Die Position wird um eins erniedrigt, falls i>1,
          ansonsten wird die Position um eins erhöht.
        + Der Algorithmus terminiert, wenn man an der letzten Position im Array
          ankommt und die letzten beiden Werte im Array richtig sortiert sind.

    Zusatzfragen:
    1. Welche API-Aufrufe bietet Java für das Sortieren von Arrays an?
    2. Welcher Sortieralgorithmus wird in Java (1.8) für das Sortieren von
       Arrays verwendet?
    3. Warum ist die Wahl des Pivot-Elements entscheidend für die Performance
       des Quicksort Algorithmus?
    4. Warum muss das Array für die binäre Suche sortiert sein?
    5. Wie geht man vor wenn man in einem absteigend sortierten Array die
       Binärsuche anwenden will?


public class Aufgabe1 {

    public static void sort(int[] array) {
        quicksort(array, 0,array.length-1);
    }

    public static void quicksort(int[]array, int low, int high) {
        int i = low;
        int j = high;
        int pivot = array[(low + high) / 2];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (pivot < array[j]) {
                j--;
            }

            if (i <= j) {
                int h = array[i];
                array[i] = array[j];
                array[j] = h;

                i++;
                j--;
            }
        }

        if (low < i - 1) {
            quicksort(array, low, i - 1);
        }
        if (i < high) {
            quicksort(array, i, high);
        }
    }

    public static boolean binSearch(int[] array, int elem) {
        int first = 0;
        int last = array.length - 1;
        while (first <= last) {
            int current = (first + last) / 2;
            if (array[current] > elem) {
                last = current - 1;
            } else if (array[current] == elem) {
                return true;
            } else {
                first = current + 1;
            }
        }
        return false;
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    // just for testing ...
    public static void main(String[] args) {

        int[] myarray = new int[10];
        for(int i=0; i<myarray.length; i++){
            myarray[i] = (int)(Math.random()*100);
        }
        printArray(myarray);
        sort(myarray);
        printArray(myarray);

        System.out.println(binSearch(myarray, 114));

        myarray[3] = 114;
        printArray(myarray);
        System.out.println(binSearch(myarray, 114));

        sort(myarray);
        printArray(myarray);
        System.out.println(binSearch(myarray, 114));
    }
}
*/