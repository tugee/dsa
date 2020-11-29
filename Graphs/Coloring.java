
import java.util.*;

public class Coloring {
    int n;
    ArrayList<Integer>[] graph;
    boolean[] color;
    boolean[] seen;
    boolean able = true;
    int smallest;
    int seenCount;
    
    public Coloring(int n) {
        this.n = n;
        smallest = n;
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int a, int b) {
        if(a < smallest || b < smallest){
            smallest = Math.min(a,b);
        }
        if(!graph[a].contains(b)) graph[a].add(b);
        if(!graph[b].contains(a)) graph[b].add(a);
    }

    public boolean check() {
        color = new boolean[n+1];
        seen = new boolean[n+1];
        able = true;
        seenCount = 0;
        int smallest = 1;
        while(seenCount < n){
            dfs(smallest,false);
            for (int i = 1; i <= n; i++) {
                if (!seen[i]) {
                    smallest = i;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(seen));
        return able;
    }
    
    void dfs(int x, boolean col) {
        System.out.println(x + ", is blue: " + col + "==" + color[x] + ",seen: " + seen[x]);
        if (seen[x] && color[x]==col) {
            return;
        } else if(seen[x] && color[x] != col){
            System.out.println("Somethings wrong");
            able = false;
            return;
        }
        color[x] = col;
        seen[x] = true;
        seenCount++;
        for (int y : graph[(x)]) {
            dfs(y, !col);
        }
        System.out.println("finished and checking "+ x+";"+color[x]);
        System.out.println(Arrays.toString(seen));
    }
    
    public static void main(String[] args) {
        Coloring c = new Coloring(5);
        c.addEdge(4, 5);
        c.addEdge(3, 4);
        c.addEdge(2, 4);
        System.out.println(c.check());
    }
}