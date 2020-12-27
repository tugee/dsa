
import java.util.*;

public class Components {
    int[] parent;
    int[] koko;
    int komponentit;
    public Components(int n) {
        this.parent = new int[n+1];
        this.koko = new int[n+1];
        for(int i = 1 ; i <= n; i++){
            parent[i] = i;
            koko[i] = 1;
        }
        komponentit = n;
    }
    
    public int parent(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    public void addRoad(int a, int b) {
        a = parent(a);
        b = parent(b);
        
        if(a!=b){
            komponentit--;
        }
        if (koko[a] < koko[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        parent[b] = a;
        koko[a] = 0;
    }

    public int count() {
        return komponentit;
    }

    public static void main(String[] args) {
        Components c = new Components(10);
        System.out.println(c.count());
        System.out.println(c.count());
        c.addRoad(9, 10);
        System.out.println(c.count());
        c.addRoad(7, 8);
        c.addRoad(9, 10);
        c.addRoad(6, 10);
        System.out.println(c.count());
        c.addRoad(8, 9);
        c.addRoad(3, 6);
        System.out.println(c.count());
        System.out.println(c.count());
        System.out.println(c.count());
        System.out.println(c.count());
        System.out.println(c.count());
        c.addRoad(6, 7);
        c.addRoad(7, 10);
        System.out.println(c.count());
        System.out.println(c.count());
        c.addRoad(2, 8);
        c.addRoad(5, 7);
        c.addRoad(7, 8);
        System.out.println(c.count());
        c.addRoad(2, 10);
        System.out.println(c.count());
        c.addRoad(3, 8);
        c.addRoad(1, 3);
        c.addRoad(5, 10);
        System.out.println(c.count());
        c.addRoad(7, 8);
    }
}