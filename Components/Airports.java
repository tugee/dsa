import java.util.*;

public class Airports {
    int n;
    HashMap<Integer, ArrayList<Integer>> graph;
    HashMap<Integer, ArrayList<Integer>> flippedGraph;
    ArrayList<Integer> topological;
    HashSet<Integer> settled;
    boolean[] visited;
    
    public Airports(int n) {
        this.n = n;
        this.graph = new HashMap<>();
        this.flippedGraph = new HashMap<>();
    }

    public void addLink(int a, int b) {
        
        if (graph.get(a) == null) {
            ArrayList<Integer> neighbours = new ArrayList<>();
            neighbours.add(b);
            graph.put(a, neighbours);
        } else {
            graph.get(a).add(b);
        }
        
        if (flippedGraph.get(b) == null) {
            ArrayList<Integer> neighbours = new ArrayList<>();
            neighbours.add(a);
            flippedGraph.put(b, neighbours);
        } else {
            flippedGraph.get(b).add(a);
        }
    }

    public boolean check() {
        topological = new ArrayList<>();
        this.visited = new boolean[n + 1];
        settled = new HashSet<>();
        System.out.println(graph.toString());
        for(int i = 1; i <=n; i++){
            if(!visited[i]){
                dfs(i);
            }
        }
        Collections.reverse(topological);
        System.out.println(topological);
        
        ArrayList<Integer> temp = topological;
        topological = new ArrayList<>();

        settled = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> tempG = graph;
        graph = flippedGraph;
        this.visited = new boolean[n + 1];
        System.out.println(temp.get(0));
        dfs(temp.get(0));
        graph = tempG;
        
        if(topological.size() != n){
            return false;
        }
        
        System.out.println(topological);
        return true;
    }
    
    public void dfs(int i){
        System.out.println(i);
        if(visited[i]) return;
        visited[i] = true;
        if(graph.containsKey(i)){
            for(int neighbour : graph.get(i)){
                if(settled.contains(neighbour)) continue;
                dfs(neighbour);
            }
        }
        settled.add(i);
        topological.add(i);
    }

    public static void main(String[] args) {
        Airports a = new Airports(5);
        a.addLink(3, 2);
        a.addLink(5, 3);
        a.addLink(5, 1);
        a.addLink(1, 5);
        a.addLink(2, 4);
        a.addLink(4, 1);
        a.addLink(4, 2);
        a.addLink(5, 1);
        a.addLink(5, 3);
        System.out.println(a.check());
    }
}