/*
    Aufgabe4) Klammerung

    Implementieren Sie in Aufgabe4 eine statische Methode check, die
    einen String als Parameter hat und genau dann true zurückgibt,
    wenn der String einen korrekt geklammerten Ausdruck enthält. Ein
    Ausdruck ist dann korrekt geklammert, wenn es zu jeder öffnenden
    Klammer '(', '[' oder '{' eine entsprechende schließende Klammer
    ')', ']' oder '}' gibt. Zwischen diesen Zeichen können beliebige
    andere Zeichen vorkommen.

    Beispiele für korrekt geklammerte Ausdrücke: "", "a*[a+12]",
    "a+(b)-c", "a+{b+8+(b+c)}/a"

    Beispiele für nicht korrekt geklammerte Ausdrücke: "[", "(}",
    "a)[]", "([)]", "]["

    Verwenden Sie einen Stack zur Überprüfung der Klammerung:
    Durchlaufen Sie die Zeichen im String von vorne nach hinten und
    legen Sie jede öffnende Klammer, die Sie dabei finden, auf den
    Stack. Wenn Sie auf eine schließende Klammer stoßen, nehmen Sie
    das oberste Element vom Stack; bei korrekter Klammerung muss die
    schließende Klammer mit der Klammer vom Stack
    zusammenpassen. Andere Zeichen werden einfach ignoriert. Bei
    korrekter Klammerung muss der Stack am Ende leer sein.

    Hinweis: Sie können als Stack z.B. ein Objekt des Typs
    Deque<String> verwenden.

    [fortgeschritten]
    Überprüfen Sie zudem ob die Ausdrücke ansonsten wohlgeformt
    sind. Es sollen dabei Zahlen, Variablen (a-z) und die Operatoren
    +, -, * und / erlaubt sein, wobei auf jeder Seite eines Operators
    ein Operand (eine Zahl, eine Variable, oder ein Klammerausdruck)
    sein muss, und Operanden nicht unmittelbar nebeneinander stehen
    duerfen; Klammerausdrücke enthalten wohlgeformte Ausdrücke.
    Beispiele für wohlgeformte Ausdrücke siehe oben.

    Beispiele für wohl geklammerte aber nicht wohl geformte Ausdrücke
    sind: "a(12)", "a--b", "003+5", "5-()", "!"

    Zusatzfragen:

    1. Was versteht man unter dem LIFO-Prinzip?

    LIFO = Last In - First Out
    Wie ein Stapel Papier, auf den man immer nur ein Blatt Papier ganz oben
    drauflegen oder von oben runternehmen kann.

    2. Wie könnte man diese Aufgabe auch mit einem Array statt einem
       Stack lösen?  Welche Nachteile würden sich daraus ergeben?

    Man könnte die öffnenden Klammern auch in einem Array speichern,
    jedoch hat man hier das Problem, dass der Array jedes Mal neu
    aufgebaut werden müsste, da man ihm ja eine Größe als Parameter
    mitgeben muss und sich die Größe ständig ändert. Ein Stack wiederum
    kann "unendlich" lang wachsen und ist immer so groß wie die Anzahl
    der Elemente auf ihm.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Aufgabe4 {

    public static boolean check(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Character match;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.addFirst(c);
            }
            else if (c == ')' || c == ']' || c == '}') {
                match = stack.peek();
                if (c == ')' && match == '(') {
                    stack.poll();
                }
                else if (c == ']' && match == '[') {
                    stack.poll();
                }
                else if (c == '}' && match == '{') {
                    stack.poll();
                }
                else {
                    return false;
                }
            }
        }

        return true;

    }


    public static void main(String[] args) {
        System.out.println(check("a+{b+8+(b+c)}/a[((()[]{()}))]"));
    }
}
