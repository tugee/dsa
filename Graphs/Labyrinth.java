
import java.util.*;

public class Labyrinth {
    int n;
    int m;
    boolean[][] wall;
    int[][] distance;
    boolean[][] visited; 
    class Node{
        int x;
        int y;
        public Node(int y,int x){
            this.x = x;
            this.y = y;
        }
    }
    
    public int count(String[] r) {
        this.n = r.length;
        this.m = r[0].length();
        wall = new boolean[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];
        Node start = null;
        Node end = null;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (r[i].charAt(j) == '#') {
                    wall[i][j] = true;
                } else if(r[i].charAt(j)=='A'){
                    start = new Node(i,j);
                    distance[start.y][start.x] = 0;
                } else if(r[i].charAt(j)=='B'){
                    end = new Node(i,j);
                    distance[end.y][end.x] = -1;
                }
            }
        }
        
        Deque<Node> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            Node current = q.poll();
            visited[current.y][current.x]=true;
            System.out.println(current.x+","+current.y);
            
            for(int i : new int[]{-1,1}){
                System.out.println("direction "+i);
                if(current.y + i > 0 && current.y +i < n){
                    if(!visited[current.y+i][current.x] && !wall[current.y+i][current.x]){
                        Node a = new Node(current.y + i, current.x);
                        distance[current.y + i][current.x] = distance[current.y][current.x] + 1;
                        visited[current.y+i][current.x] = true;
                        q.add(a);
                    }
                }
                if(current.x + i >= 0 && current.x + i < m ){
                    if(!visited[current.y][current.x+i] && !wall[current.y][current.x+i]){
                        Node b = new Node(current.y, current.x + i);
                        distance[current.y][current.x+i] = distance[current.y][current.x] + 1;
                        visited[current.y][current.x + i] = true;
                        q.add(b);
                    }
                }
            }
        }
        for(int i = 0; i < n;i++){
            System.out.println(Arrays.toString(distance[i]));
        }
        return distance[end.y][end.x];
        
    }

    public static void main(String[] args) {
        Labyrinth l = new Labyrinth();
        String[] r = {"########",
                      "#.A....#",
                      "#.#.##.#",
                      "#.##...#",
                      "#...B#.#",
                      "########"};
        System.out.println(l.count(r)); // 7
    }
}