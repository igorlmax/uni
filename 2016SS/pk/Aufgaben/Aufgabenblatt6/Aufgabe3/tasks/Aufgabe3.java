/*
    Aufgabe3) Bäume

    In der Klasse IntTree haben Sie eine Baumimplementierung gegeben, die einen
    sortierten Binärbaum abbildet. Jede Veränderung des Baumes durch eine
    Methode muss gewährleisten, dass dieser sortiert bleibt. Dazu sollen Sie
    folgende zusätzliche Methoden implementieren:

    - countNodes:  Liefert die Anzahl der Knoten im Baum zurück. Wird ohne
                   Parameter auf dem Baum aufgerufen.

    - height:      Liefert die Höhe des Baumes zurück. Der leere Baum hat die
                   Höhe 0. Hat der Baum nur einen Knoten (Wurzel), dann hat er
                   die Höhe 1. Mit jeder zusätzlichen Stufe von Nachfolgern
                   erhöht sich die Höhe um 1. Der nachfolgend abgebildete Baum
                   hat die Höhe 4.

                                                 12
                                              /      \
                                            4         15
                                          /   \      /
                                         1     6   13
                                              /      \
                                             5        14

    - printLeaves:        Diese Methode gibt die Elemente der Blätterknoten aus,
                          wobei das linke Blatt immer vor dem rechten Blatt
                          ausgegeben wird.

    - printInOrderUp:     Diese Methode gibt alle Elemente in aufsteigender
                          Reihenfolge aus.

    - printInOrderUpSub:  Diese Methode gibt alle Elemente eines Teilbaums in
                          aufsteigender Reihenfolge aus. Dazu wird der Methode
                          ein Element übergeben, welches dem Wurzelknoten des
                          Teilbaums entspricht. Nun wird der komplette Teilbaum
                          inklusive Wurzel ausgegben.

    - printInOrderDown:   Diese Methode gibt alle Elemente in absteigender
                          Reihenfolge aus.

    - printPostOrder:     Diese Methode gibt alle Elemente in der sogenannten
                          Post-Order aus. Die Post-Order für den oben
                          abgebildeten Baum ergibt folgende Reihenfolge:

                              (1,5,6,4,14,13,15,12)

    - printPreOrder:      Diese Methode gibt alle Elemente in der sogenannten
                          Pre-Order aus. Die Pre-Order für den oben abgebildeten
                          Baum ergibt folgende Reihenfolge:

                              (12,4,1,6,5,15,13,14)

    - printLevelOrder:    Diese Methode gibt alle Elemente in der sogenannten
                          Level-Order aus. Die Level-Order bildet den Baum Level
                          für Level ab. Der oben stehende Baum produziert
                          folgende Ausgabe:

                                         12
                                         4 15
                                         1 6 13
                                         5 14

    [fortgeschritten]
    Implementieren Sie zusätzlich eine iterative Version "printInOrderUpIter",
    "printPostOrderIter" und "printLevelOrderIter" der obigen Methoden.

    Zusatzfragen:
    1. Falls die Elemente beim Einfügen in den Baum in ungünstiger Reihenfolge
       auftreten könnte im schlimmsten Fall ein entarteter Baum entstehen.
       Wie würde dieser für unser Beispiel in der Angabe aussehen?
*/

class IntTree {

    private class Node {

        int elem;
        Node left = null;
        Node right = null;

        Node(int elem) {
            this.elem = elem;
        }

        void add(int elem) {
            if (elem < this.elem) {
                if (this.left == null) {
                    this.left = new Node(elem);
                } else {
                    this.left.add(elem);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(elem);
                } else {
                    this.right.add(elem);
                }
            }
        }

        int countNodes() {
            /* TODO: add code here */
        }

        int height() {
            /* TODO: add code here */
        }

        void printLeaves() {
            /* TODO: add code here */
        }

        void printInOrderUp() {
            /* TODO: add code here */
        }

        void printInOrderUpSub(int elem) {
            /* TODO: add code here */
        }

        void printInOrderDown() {
            /* TODO: add code here */
        }

        void printPostOrder() {
            /* TODO: add code here */
        }

        void printPreOrder() {
            /* TODO: add code here */
        }

        void printLevelOrder(int level) {
            /* TODO: add code here */
        }
    }

    private Node root = null;

    public void add(int elem) {
        if (empty()) {
            this.root = new Node(elem);
        } else {
            this.root.add(elem);
        }
    }

    public boolean empty() {
        return this.root == null;
    }

    public int countNodes() {
        if (this.root == null) {
            return 0;
        }
        return this.root.countNodes();
    }

    public int height() {
        if (this.root == null) {
            return 0;
        }
        return this.root.height();
    }

    public void printLeaves() {
        if (this.root != null) {
            this.root.printLeaves();
        }
    }

    public void printInOrderUp() {
        if (this.root != null) {
            this.root.printInOrderUp();
        }
    }

    public void printInOrderUpSub(int elem) {
        if (this.root != null) {
            this.root.printInOrderUpSub(elem);
        }
    }

    public void printInOrderDown() {
        if (this.root != null) {
            this.root.printInOrderDown();
        }
    }

    public void printPostOrder(){
        if(this.root != null){
            this.root.printPostOrder();
        }
    }

    public void printPreOrder(){
        if(this.root != null){
            this.root.printPreOrder();
        }
    }

    public void printLevelOrder(){
        /* TODO: add code here */
    }
}

public class Aufgabe3 {

    // just for testing ...
    public static void main(String[] args) {
        // Implementierung von main wird nicht beurteilt

        // Entfernen Sie zum Testen die folgenden Kommentarzeichen.
        /*
        int [] mytestarray = new int[]{12,4,6,15,1,13,5,14};
        IntTree myTree = new IntTree();
        for(int i = 0; i < mytestarray.length; i++){
            myTree.add(mytestarray[i]);
        }
        System.out.println("Node Count*******");
        System.out.println(myTree.countNodes());
        System.out.println("Height***********");
        System.out.println(myTree.height());
        System.out.println("Leaves***********");
        myTree.printLeaves();
        System.out.println("InOrderDown******");
        myTree.printInOrderDown();
        System.out.println("InOrderUp********");
        myTree.printInOrderUp();
        System.out.println("InOrderSubUp*****");
        myTree.printInOrderUpSub(4);
        System.out.println("PostOrder********");
        myTree.printPostOrder();
        System.out.println("PreOrder*********");
        myTree.printPreOrder();
        System.out.println("LevelOrder*******");
        myTree.printLevelOrder();
        */
    }
}
////class IntTree {

private class Node {

    int elem;
    Node left = null;
    Node right = null;

    Node(int elem) {
        this.elem = elem;
    }

    void add(int elem) {
        if (elem < this.elem) {
            if (this.left == null) {
                this.left = new Node(elem);
            } else {
                this.left.add(elem);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(elem);
            } else {
                this.right.add(elem);
            }
        }
    }

    int countNodes() {
        int count = 0;
        if (this.left != null) {
            count += this.left.countNodes();
        }
        if (this.right != null) {
            count += this.right.countNodes();
        }
        return count + 1;
    }

    int countLeaves() {
        int count = 0;
        if (this.left != null) {
            count += this.left.countLeaves();
        }
        if (this.right != null) {
            count += this.right.countLeaves();
        }
        if(this.left == null && this.right == null) {
            count++;
        }
        return count;
    }

    int height() {
        int lcount = 0;
        int rcount = 0;
        if(this.left != null){
            lcount = this.left.height();
        }
        if(this.right != null){
            rcount = this.right.height();
        }
        return lcount > rcount ? lcount+1 : rcount+1;
    }

    void printLeaves() {
        if (this.left != null) {
            this.left.printLeaves();
        }
        if (this.right != null) {
            this.right.printLeaves();
        }
        if(this.left == null && this.right == null)
            System.out.println(this.elem);
    }

    void printInOrderUp() {
        if (this.left != null) {
            this.left.printInOrderUp();
        }
        System.out.println(this.elem);
        if (this.right != null) {
            this.right.printInOrderUp();
        }
    }

    void printInOrderUpSub(int elem) {
        if (this.elem  == elem) {
            this.printInOrderUp();
            return;
        }
        if (this.left != null) {
            this.left.printInOrderUpSub(elem);
        }
        if (this.right != null) {
            this.right.printInOrderUpSub(elem);
        }
    }

    void printInOrderDown() {
        if (this.right != null) {
            this.right.printInOrderDown();
        }
        System.out.println(this.elem);
        if (this.left != null) {
            this.left.printInOrderDown();
        }
    }
}

private Node root = null;

    public void add(int elem) {
        if (empty()) {
            this.root = new Node(elem);
        } else {
            this.root.add(elem);
        }
    }

    public boolean empty() {
        return this.root == null;
    }

    public int countNodes() {
        if (this.root == null) {
            return 0;
        }
        return this.root.countNodes();
    }

    public int countLeaves() {
        if (this.root == null) {
            return 0;
        }
        return this.root.countLeaves();
    }

    public int height() {
        if (this.root == null) {
            return 0;
        }
        return this.root.height();
    }

    public void printLeaves() {
        if (this.root != null) {
            this.root.printLeaves();
        }
    }

    public void printInOrderUp() {
        if (this.root != null) {
            this.root.printInOrderUp();
        }
    }

    public void printInOrderUpSub(int elem) {
        if (this.root != null) {
            this.root.printInOrderUpSub(elem);
        }
    }

    public void printInOrderDown() {
        if (this.root != null) {
            this.root.printInOrderDown();
        }
    }
}