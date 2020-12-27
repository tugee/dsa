import java.util.*;

public class Cycles {
    int n;
    HashMap<Integer,ArrayList<Integer>> graph;
    HashSet<Integer> settled;
    ArrayList<Integer> considered;
    boolean cycle;
    
    public Cycles(int n) {  
        this.n = n;
        graph = new HashMap<>();
    }

    public void addEdge(int a, int b) {
        if(graph.get(a) == null){
            ArrayList<Integer> neighbours = new ArrayList<>();
            neighbours.add(b);
            graph.put(a,neighbours);
        } else {
            graph.get(a).add(b);
        }
    }

    public boolean check() {
        cycle = false;
        settled = new HashSet<>();
        
        considered = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
            if(!settled.contains(i)){
                dfs(i);
            }
        }
        return cycle;
    }
    
    public void dfs(int i){
        
        if(considered.contains(i)){
            cycle = true;
            return;
        }
        
        considered.add(i);
        
        if(graph.containsKey(i)){
            for(int neighbour : graph.get(i)){
                if(settled.contains(neighbour)) continue;
                dfs(neighbour);
            }
        }
        settled.add(i);
        considered.removeIf(n->(n==i));
        
    }

    public static void main(String[] args) {
        Cycles c = new Cycles(4);
        c.addEdge(1,2);
        c.addEdge(2,3);
        c.addEdge(1,3);
        c.addEdge(3,4);
        System.out.println(c.check()); // false
        c.addEdge(4,2);
        System.out.println(c.check()); // true
    }
}