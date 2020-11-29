import java.util.*;

public class BellmanFord {
    class Edge {

        int start, end, dist;

        public Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.dist = distance;
        }
    }
    public int bf(int n){
        ArrayList<Edge> edges = new ArrayList<>();
        
        Random r = new Random();
        for(int i = 0; i < 10*n; i++){
            int start = r.nextInt(n);
            int end = r.nextInt(n);
            int d = r.nextInt(100)+1;
            edges.add(new Edge(start,end,d));
        }
        int[] dist = new int[n];
        for (int i = 1; i < n; i++) {
            dist[i] = -1;
        }
        dist[0] = 0;
        
        int i = 0;
        while(true){
            i++;
            boolean change = false;
            for (Edge edge : edges) {
                if (dist[edge.start] == -1) {
                    continue;
                }
                int newDist = dist[edge.start] + edge.dist;
                if (newDist < dist[edge.end] || dist[edge.end] == -1) {
                    dist[edge.end] = newDist;
                    change = true;
                }
            }
            
            if(!change) break;
        }
        return i;
    }    
    public static void main(String[] args) {
        BellmanFord test = new BellmanFord();
        long start = System.nanoTime();
        int asd = test.bf(100000);
        long end = System.nanoTime();
        System.out.println(asd);
        System.out.println((double)(end-start)/1E9);
    }
}
