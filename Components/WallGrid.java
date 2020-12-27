import java.util.*;

public class WallGrid {
    int n;
    boolean[] wall;
    int[] link, size;
    int[] dx = new int[]{-1,0,0,1};
    int[] dy = new int[]{0,1,-1,0};
    int count;
    
    public WallGrid(int n) {
        this.n = n;
        wall = new boolean[n*n+1];
        link = new int[n*n+1];
        size = new int[n*n+1];
        for(int i = 1; i < n*n+1; i++){
            size[i] = 1;
            wall[i] = true;
        }
        count = 0;
    }

    public void remove(int x, int y) {
        int i = (y-1)*n+x;
        if(!wall[i]) return;
        wall[i] = false;
        link[i] = i;
        count++;
        for(int j = 0; j < 4; j++){
            int k = i+dy[j]*n+dx[j];
            if(k > 0 && k <= n*n+1){
                if(!wall[k]){
                    if(find(i)!=find(k)) union(i,k);
                }
            }
        }
    }

    public int count() {
        return count;
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
        count--;
    }


    public static void main(String[] args) {
        WallGrid w = new WallGrid(5);
        System.out.println(w.count()); // 0
        w.remove(2,2);
        w.remove(4,2);
        System.out.println(w.count()); // 2
        w.remove(3,2);
        System.out.println(w.count()); // 1
        w.remove(2,4);
        w.remove(2,4);
        w.remove(4,4);
        System.out.println(w.count()); // 3
        w.remove(3,3);
        System.out.println(w.count()); // 3
        w.remove(3,4);
        System.out.println(w.count()); // 1
    }
}