import java.util.*;


public class Shortening {
    
    class Edge {

        int start, end, dist;

        public Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.dist = distance;
        }
    }
    
    ArrayList<Edge> edges;
    int n;
    public Shortening(int n) {
        this.n = n;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int a, int b, int x) {
        edges.add(new Edge(a,b,x));
    }

    public boolean check(int a, int b){
        int[] dist = new int[this.n+1];
        for (int i = 1; i <= this.n; i++) dist[i] = Integer.MAX_VALUE;
        dist[a] = 0;
        int i = 0;
        int iDist = -1;
        while (true) {
            boolean change = false;
//            System.out.print(Arrays.toString(dist));
//            System.out.println("  i: "+i+"  "+iDist+"=="+dist[b]);
            if(i==edges.size()-1) iDist = dist[b];
            if (i > edges.size()*edges.size() && dist[b] != iDist) {
                return true;
            } else if (i > edges.size()*edges.size()) {
                return false;
            }
            for (Edge edge : this.edges) {
                if (dist[edge.start] == Integer.MAX_VALUE) continue;
                int newDist = dist[edge.start]+edge.dist;
                if (newDist < dist[edge.end] || dist[edge.end] == Integer.MAX_VALUE) {
                    dist[edge.end] = newDist;
                    change = true;
                }
            }
            if (!change) break;
            i++;

        }
        return false;
    }

    public static void main(String[] args) {
        Shortening s = new Shortening(5);
        s.addEdge(3, 2, 154);
//        System.out.println(s.check(5, 4));
        s.addEdge(1, 5, 81);
        s.addEdge(3, 1, 348);
//        System.out.println(s.check(3, 2));
        s.addEdge(3, 5, 782);
        s.addEdge(4, 2, -119);
        s.addEdge(5, 1, -103);
        s.addEdge(5, 4, -157);
        s.addEdge(3, 2, 972);
        s.addEdge(3, 5, 118);
        s.addEdge(2, 3, 852);
//        System.out.println(s.check(3, 5));
        System.out.println(s.check(4, 2));
//        System.out.println(s.check(3, 5));
//        s.addEdge(5, 4, 701);
//        s.addEdge(4, 3, 496);
//        System.out.println(s.check(5, 4));
//        System.out.println(s.check(1, 2));
//        System.out.println(s.check(5, 3));
    }
}