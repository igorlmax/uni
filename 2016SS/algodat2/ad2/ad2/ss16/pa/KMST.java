package ad2.ss16.pa;

import java.util.*;

/**
 * Klasse zum Berechnen eines k-MST mittels Branch-and-Bound. Hier sollen Sie
 * Ihre L&ouml;sung implementieren.
 */
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

    private final HashSet<Edge> edges;
    private List<Edge> edges_sorted;
    private static int numNodes;
    private ArrayList<Edge>[] adj = (ArrayList<Edge>[]) new ArrayList[numNodes];
    private static int k;
    private static int lowerBound;


    public KMST(Integer numNodes, Integer numEdges, HashSet<Edge> edges, int k) {
        this.edges = edges;
        this.numNodes = numNodes;
        this.k = k;

    }

    private void prim(int start) {
        List<Edge> nachbar = new LinkedList<Edge>();

        for (Edge e : edges) {
            if (e.node1 == start || e.node2 == start) {
                if (!nachbar.contains(e)) {
                    nachbar.add(e);
                }
            }
        }
    }

    private void kruskal() {
        ArrayList<Edge> mst = new ArrayList<Edge>();
        int lowerBound = 0;

        for (Edge e : edges_sorted) {
            if (mst.size() == k-1) {
                for (Edge v : mst) {
                    lowerBound += v.weight;
                }

                this.lowerBound = lowerBound;
                return;
            }
            else {
                mst.add(e);
            }
        }
    }


    @Override
    public void run() {

        edges_sorted = new ArrayList<>(edges);
        Collections.sort(edges_sorted);
        kruskal();
        System.out.println(lowerBound);


        int[][] start_edges = new int[edges.size()][3];
        int i = 0;
        for (Edge r : edges_sorted) {
            start_edges[i][0] = r.node1;
            start_edges[i][1] = r.node2;
            start_edges[i][2] = r.weight;
            i++;
        }

        System.out.println(start_edges);


        for (int v = 0; v < edges.size(); v++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%5d ", start_edges[v][j]);
            }
            System.out.println();
        }

    }
}