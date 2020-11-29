
import java.util.*;

public class Chambers {
    boolean[][] wall;
    int n;
    int m;
    int walls = 0;
    int visited = 0;
    Deque<Node> free = new LinkedList<Node>();
    
    class Node{
        int x;
        int y;
    }
    
    public int count(String[] r) {
        this.n = r.length;
        this.m = r[0].length();
        wall = new boolean[m][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(r[i].charAt(j)=='#'){
                    wall[j][i] = true;
                    walls++;
                } else {
                    Node f = new Node();
                    f.x = i;
                    f.y = j;
                    free.add(f);
                }
            }
        }
        int count = 0;

        while(walls < n*m){
            for(int i = 0; i <n; i++){
                for(int j = 0; j < m; j++){
                    if(!wall[j][i]){
                        dfs(j,i);
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
    
    public void dfs(int y, int x){
        if(wall[y][x]){
            return;
        }
        wall[y][x] = true;
        walls++;
        dfs(y+1,x);
        dfs(y-1,x);
        dfs(y,x+1);
        dfs(y,x-1);
    } 

    public static void main(String[] args) {
        Chambers c = new Chambers();
        String[] r = {"########",
                      "#..#...#",
                      "####.#.#",
                      "#..#.#.#",
                      "########"};
        String[] b = {"##########",
                    "#...#...##",
                    "##.##.##.#",
                    "#...##.#.#",
                    "##..##..##",
                    "#...#.#.##",
                    "#..#.#.###",
                    "#..#.##.##",
                    "##..####.#",
                    "##########"};
        System.out.println(c.count(b)); // 3
    }
}
