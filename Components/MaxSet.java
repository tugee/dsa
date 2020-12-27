import java.util.*;

public class MaxSet {
    int[] link, size;
    int n;
    int max = 1;

    public MaxSet(int n) {
        this.n = n;
        
        link = new int[n+1];
        for(int i = 1; i<= n; i++){
            link[i] = i;
        }
        
        size = new int[n+1];
        for(int i = 1; i <= n; i++){
            size[i] = 1;
        }
        
    }
    
    int find(int x) {
        while (link[x] != x) {
            x = link[x];
        }
        return x;
    }
    
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (size[a] < size[b]) {
            int t = a;
            a = b;
            b = t;
        }
        size[a] += size[b];
        max = Math.max(size[a],max);
        link[b] = a;    
    }
    
    public void merge(int a, int b){
        if(find(a)!=find(b)){
            union(a,b);
        }
    }

    public int getMax() {
        return max;
    }

    public static void main(String[] args) {
        MaxSet m = new MaxSet(5);
        System.out.println(m.getMax()); // 1
        m.merge(1,2);
        m.merge(3,4);
        m.merge(3,5);
        System.out.println(m.getMax()); // 3
        m.merge(1,5);
        System.out.println(m.getMax()); // 5
    }
}