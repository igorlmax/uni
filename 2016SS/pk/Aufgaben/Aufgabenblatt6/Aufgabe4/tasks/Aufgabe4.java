/*
    Aufgabe4) Interfaces

    Gegeben sind die Schnittstellen Movable, Copyable und ShapeOnPlane.
    ShapeOnPlane und Movable beziehen sich auf geometrische Objekte in einem
    2D-Koordinatensystem. Point ist großteils gegeben und repräsentiert einen
    2D-Punkt mit x- und y-Koordinaten. Ergänzen Sie die fehlenden Teile zu
    Point. Zusätzlich sind folgende Klassen gefragt:

    - Point ist ein Punkt in der Ebene und implementiert Movable.

    - Triangle repräsentiert ein Dreieck bestehend aus 3 Eckpunkten (Point).
      Ein Triangle-Objekt wird mit der Angabe von drei Point-Objekten erzeugt.
      Schreiben Sie einen entsprechenden Konstruktor.

    - Circle repräsentiert einen Kreis mit Mittelpunkt (Point) und radius
      (double). Ein Circle-Objekt wird mit der Angabe von einem Mittelpunkt
      (Point) und dem Radius (double) erzeugt. Schreiben Sie einen
      entsprechenden Konstruktor.

    - Triangle und Circle sollen ShapeOnPlane implementieren. Dies ist die
      gemeinsame Schnittstelle für geometrische Formen in der 2D-Ebene.
      Solche Objekte können verschoben werden (move) und haben einen Umfang
      (perimeter). Weiters können von diesen Objekten mit der parameterlosen
      Methode copy() unabhängige Kopien erzeugt werden. Nachfolgende Änderungen
      (z.B. durch move) des Originals haben keine Auswirkungen auf die Kopie
      und umgekehrt.

    - Triangle und Circle sollen über eine öffentliche parameterlose Methode
      toString() verfügen, die eine lesbare Repräsentation (als String) des
      Objekts zurückliefert. Zahlen sollen dabei mit zwei Nachkommastellen
      dargestellt werden. Siehe toString()-Methode in Point sowie die Testfälle
      in Aufgabe4.main(). Hinweis: toString() wird implizit aufgerufen, wenn
      ein Objekt vom Typ Triange, Circle, Point, ShapeOnPlane, etc. mit
      System.out.println() ausgegeben wird. Daher wird der Aufruf in den
      Beispielen in Aufgabe4.main() teilweise nicht explizit angegeben.

    [fortgeschritten]
    Definieren Sie ein Interface DoubleMatrix. Alle Objekte die DoubleMatrix
    sind, verfügen über eine parameterlose Methode toArray() die ein
    zwei-dimensionales Array mit double-Werten liefert. In jeder Zeile des
    Arrays stehen die Koordinaten eines Punktes, oder ein Array mit nur einem
    Element im Fall eines Skalars (zB. Radius). Point, Circle und Triangle
    sollen DoubleMatrix implementieren. Schreiben Sie weiters eine
    static-Methode print, die einen Parameter vom Typ DoubleMatrix hat und den
    Inhalt des double[][]-Arrays ausgibt. Die Form des Arrays und das Format
    der Ausgabe erkennen Sie an den Testfällen unter Aufgabe4.main().

    Sie können in dieser Aufgabe auch Methoden aus java.util.Arrays nutzen.

    Zusatzfragen:
    1. Wozu benötigt man Interfaces?

    2. Was bedeutet es, wenn ein Interface ein anderes Interface erweitert
       (extends)?

    3. Welche der folgenden Ausdrücke sind nach der Anweisung

            Movable point = new Point(1d,2d);

       gültig? Warum?

            point.distanceTo(new Point(0d,0d))
            point.move(0.5,1d)
            point.copy()
            point.toString()
*/

import java.util.Locale;

interface Movable {

    // Verschiebt das Objekt um den Vektor (deltaX, deltaY).
    void move(double deltaX, double deltaY);

}

interface Copyable {

    // Gibt eine unabhängige Kopie eines Objekts zurück.
    // Sollte von jedem Subtyp (inkl. abstrakter Subklassen)
    // deklariert/überschrieben werden.
    Copyable copy();

}

interface ShapeOnPlane extends Movable, Copyable {

    // Gibt den Umfang des Objekts zurück.
    double perimeter();
    ShapeOnPlane copy();

}

class Point /*TODO: add clause here*/ {

    private double x, y;

    public Point(double x, double y) {

        this.x = x;
        this.y = y;

    }

    public Point(Point p) {

        this.x = p.x;
        this.y = p.y;

    }

    public String toString() {

        return "(" + String.format("%.2f",x) + "," + String.format("%.2f",y) +
                ")";

    }

    public void move(double deltaX, double deltaY) {

        this.x += deltaX;
        this.y += deltaY;

    }

    public double distanceTo(Point p) {

        return Math.hypot(p.x - this.x, p.y - this.y);

    }

    public Point copy() {

        return null /*TODO: modify expression */ ;

    }

}



class Triangle /* TODO: add clause here */ {

    /* TODO: complete Triangle-class definition */

}

class Circle /* TODO: add clause here */ {

    /* TODO: complete Circle-class definition */

}



//just for testing
public class Aufgabe4 {

    public static void main(String[] args) {

        //Inhalt wird nicht bewertet
        Locale.setDefault(Locale.US);

        //entfernen Sie zum Testen die folgenden Kommentarzeichen.

        /*
        ShapeOnPlane shape = new Circle(new Point(2.5, -1.0), 1.0);
        System.out.println(shape.toString()); //[(2.50,-1.00),1.00]
        ShapeOnPlane copy = shape.copy();
        shape.move(1.0,1.5);
        System.out.println(shape); //[(3.50,0.50),1.00]
        System.out.println(copy); //[(2.50,-1.00),1.00]
        System.out.println(shape.perimeter()); //6.283185307179586
        System.out.println(copy.perimeter()); //6.283185307179586
        shape.move(1.0,1.5);
        System.out.println(shape); //[(4.50,2.00),1.00]
        shape = new Triangle(new Point(2.5, 1.0), new Point(-1.0,3.0), new Point(0d,0d));
        System.out.println(shape.perimeter()); //9.885988937884907
        System.out.println(shape); //[(2.50,1.00), (-1.00,3.00), (0.00,0.00)]
        */

        /*
        //folgende Testfälle funktionieren nur, wenn Sie die Aufgabe für
        //Fortgeschrittene gelöst haben.
        //[fortgeschritten]
        DoubleMatrix matrix = new Circle(new Point(2.5, -1.0), 1.0);
        print(matrix); //[[2.5, -1.0][1.0]]
        matrix = new Triangle(new Point(2.5, 1.0), new Point(-1.0,3.0), new Point(0d,0d));
        print(matrix); //[[2.5, 1.0][-1.0, 3.0][0.0, 0.0]]
        */

    }

    // [fortgeschritten]
    /*
    public static void print (DoubleMatrix dm) {
        // TODO: add lines here
    }
    */

}
///
/*
    Aufgabe2) Interfaces

    Gegeben sind die Interfaces Movable, Copyable und ShapeOnPlane.
    ShapeOnPlane und Movable beziehen sich auf geometrische Objekte in einem
    2D-Koordinatensystem. Es gibt eine Klasse Point welche einen
    2D-Punkt mit x- und y-Koordinaten repräsentiert. Ergänzen Sie die fehlenden
    Teile zu Point. Es sind folgende Klassen zu implementieren:

    - Point:    ist ein Punkt in der Ebene und implementiert Movable.
    - Triangle: repräsentiert ein Dreieck bestehend aus 3 Eckpunkten (Point).
                Ein Triangle-Objekt wird mit der Angabe von drei Point-Objekten
                erzeugt. Schreiben Sie einen entsprechenden Konstruktor.
    - Circle:   repräsentiert einen Kreis mit Mittelpunkt (Point) und
                radius (double). Ein Circle-Objekt wird mit der Angabe von einem
                Mittelpunkt (Point) und dem Radius (double) erzeugt. Schreiben
                Sie einen entsprechenden Konstruktor.

    Triangle und Circle sollen ShapeOnPlane implementieren. Dies ist die
    gemeinsame Schnittstelle für geometrische Formen in der 2D-Ebene. Solche
    Objekte können verschoben werden (move) und haben einen Umfang (perimeter).
    Weiters können von diesen Objekten mit der parameterlosen Methode copy()
    unabhängige Kopien erzeugt werden. Nachfolgende Änderungen (z.B. durch move)
    des Originals haben keine Auswirkungen auf die Kopie und umgekehrt.

    Triangle und Circle sollen über eine öffentliche parameterlose Methode
    toString() verfügen, die eine lesbare Repräsentation (als String) des
    Objekts zurückliefert. Zahlen sollen dabei mit zwei Nachkommastellen
    dargestellt werden. Siehe die toString()-Methode in Point sowie die
    Testfälle in Aufgabe2.main(). Hinweis: toString() wird implizit aufgerufen,
    wenn ein Objekt vom Typ Triange, Circle, Point, ShapeOnPlane, etc. mit
    System.out.println() ausgegeben wird. Daher wird der Aufruf in den
    Beispielen in Aufgabe2.main() teilweise nicht explizit angegeben.

    Definieren Sie zusätzlich ein Interface DoubleMatrix. Alle Objekte die
    DoubleMatrix sind, verfügen über eine parameterlose Methode toArray() die
    ein zwei-dimensionales Array mit double-Werten liefert. In jeder Zeile des
    Arrays stehen die Koordinaten eines Punktes, oder ein Array mit nur einem
    Element im Fall eines Skalars (z.B. Radius). Point, Circle und Triangle
    sollen DoubleMatrix implementieren. Schreiben Sie weiters eine
    static-Methode print, die einen Parameter vom Typ DoubleMatrix hat und den
    Inhalt des double[][]-Arrays ausgibt. Die Form des Arrays und das Format der
    Ausgabe erkennen Sie an den Testfällen unter Aufgabe2.main().

    Sie können in dieser Aufgabe auch Methoden aus java.util.Arrays nutzen.

    Zusatzfragen:
    1. Wozu benötigt man Interfaces?
    2. Was bedeutet es, wenn ein Interface ein anderes Interface erweitert
       (extends)?
    3. Welche der folgenden Ausdrücke sind nach der Anweisung
       Movable point = new Point(1d,2d);
       gültig? Warum?

        point.distanceTo(new Point(0d,0d))
        point.move(0.5,1d)
        point.copy()
        point.toString()
*/
import java.util.Arrays;

interface Movable {
    //shifts the object by the vector (deltaX, deltaY)
    public void move(double deltaX, double deltaY);
}

interface DoubleMatrix {
    /* TODO: add code here */
    double[][] toArray();
}

interface Copyable {
    //returns an independent copy of an object
    //should be declared or overridden by every subclass
    //(even by abstract subclasses)
    Copyable copy();
}

interface ShapeOnPlane extends Movable, Copyable {
    //returns the perimeter of the shape
    public double perimeter();
    public ShapeOnPlane copy();
}

class Point implements Movable, Copyable, DoubleMatrix /*TODO: add clause here*/ {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public String toString() {
        return "("+String.format("%.2f",x)+","+String.format("%.2f",y)+")";
    }

    public void move(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    public double distanceTo(Point p) {
        return Math.hypot(p.x - this.x, p.y - this.y);
    }

    public Point copy() {
        return new Point(x,y) /*TODO: modify expression */ ;
    }

    public double[][] toArray() {
        return new double[][] {{x,y}};
    }
}


class Triangle implements ShapeOnPlane, DoubleMatrix /* TODO: add clause here */ {

    /* TODO: complete Triangle-class definition */
    private Point[] vertices;

    public Triangle(Point a, Point b, Point c) {
        vertices = new Point[3];
        vertices[0] = a;
        vertices[1] = b;
        vertices[2] = c;
    }

    public String toString() {
        return Arrays.toString(vertices);
    }

    public double perimeter() {

        double peri = 0;
        for(int i = 0; i < 3; i++) {
            peri += vertices[i].distanceTo(vertices[(i+1)%3]);
        }
        return peri;
    }

    public Triangle copy() {
        return new Triangle(vertices[0].copy(), vertices[1].copy(),
                vertices[2].copy());
    }

    public void move(double deltaX, double deltaY) {

        for(Point p: vertices) {
            p.move(deltaX, deltaY);
        }
    }

    public double[][] toArray() {
        return new double[][] {vertices[0].toArray()[0],
                vertices[1].toArray()[0],
                vertices[2].toArray()[0]};
    }

}

class Circle implements ShapeOnPlane, DoubleMatrix /* TODO: add clause here */ {

    /* TODO: complete Triangle-class definition */
    private Point m;
    private double radius;

    public Circle(Point m, double radius) {
        this.m = m;
        this.radius = radius;
    }

    public String toString() {
        return "["+m+","+String.format("%.2f",radius)+"]";
    }

    public double perimeter() {
        return 2*radius*Math.PI;
    }

    public Circle copy() {
        return new Circle(m.copy(),radius);
    }

    public void move(double deltaX, double deltaY) {
        m.move(deltaX, deltaY);
    }

    public double[][] toArray() {
        return new double[][] {m.toArray()[0],{radius}};
    }
}

public class Aufgabe2 {

    public static void print (DoubleMatrix dm) {

        /* TODO: add lines here */
        System.out.print("[");

        for(double[] da: dm.toArray()) {
            System.out.print(Arrays.toString(da));
        }
        System.out.println("]");
    }

    // just for testing ...
    public static void main(String[] args) {

        //Entfernen Sie zum Testen die folgenden Kommentarzeichen.
        /*
        ShapeOnPlane shape = new Circle(new Point(2.5, -1.0), 1.0);
        System.out.println(shape.toString()); //[(2.50,-1.00),1.00]
        ShapeOnPlane copy = shape.copy();
        shape.move(1.0,1.5);
        System.out.println(shape); //[(3.50,0.50),1.00]
        System.out.println(copy); //[(2.50,-1.00),1.00]
        System.out.println(shape.perimeter()); //6.283185307179586
        System.out.println(copy.perimeter()); //6.283185307179586
        shape.move(1.0,1.5);
        System.out.println(shape); //[(4.50,2.00),1.00]
        shape = new Triangle(new Point(2.5, 1.0),
                             new Point(-1.0,3.0),
                             new Point(0d,0d));
        System.out.println(shape.perimeter()); //9.885988937884907
        System.out.println(shape); //[(2.50,1.00), (-1.00,3.00), (0.00,0.00)]
        DoubleMatrix matrix = new Circle(new Point(2.5, -1.0), 1.0);
        print(matrix); //[[2.5, -1.0][1.0]]
        matrix = new Triangle(new Point(2.5, 1.0),
                              new Point(-1.0,3.0),
                              new Point(0d,0d));
        print(matrix); //[[2.5, 1.0][-1.0, 3.0][0.0, 0.0]]
        */
    }
}