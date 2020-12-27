import java.util.*;

public class UnionFind {
    int[] parent;
    int[] koko;
    int komponentit;
    public int parent(int x){
        while(x != parent[x]){
            x = parent[x];
        }
        return x;
    }
    
    public boolean equal(int a, int b){
        return parent(a) == parent(b);
    }
    
    public void combine(int a, int b){
        a = parent(a);
        b = parent(b);
        
        if(koko[a] < koko[b]){
            int temp = a;
            a = b;
            b = temp;
        }
        parent[b] = a;
        koko[a]+= koko[b];
        komponentit--;
    }
    
    public static void main(String[] args){
        UnionFind uf = new UnionFind();
        int n = 100;
        uf.komponentit = n;
        uf.parent = new int[n+1];
        uf.koko = new int[n+1];
        
        for(int i = 1; i < n ; i++){
            uf.koko[i] = 1;
            uf.parent[i] = i;
        }
        
        Random r = new Random();
        long start = System.nanoTime();
        
        for(int i = 0; i < n; i++){
            int a = r.nextInt(n+1);
            int b = r.nextInt(n+1);
            if(!uf.equal(a,b)){
                uf.combine(a,b);
            }
        }
        long end = System.nanoTime();
        System.out.println((end-start)/1E9);
        System.out.println("Components left: " + uf.komponentit);
    }
}
