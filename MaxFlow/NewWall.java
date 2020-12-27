import java.util.*;

public class NewWall {
    boolean[][] visited;
    int n;
    boolean found;
    int[] dx = new int[]{1,0,0,-1};
    int[] dy = new int[]{0,1,-1,0};
    String[] map;
    public int count(String[] r) {
        map = r;
        n = r.length; 
        int count = 0;
        found = true;
        for(int i = 0; i < 2 && found; i++){
            visited = new boolean[n][n];
            visited[0][0] = false;
            found = false;
            dfs(0, 0);
            if(found){
                count++;
            }
        }
        return count;
    }
    
    void dfs(int x,int y){
        if(visited[x][y]){
            return;
        }
        if(x==n-1 && y == n-1){
            found = true;
        }
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++){
            if(valid(x+dx[i],y+dy[i])){
                dfs(x+dx[i],y+dy[i]);
            }
        }
        
    }
    
    boolean valid(int x, int y){
        if(x < 0 || x >=n || y < 0 || y >=n || map[x].charAt(y) == '#'){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NewWall n = new NewWall();
        String[] r = {".....",
                      ".###.",
                      "...#.",
                      "##.#.",
                      "....."};
        System.out.println(n.count(r)); // 2
    }
}