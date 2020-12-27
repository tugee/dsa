import java.util.*;
public class UniqueTree {
    class Edge implements Comparable<Edge> {

        int a;
        int b;
        int w;
        String y;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
            this.y = a+","+w;
        }

        @Override
        public int compareTo(Edge o) {
            if(w - o.w == 0){
                return a-o.a;
            }
            return w - o.w;
        }

        @Override
        public String toString() {
            return "(" + a + "," + b + "," + w + ")";
        }
    }
    int n;
    ArrayList<Edge> graph;
    int[] link, size;
    HashMap<Integer,ArrayList<Edge>> buckets;
    ArrayList<Integer[]> adj;

    public UniqueTree(int n) {
        this.n = n;
        graph = new ArrayList<>();
        buckets = new HashMap<>();
        adj = new ArrayList<>();
        for(int i = 0; i <=n; i++){
            Integer[] ad = new Integer[n+1];
            
            for(int j = 0;j<=n;j++){
                ad[j] = 0;
            }
            adj.add(ad);
        }
    }

    public void addEdge(int a, int b, int x) {
        Edge e = new Edge(a,b,x);
        System.out.println(e);
        System.out.println(adj.get(a)[b]+","+0);
        if(adj.get(a)[b]!=0 && adj.get(a)[b]<x){
            return;
        }
        graph.add(e);
        buckets.putIfAbsent(x, new ArrayList<>());
        buckets.get(x).add(e);
        adj.get(a)[b]=x;
    }
    
    int find(int x) {
        while (link[x] != x) {
            x = link[x];
        }
        return x;
    }
    int find2(int x,int link[]) {
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
        for (int i = 1; i <= n; i++) link[i] = i;
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) size[i] = 1;
        
        int count = n;
        Collections.sort(graph);
        System.out.println(graph);
        ArrayList<Edge> mst = new ArrayList<>();
        for (Edge edge : graph) {
            if (find(edge.a) != find(edge.b)) {
                union(edge.a, edge.b);
                mst.add(edge);
                count--;
            }
        }
        System.out.println("mst is: "+mst);
        link = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            link[i] = i;
        }
        size = new int[n + 1];
        for (int i = 1; i <= n; i++)
            size[i] = 1;
        
        boolean[] visited = new boolean[n + 1];
        for(Edge edge: mst){
            if (buckets.get(edge.w).size() > 1) {
                ArrayList<Edge> comp = buckets.get(edge.w);
                System.out.println(comp);
                for(Edge e : comp){
                    if(!mst.contains(e)){
                        ArrayList<Edge> copy = new ArrayList<>(mst);
                        copy.set(mst.indexOf(edge), e);
                        if(swappable(copy)){
                            return false;
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(link));
        System.out.println(Arrays.toString(visited));
        
        System.out.println(mst);
        
        return count == 1 ? true :false;
    }
    
    boolean swappable(ArrayList<Edge> mst){
        link = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            link[i] = i;
        }
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++)
            s[i] = 1;
        int count = n;
        for(Edge e : mst){
            if(find2(e.a,link)!=find2(e.b,link)){
                int a = e.a;
                int b = e.b;
                
                a = find2(a,link);
                b = find2(b,link);
                if (s[a] < s[b]) {
                    int t = a;
                    a = b;
                    b = t;
                }
                size[a] += size[b];
                link[b] = a;
                count--;
            }
        }
        return count == 1 ? true :false;
    }
    
    

    public static void main(String[] args) {
        UniqueTree u = new UniqueTree(50);
        u.addEdge(14, 21, 172);
        u.addEdge(14, 28, 98);
        u.addEdge(21, 32, 125);
        u.addEdge(21, 33, 152);
        u.addEdge(32, 50, 268);
        u.addEdge(28, 31, 20);
        u.addEdge(50, 13, 231);
        u.addEdge(50, 4, 89);
        u.addEdge(31, 11, 187);
        u.addEdge(14, 44, 17);
        u.addEdge(28, 45, 55);
        u.addEdge(21, 25, 53);
        u.addEdge(32, 36, 307);
        u.addEdge(4, 38, 72);
        u.addEdge(44, 10, 54);
        u.addEdge(28, 42, 97);
        u.addEdge(13, 19, 264);
        u.addEdge(33, 9, 15);
        u.addEdge(36, 3, 156);
        u.addEdge(44, 43, 254);
        u.addEdge(43, 29, 47);
        u.addEdge(42, 17, 49);
        u.addEdge(33, 23, 144);
        u.addEdge(23, 49, 227);
        u.addEdge(50, 41, 101);
        u.addEdge(9, 6, 179);
        u.addEdge(41, 5, 104);
        u.addEdge(43, 35, 14);
        u.addEdge(35, 40, 86);
        u.addEdge(40, 18, 306);
        u.addEdge(28, 15, 242);
        u.addEdge(18, 27, 212);
        u.addEdge(5, 8, 237);
        u.addEdge(17, 30, 32);
        u.addEdge(13, 12, 26);
        u.addEdge(32, 20, 291);
        u.addEdge(27, 34, 321);
        u.addEdge(3, 39, 277);
        u.addEdge(5, 46, 284);
        u.addEdge(3, 47, 105);
        u.addEdge(32, 24, 94);
        u.addEdge(8, 37, 262);
        u.addEdge(14, 7, 206);
        u.addEdge(20, 1, 138);
        u.addEdge(41, 2, 255);
        u.addEdge(37, 22, 278);
        u.addEdge(14, 16, 134);
        u.addEdge(23, 48, 162);
        u.addEdge(17, 26, 236);
        System.out.println(u.check());
        u.addEdge(5, 10, 134);
        u.addEdge(36, 46, 160);
        u.addEdge(32, 50, 161);
        u.addEdge(46, 50, 132);
        u.addEdge(14, 22, 210);
        u.addEdge(43, 47, 258);
        u.addEdge(45, 48, 96);
        System.out.println(u.check());
        u.addEdge(35, 42, 121);
        System.out.println(u.check());
        u.addEdge(5, 22, 294);
        System.out.println(u.check());
        u.addEdge(35, 44, 93);
        u.addEdge(21, 45, 99);
        u.addEdge(30, 32, 101);
        u.addEdge(48, 50, 220);
        u.addEdge(40, 46, 257);
        u.addEdge(29, 50, 192);
        u.addEdge(30, 47, 62);
        u.addEdge(7, 38, 287);
        u.addEdge(43, 49, 184);
        u.addEdge(23, 34, 199);
        u.addEdge(27, 49, 313);
        u.addEdge(27, 50, 168);
        u.addEdge(11, 38, 115);
        System.out.println(u.check());
        System.out.println(u.check());
        u.addEdge(6, 20, 266);
        u.addEdge(1, 43, 274);
        System.out.println(u.check());
        u.addEdge(22, 42, 71);
        u.addEdge(26, 44, 91);
        System.out.println(u.check());
        System.out.println(u.check());
        System.out.println(u.check());
        u.addEdge(14, 30, 206);
        u.addEdge(36, 49, 193);
        System.out.println(u.check());
        u.addEdge(34, 46, 185);
        System.out.println(u.check());
        u.addEdge(27, 29, 241);
        u.addEdge(9, 44, 76);
        u.addEdge(32, 40, 6);
        u.addEdge(15, 28, 60);
        u.addEdge(46, 50, 286);
        u.addEdge(15, 45, 2);
        u.addEdge(21, 27, 40);
        u.addEdge(32, 46, 127);
        u.addEdge(38, 45, 84);
        System.out.println(u.check());

    }
}
