package ad2.ss16.pa;

import java.util.*;

/**
 * Klasse zum Berechnen eines k-MST mittels Branch-and-Bound. Hier sollen Sie
 * Ihre L&ouml;sung implementieren.
 */
@SuppressWarnings({"all"})
public class KMST extends AbstractKMST {

    /**
     * Der Konstruktor. Hier ist die richtige Stelle f&uuml;r die
     * Initialisierung Ihrer Datenstrukturen.
     *
     * @param numNodes
     * Die Anzahl der Knoten
     * @param numEdges
     * Die Anzahl der Kanten
     * @param edges
     * Die Menge der Kanten
     * @param k
     * Die Anzahl der Knoten, die Ihr MST haben soll
     */

    private static HashSet<Edge> edges = new HashSet<>();
    private static int k;
    private static int numNodes;
    private static int numEdges;

    private boolean[] taken;

    public static HashSet<Edge> used = new HashSet<>();
    public static List<Edge> notused = new LinkedList<>();

    public int lowerBound = 0;


    public KMST(Integer numNodes, Integer numEdges, HashSet<Edge> edges, int k) {
        this.k = k;
        this.edges = edges;
        this.numNodes = numNodes;
        this.numEdges = numEdges;
        this.taken = new boolean[numNodes];
        Arrays.fill(taken, false);
    }

    private int weight(HashSet<Edge> MST) {
        int totalweight = 0;

        for (Edge e : MST) {
            totalweight += e.weight;
        }

        return totalweight;
    }







    @Override
    public void run() {
        // PRIM START
        int upperbound = Integer.MAX_VALUE;

        for (int i = 0; i < numNodes; i++) {
            if (weight(prim(i)) < upperbound) {
                setSolution(weight(prim(i)), prim(i));
            }
        }
        // PRIM FERTIG

        System.out.println(getSolution().getUpperBound());

    }






    public List<Edge> getNachbaren(int v) {
        List<Edge> nachbaren = new LinkedList<>();

        for (int i = 0; i < numNodes; i++) {
            for (Edge e : edges) {
                if ((e.node1 == v && e.node2 == i) ^ (e.node2 == v && e.node1 == i)) {
                    if (!nachbaren.contains(e)) {
                        nachbaren.add(e);
                    }
                }
            }
        }

        Collections.sort(nachbaren);
        return nachbaren;
    }

    public void BnB(HashSet<Edge> used, HashSet<Edge> notused, int start, List<Edge> nachbaren) {
        taken[start] = true;
        Collections.sort(nachbaren);

        while (used.size() <= k-1) {
            for (Edge e : nachbaren) {
                if ((taken[e.node1] ^ taken[e.node2]) && !notused.contains(e)) {
                    used.add(e);
                    for (Edge nachbarn : getNachbaren(e.node2)) {
                        if (!nachbaren.contains(nachbarn)) {
                            nachbaren.add(nachbarn);
                        }
                    }
                    Collections.sort(nachbaren);
                    if (weight(used) > lowerBound && weight(used) < getSolution().getUpperBound()) {
                        lowerBound = weight(used);
                        BnB(used, notused, e.node2, getNachbaren(e.node2));
                    }
                }
                else {
                    notused.add(e);
                }


            }

        }
    }


    public HashSet<Edge> prim(int start) {
        Arrays.fill(taken, false);
        taken[start] = true;
        HashSet<Edge> MST = new HashSet<>();
        MST.clear();

        List<Edge> sorted_edges = new ArrayList(edges);
        Collections.sort(sorted_edges);

        while (true) {
            for (Edge e : sorted_edges) {
                if (MST.size() >= k-1) {
                    return MST;
                }
                if ((taken[e.node1] ^ taken[e.node2])) {
                    if (!MST.contains(e)) {
                        MST.add(e);
                        if (!taken[e.node1] == true)
                            taken[e.node1] = true;
                        if (!taken[e.node2] == true)
                            taken[e.node2] = true;
                    }
                    else {
                        continue;
                    }
                }
                else {
                    continue;
                }
            }
        }
    }
}