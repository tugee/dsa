import java.util.*;

public class Ball {
    int[][] graph;
    boolean[] visited;
    int n;
    boolean found;
    int l;
    ArrayDeque<Integer> path;
    
    public Ball(int n) {
        this.n = n;
        graph = new int[2*n+2][2*n+2];
    }

    public void addPair(int a, int b) {
        graph[0][a] = 1;
        graph[a][b+n]=1;
        graph[b+n][2*n+1] = 1;
    }

    public int calculate() {
        int maxFlow = 0;
        int[][] temp = Arrays.stream(graph).map(int[]::clone).toArray(int[][]::new);;
        while (true) {
            int max = flow(0, 2*n+1);
            maxFlow += max;
            if (!found) {
                break;
            }
        }
        graph = temp;
        System.out.println(Arrays.deepToString(graph));
        return maxFlow;
    }

    public int flow(int a, int b) {
        path = new ArrayDeque<>();
        visited = new boolean[2*n + 2];
        found = false;
        l = 0;
        
        dfs(a, b);
        System.out.println(path.toString());
        
        int minWeight = 1000000;
        int prev = 0;
        for (int n : path) {
            if (prev != 0) {
                minWeight = Math.min(minWeight, graph[prev][n]);
            }
            prev = n;
        }

        prev = -1;
        for (int n : path) {
            if (prev != -1) {
                graph[prev][n] -= minWeight;
                graph[n][prev] += minWeight;
            }
            prev = n;
        }
        
        return found ? 1 : 0;
    }

    void dfs(int x, int z) {
        if (visited[x]) {
            return;
        }
        visited[x] = true;
        l++;

        if (!found) {
            path.addLast(x);
        }
        if (x == z && !found) {
            found = true;
        }
        for (int i = 1; i <= 2*n+1; i++) {
            if (graph[x][i] > 0) {

                dfs(i, z);
            }
        }
        if (!found) {
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Ball b = new Ball(5);
        b.addPair(3, 1);
        System.out.println(b.calculate());
        b.addPair(2, 3);
        System.out.println(b.calculate());
        System.out.println(b.calculate());
        System.out.println(b.calculate());
        System.out.println(b.calculate());
        System.out.println(b.calculate());
        b.addPair(2, 2);
        System.out.println(b.calculate());
        System.out.println(b.calculate());
        System.out.println(b.calculate());
        System.out.println(b.calculate());
        b.addPair(3, 2);
        b.addPair(5, 1);
        b.addPair(5, 1);
        System.out.println(b.calculate());
        b.addPair(5, 1);
        System.out.println(b.calculate());
    }
}