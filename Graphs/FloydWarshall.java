import java.util.*;

public class FloydWarshall {
    class Edge {

        int start, end, dist;

        public Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.dist = distance;
        }
    }

    public int[][] fw(int n) {
        ArrayList<Edge> edges = new ArrayList<>();
        
        Random r = new Random();
        r.setSeed(1337);
        
        for (int i = 0; i < 10 * n; i++) {
            int start = r.nextInt(n);
            int end = r.nextInt(n);
            int d = r.nextInt(100) + 1;
            edges.add(new Edge(start, end, d));
        }
        int[][] dist = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = 1000;
            }
        }
        for (Edge edge : edges) {
            dist[edge.start][edge.end] = Math.min(dist[edge.start][edge.end], edge.dist);
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i==j){
                        dist[i][j]=0;
                    }
                        dist[i][j] = Math.min(dist[i][j],
                                dist[i][k] + dist[k][j]);
                }
            }
        }

        
        return dist;
    }

    public static void main(String[] args) {
        FloydWarshall test = new FloydWarshall();
        long start = System.nanoTime();
        int[][] asd = test.fw(1000);
        long end = System.nanoTime();
        System.out.println(Arrays.deepToString(asd));
        System.out.println((double) (end - start) / 1E9);
    }
}
