
import java.util.PriorityQueue;

public class NewRoads {
    
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
    
    int[] link, size;
    int n;
    PriorityQueue<Edge> pq;
    public NewRoads(int n) {
        pq = new PriorityQueue<>();
        link = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            link[i] = i;
        }
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            size[i] = 1;
        }
        this.n = n;    
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
    
    public void addRoad(int a, int b, int x) {
            Edge n = new Edge(a, b, x);
            pq.add(n);
    }

    public int minCost() {
        int length = 0;
        int count = 0;
        System.out.println(pq);
        PriorityQueue<Edge> copy = new PriorityQueue(pq);
        System.out.println(copy);
        link = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            link[i] = i;
        }
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            size[i] = 1;
        }
        while(!copy.isEmpty() &&  count < n){
            Edge curr = copy.poll();
            System.out.println(count);
            if(find(curr.a)!=find(curr.b)){
                length+=curr.w;
                union(curr.a,curr.b);
                count++;
            }
        }
        return count == n-1 ? length: -1;
    }

    public static void main(String[] args) {
        NewRoads n = new NewRoads(5);
        n.addRoad(1, 2, 6);
        n.addRoad(3, 5, 1);
        n.addRoad(4, 5, 5);
        System.out.println(n.minCost());
        n.addRoad(1, 5, 8);
        System.out.println(n.minCost());
        n.addRoad(2, 3, 5);
        n.addRoad(4, 5, 1);
        System.out.println(n.minCost());
        System.out.println(n.minCost());

    }
}