package ad1.ss16.pa;

import java.util.*;

@SuppressWarnings({"unchecked", "deprecation"})

public class Network {


    private Map<Integer, List<Integer>> adj;

    public List<Integer> critical = new LinkedList<Integer>();
    private int time = 0;

    public boolean cyclic = false;

    private int[] disc;
    private int[] low;
    private int[] parent;

    private boolean[] marked;

    public int V;

    public Network(int n) {
        V = n;
        adj = new HashMap<Integer, List<Integer>>();


        for (int i = 0; i < n; i++) {
            adj.put(i, new LinkedList<Integer>());
        }

        marked = new boolean[V];
        disc = new int[V];
        low = new int[V];
        parent = new int[V];
    }

    public int numberOfNodes() {
        return V;
    }

    public int numberOfConnections() {
        int count = 0;

        for (Map.Entry<Integer, List<Integer>> key : adj.entrySet())
            count += key.getValue().size();

        return count/2;
    }

    public void addConnection(int v, int w){
        if (v!=w) {
            List<Integer> vlist = adj.get(v);
            if (!vlist.contains(w)) {
                List<Integer> wlist = adj.get(w);
                vlist.add(w);
                wlist.add(v);
            }
        }
    }

    public void addAllConnections(int v){
        for (int node = 0; node < V; node++) {
            addConnection(node, v);
        }
    }

    public void deleteConnection(int v, int w){
        List<Integer> vlist = adj.get(v);
        List<Integer> wlist = adj.get(w);

        if (vlist.contains(w) || wlist.contains(v)) {
            vlist.remove(Integer.valueOf(w));
            wlist.remove(Integer.valueOf(v));
        }
    }

    public void deleteAllConnections(int v){
        for (int node = 0; node < V; node++) {
            deleteConnection(node, v);
        }
    }

    public int numberOfComponents() {
        Arrays.fill(marked, false);
        int components = 0;

        for (Integer keys : adj.keySet()) {
            if (marked[keys] == false) {
                components++;
                dfs(keys);

            }
        }

        return components;
    }

    public boolean hasCycle() {
        Arrays.fill(marked, false);
        cyclic = false;



        for (Integer key : adj.keySet()) {

            if (!marked[key]) {
                dfs(key, key);
                if (cyclic == true) {
                    return cyclic;
                }

            }

        }

        return cyclic;
    }

    public int minimalNumberOfConnections(int start, int end){
        Queue q = new LinkedList<Integer>();
        int[] distance = new int[V];

        for (Integer key : adj.keySet()) {
            distance[key] = -1;
        }

        distance[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int current = (int) q.poll();

            if (current == end) {
                return distance[end];
            }

            for (Integer n : adj.get(current)) {
                if (distance[n] == -1) {
                    distance[n] = distance[current]+1;
                    q.add(n);
                }
            }
        }

        return distance[end];
    }

    public List<Integer> criticalNodes() {
        hasCycle();
        critical.clear();
        if (!cyclic && numberOfComponents() == 1) {
            for (Map.Entry<Integer, List<Integer>> key : adj.entrySet()) {
                if (key.getValue().size() > 1) {
                    if (!critical.contains(key.getKey())) {
                        critical.add(key.getKey());
                    }
                }
            }
            return critical;
        }

        Arrays.fill(marked, false);
        Arrays.fill(parent, -1);

        for (Integer key : adj.keySet()) {
            if (marked[key] == false) {
                dfscritical(key);
            }
        }

        return critical;
    }

    public void dfs(int v, int u) {
        marked[v] = true;

        for(Integer value : adj.get(v)) {
            if (!marked[value]) {
                dfs(value, v);
            }
            else if (value != u) {
                cyclic = true;
            }
        }
    }

    public void dfs(int v) {
        marked[v] = true;

        for (Integer value : adj.get(v)) {
            if (!marked[value]) {
                dfs(value);
            }
        }
    }

    public void dfscritical(int v) {
        int children = 0;
        marked[v] = true;
        disc[v] = low[v] = ++time;

        for (Integer u : adj.get(v)) {

            if (!marked[u]) {
                children++;
                parent[u] = v;
                dfscritical(u);
                low[v]  = Math.min(low[v], low[u]);

                if (parent[v] == -1 && children > 1)
                    if (!critical.contains(v))
                        critical.add(v);

                if (parent[v] != -1 && low[u] >= disc[v])
                    if (!critical.contains(v))
                        critical.add(v);
            }
            else if (u != parent[v])
                low[v]  = Math.min(low[v], disc[u]);
        }
    }
}



