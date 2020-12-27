import java.util.*;

public class SameWeight {
    int n;
    ArrayList<Edge> pq;
    int[] link, size;
    int minpaino;
    boolean[] connected = new boolean[n+1];
    class Edge implements Comparable<Edge> {
        int a;
        int b;
        int w;
        
        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.w;
        }

        @Override
        public String toString() {
            return "(" + a + "," + b + "," + w + ")";
        }
    }
    
    public SameWeight(int n) {
        this.n = n;
        pq = new ArrayList<>();
    }

    public void addEdge(int a, int b, int x) {
        Edge n = new Edge(a, b, x);
        pq.add(n);    
    }
    
    int find(int x) {
        while (link[x] != x) {
            x = link[x];
        }
        return x;
    }
    
    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (size[a] < size[b]) {
            int t = a;
            a = b;
            b = t;
        }
        size[a] += size[b];
        link[b] = a;
    }

    public boolean check() {
        link = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            link[i] = i;
        }
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            size[i] = 1;
        }
        minpaino = Integer.MAX_VALUE;
        ArrayList<Edge> copy1 = new ArrayList<>(pq);
        Collections.sort(copy1,Collections.reverseOrder());
        System.out.println(copy1);
        System.out.println(pq);
        int maxCost = 0;
        for (Edge road : copy1) {
            if (find(road.a) != find(road.b)) {
                union(road.a, road.b);
                maxCost += road.w;
            }
        }
        System.out.println(maxCost);
        for (int i = 1; i <= n; i++) {
            link[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            size[i] = 1;
        }
        ArrayList<Edge> copy = new ArrayList<>(pq);
        Collections.sort(copy);
        System.out.println(copy);
        int minCost = 0;
        for (Edge road : copy) {
            if (find(road.a) != find(road.b)) {
                union(road.a, road.b);
                minCost += road.w;
            }
        }
        System.out.println(minCost);
        System.out.println(Arrays.toString(size));
        System.out.println(Arrays.toString(link));
        boolean connected = false;
        for(int i = 1; i <= n; i++){
            if(size[i]==n){
                connected = true;
                break;
            }
        }
        return connected ? maxCost == minCost: true;
    }

    public static void main(String[] args) {
        SameWeight s = new SameWeight(50);
        s.addEdge(42, 11, 6);
        s.addEdge(17, 42, 6);
        s.addEdge(49, 11, 6);
        s.addEdge(3, 49, 6);
        s.addEdge(16, 11, 6);
        s.addEdge(25, 11, 6);
        s.addEdge(23, 25, 4);
        s.addEdge(14, 25, 4);
        s.addEdge(43, 25, 4);
        s.addEdge(40, 23, 4);
        s.addEdge(2, 25, 4);
        s.addEdge(48, 2, 4);
        s.addEdge(50, 48, 1);
        s.addEdge(47, 48, 1);
        s.addEdge(21, 48, 1);
        s.addEdge(41, 48, 1);
        s.addEdge(1, 41, 1);
        s.addEdge(12, 1, 1);
        s.addEdge(36, 12, 4);
        s.addEdge(38, 36, 4);
        s.addEdge(32, 12, 4);
        s.addEdge(13, 38, 4);
        s.addEdge(19, 13, 4);
        s.addEdge(10, 19, 4);
        s.addEdge(35, 10, 7);
        s.addEdge(26, 35, 7);
        s.addEdge(45, 10, 7);
        s.addEdge(28, 45, 7);
        s.addEdge(39, 28, 7);
        s.addEdge(46, 39, 7);
        s.addEdge(24, 46, 1);
        s.addEdge(8, 46, 1);
        s.addEdge(34, 24, 1);
        s.addEdge(22, 24, 1);
        s.addEdge(30, 24, 1);
        s.addEdge(37, 8, 1);
        s.addEdge(31, 37, 5);
        s.addEdge(20, 31, 5);
        s.addEdge(5, 37, 5);
        s.addEdge(4, 5, 5);
        s.addEdge(9, 5, 5);
        s.addEdge(7, 31, 5);
        s.addEdge(15, 7, 7);
        s.addEdge(44, 15, 7);
        s.addEdge(33, 7, 7);
        s.addEdge(6, 7, 7);
        s.addEdge(18, 33, 7);
        s.addEdge(27, 33, 7);
        s.addEdge(29, 27, 8);
        s.addEdge(5, 37, 5);
        s.addEdge(27, 18, 7);
        s.addEdge(5, 24, 4);
        System.out.println(s.check());

    }
}