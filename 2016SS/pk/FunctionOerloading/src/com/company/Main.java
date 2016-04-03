package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Variablen für die Auswahl und den Scanner
        int choice;
        Scanner input = new Scanner(System.in);

        // Startet Loop, um Programm endlos auszuführen, bis User abbricht.
        while (true) {
            // Print menu
            menu();

            // Versuche input korrekt zu parsen
            try {
                choice = input.nextInt();

                // Wenn Auswahl == 1
                if (choice == 1) {

                    // Loop für Exceptions
                    while (true) {
                        System.out.print("Seitenlänge des Würfels: ");
                        try {
                            int s = input.nextInt();

                            // Function Overloading
                            System.out.println(volume(s));

                            // Warte 2s
                            try {
                                Thread.sleep(2000);
                            } catch(InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                            break;

                        // Falls input nicht erlaubt, frage nocheinmal
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Seitenlänge muss ein Integer sein!");
                            input.next();
                            continue;
                        }
                    }
                }

                // Wenn Auswahl == 2
                else if (choice == 2) {
                    while (true) {
                        System.out.print("Radius des Zylinders: ");
                        try {
                            double r = input.nextDouble();
                            System.out.print("Höhe des Zylinders: ");
                            double h = input.nextDouble();

                            // Function Overloading
                            System.out.println(volume(r, h));

                            try {
                                Thread.sleep(2000);
                            } catch(InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Eingaben müssen vom Typ Double sein!");
                            input.next();
                            continue;
                        }
                    }
                }

                // Wenn Auswahl == 3
                else if (choice == 3) {
                    while (true) {
                        System.out.print("Länge des Quaders: ");
                        try {
                            int l = input.nextInt();
                            System.out.print("Breite des Quaders: ");
                            int b = input.nextInt();
                            System.out.print("Höhe des Quaders: ");
                            int h = input.nextInt();

                            // Function Overloading
                            System.out.println(volume(l, b, h));

                            try {
                                Thread.sleep(2000);
                            } catch(InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Eingaben müssen vom Typ Integer sein!");
                            input.next();
                            continue;
                        }
                    }
                }

                // Wenn Auswahl == 4: exit
                else if (choice == 4) {
                    System.exit(0);
                }
            }
            // Falls input für die Auswahl nicht erlaubt, starte von Neuem
            catch (java.util.InputMismatchException e) {
                input.nextLine();
            }
        }


    }

    // Volume of a cube
    public static int volume(int s) {
        return s*s*s;
    }

    // Volume of a cylinder
    public static double volume(double r, double h) {
        return r*r*3.1415926*h;
    }

    // Volume of a cuboid
    public static int volume(int l, int b, int h) {
        return l*b*h;
    }

    // Menü
    public static void menu() {
            System.out.println("============================");
            System.out.println("|    Volumenberechnung     |");
            System.out.println("============================");
            System.out.println("| Options:                 |");
            System.out.println("|        1. Würfel 1       |");
            System.out.println("|        2. Zylinder 2     |");
            System.out.println("|        3. Quader 3       |");
            System.out.println("|        4. Exit 4         |");
            System.out.println("============================");
            System.out.print("Enter choice: ");
    }
}
