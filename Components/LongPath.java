
import java.util.*;

public class LongPath {
    int n;
    ArrayList<ArrayList<Integer>> graph;
    int[] color;
    boolean[] visited;
    int[] dp;
    int max;
    
    public LongPath(int n) {
        this.n = n;
        this.graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }    
    }

    public void addEdge(int a, int b) {
        int min = Math.min(a,b);
        graph.get(min).add(a+b-min);
    }

    public int calculate() {
        dp = new int[n+1];
        visited = new boolean[n+1];
        max = 0;
        
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                dfs(i);
            }
        }
        return max;
    }
    
    void dfs(int i){
        if(visited[i]) return;
        
        visited[i] = true;
        
        for(int child : graph.get(i)){
            dfs(child);
            dp[i] = Math.max( dp[child] + 1, dp[i]);
            max = Math.max(dp[i],max);
        }
    }

    public static void main(String[] args) {
        LongPath l = new LongPath(4);
        l.addEdge(1,2);
        l.addEdge(1,3);
        l.addEdge(2,4);
        l.addEdge(3,4);
        System.out.println(l.calculate()); // 2
        l.addEdge(3,2);
        System.out.println(l.calculate()); // 3
    }
}