import java.util.*;
public class Breakwall {
    
    int[] dx = {-1,0,0,1};
    int[] dy = {0,1,-1,0};
    int n;
    int m;
    boolean[][] wall;
    class Node implements Comparable<Node>{
        int x;
        int y;
        int distance;
        
        public Node(int y, int x, int d){
            this.x = x;
            this.y = y;
            this.distance = d;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }
    }
    
    public int count(String[] r) {
        n = r.length;
        m = r[0].length();
        wall = new boolean[n-2][m-2];
        
        int startX = 0;
        int startY = 0;
        
        int endX = -1;
        int endY = -1;
        
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < m - 1; j++){
                if(r[i].charAt(j)=='*'){
                    wall[i-1][j-1] = true;
                }else if(r[i].charAt(j) == 'A'){
                    startX = j-1;
                    startY = i-1;
                } else if(r[i].charAt(j)=='B'){
                    endX = j-1;
                    endY = i-1;
                }
            }
        }
        System.out.println(startY+","+startX);
        System.out.println(endY + "m" + endX);
        PriorityQueue<Node> q = new PriorityQueue<>();
        
        int[][] distance = new int[n-2][m-2];
        for(int i = 0; i < n-2; i++){
            for(int j = 0; j < m-2; j++){
                distance[i][j] = n*m;
            }
        }
        distance[startY][startX] = 0;
        
        System.out.println(Arrays.deepToString(distance));

        
        boolean[][] visited = new boolean[n-2][m-2];
        
        Node first = new Node(startY,startX,0);
        q.add(first);
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.println(curr.y+","+curr.x+"distance : "+curr.distance);
            
            if(visited[curr.y][curr.x]){
                continue;
            }
            
            if(curr.y == endY && curr.x == endX){
                return curr.distance;
            }
            
            visited[curr.y][curr.x] = true;
            
            for(int i = 0; i < 4; i++){
                    int newY = curr.y+dy[i];
                    int newX = curr.x+dx[i];
                    if(valid(newY,newX)){
                        int newDist = curr.distance + 1;
                        int dist = distance[newY][newX];
                        System.out.println(newY + "ed" + newX+" and "+wall[newY][newX] +" and "+ newDist + " <"+dist);
                        if(wall[newY][newX]){

                            if(newDist < dist){
                                Node n = new Node(newY,newX,newDist);
                                System.out.println(newY+" added "+newX);
                                q.add(n);
                            }
                        } else{
                            Node n = new Node(newY, newX, curr.distance);
                            distance[newY][newX] = curr.distance;
                            q.add(n);
                        }
                    }
            }    
        }
        
        
        
        return -1;
    }
    
    public boolean valid(int y, int x){
        if(y < 0 || y >= n - 2|| x < 0 || x >= m - 2){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Breakwall b = new Breakwall();
        String[] r = {"########",
                      "#*A*...#",
                      "#.*****#",
                      "#.**.**#",
                      "#.*****#",
                      "#..*..B#",
                      "########"};
        
        String[] p = {"##########",
                    "#********#",
                    "#*.**.A..#",
                    "#.****.*.#",
                    "#********#",
                    "#***.****#",
                    "#***.**.*#",
                    "#***.***B#",
                    "#.*.*****#",
                    "##########"};
        System.out.println(b.count(p)); // 2
    }
}