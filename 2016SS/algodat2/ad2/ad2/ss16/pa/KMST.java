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
	 *            Die Anzahl der Knoten
	 * @param numEdges
	 *            Die Anzahl der Kanten
	 * @param edges
	 *            Die Menge der Kanten
	 * @param k
	 *            Die Anzahl der Knoten, die Ihr MST haben soll
	 */

    private Object[] edges_sorted;
    private HashSet<Edge> edges = new HashSet<Edge>();
    private static int k;
    private Integer numNodes;
    private static int lowerBound;


	public KMST(Integer numNodes, Integer numEdges, HashSet<Edge> edges, int k) {
		this.edges = edges;
	}

    private int kruskal() {
        System.out.println(Arrays.toString(edges_sorted));
        HashSet<Object> mst = new HashSet<Object>();



        for (int i = 0; i < k;) {
            mst.add(edges_sorted[i]);
            i++;
            for (Object comp : mst) {
                if (edges_sorted[i].hashCode() == comp.hashCode()) {
                    mst.add(edges_sorted[i]);
                    i++;

                }
                else {
                    mst.add(edges_sorted[i]);
                    i += 2;
                }
            }
        }

        System.out.println(mst);

        return 0;
    }


	@Override
	public void run() {
		kruskal();
	}

}
