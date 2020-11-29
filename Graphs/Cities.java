import java.util.*;
 
public class Cities {
    int n;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] seen;
 
    public Cities(int n) {
        this.n = n;
        for (int i = 0; i <= n+1; i++) {
            graph.add(new ArrayList<>());
        }
    }
 
    public void addRoad(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
 
    void dfs(int x) {
        if (seen[x]) return;
        seen[x] = true;
        for (int y : graph.get(x)) {
            dfs(y);
        }
    }
 
    public boolean hasRoute(int a, int b) {
        seen = new boolean[n+1];
        dfs(a);
        return seen[b];
    }
}