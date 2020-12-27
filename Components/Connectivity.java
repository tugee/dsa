import java.util.*;

public class Connectivity {
    int n;
    int[] link, size;
    int result;
    
    public Connectivity(int n) {
        link = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            link[i] = i;
        }
        size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            size[i] = 1;
        }
        result = n;
    }

    public void addEdge(int a, int b) {
        if(find(a)!=find(b)){
            union(a,b);
            result-=1;
        }
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

    public int count() {
        System.out.println(Arrays.toString(link));
        System.out.println(Arrays.toString(size));
        return result-1;
    }

    public static void main(String[] args) {
        Connectivity c = new Connectivity(5);
        System.out.println(c.count()); // 4
        c.addEdge(2,4);
        c.addEdge(3,5);
        System.out.println(c.count()); // 2
        c.addEdge(2,3);
        c.addEdge(3,4);
        System.out.println(c.count()); // 1
        c.addEdge(1,2);
        System.out.println(c.count()); // 0
    }
}