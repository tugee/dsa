
import java.util.*;

public class Pushbox {
    int n;
    int m;
    boolean[][] wall;
    int goalY;
    int goalX;
    int[] dy = {-1, 0, 0, 1};
    int[] dx = {0, 1, -1, 0};
    
    class State{
        int boxY;
        int boxX;
        int meY;
        int meX;
        int steps = 0;
        int pushes = 0;
        public State(int x1, int y1, int x2, int y2){
            meY = y1;
            meX = x1;
            boxY= y2;
            boxX = x2;
        }
        
        public void print(){
            System.out.println("Box at:" + boxX + "," + boxY + " I am at: " + meX+","+meY+" steps: "+steps + " goal at: "+ goalX+","+goalY + " pushed: " + pushes);
        }

    }
    public int count(String[] r) {

        HashSet<String> states = new HashSet<>();
        
        n = r.length;
        m = r[0].length();
        
        wall = new boolean[n][m];

        int boxY = 0;
        int boxX = 0;
        int meY = 0;
        int meX = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(r[i].charAt(j)=='X'){
                    meY = i; meX = j;
                } else if(r[i].charAt(j)=='B'){
                    boxY = i;
                    boxX = j;
                } else if(r[i].charAt(j)=='Y'){
                    this.goalY = i;
                    this.goalX = j;
                } else if(r[i].charAt(j)=='#'){
                    wall[i][j] = true;
                }
            }
        }
        Deque<State> q = new ArrayDeque<>();
        
        State start = new State(meX,meY,boxX,boxY);
        
        q.add(start);
        int count = 9999;
        while(!q.isEmpty()){
                State current = q.poll();
                String cur = current.boxX+","+current.boxY+","+current.meX+","+current.meY;
                if(states.contains(cur)) continue;
                states.add(cur);                
                if(current.boxX == goalX && current.boxY == goalY){
                    count = Math.min(count,current.steps);
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                  
                    int newY= current.meY+dy[i];
                    int newX = current.meX+dx[i];
                    
                    if (valid(newY, newX)){
                        if (newY == current.boxY && newX == current.boxX && valid(current.boxY + dy[i], current.boxX + dx[i])) {
                            State pushState = new State(newX, newY, current.boxX + dx[i], current.boxY + dy[i]);
                            pushState.steps = current.steps + 1;
                            pushState.pushes = current.pushes + 1;
                            q.add(pushState);
                        } else if (newY != current.boxY || newX != current.boxX) {
                            State newState = new State(newX, newY, current.boxX, current.boxY);
                            newState.steps = current.steps + 1;
                            newState.pushes = current.pushes;
                            q.add(newState);
                        }
                    }
                }
        }
        return count == 9999 ? -1: count;
    }
    
    public boolean valid(int y, int x){
        if(y <= 0 || y >= n - 1 || x <= 0 || x >= m - 1 || wall[y][x]){
            return false;
        }
        return true;
    }
    

    public static void main(String[] args) {
        Pushbox p = new Pushbox();
        String[] r = {"########",
                      "#......#",
                      "#.#.Y#.#",
                      "#.#B.#.#",
                      "#..X.#.#",
                      "#.#..#.#",
                      "########"};
        String[] d = {"##########",
                        "#...#...##",
                        "#........#",
                        "###Y#....#",
                        "##.B.....#",
                        "#..##.#..#",
                        "#...#....#",
                        "#.X.#....#",
                        "#...#...##",
                        "##########"};
        String[] j ={"##########",
"#..#.....#",
"#.#...#..#",
"#.##.....#",
"#Y..##.###",
"#.....#..#",
"#.#....B.#",
"#........#",
"#.X.#..#.#",
"##########"};
        
        String[] omegalul = {"####################",
            "#..................#",
            "#..................#",
            "#.................##",
            "#......Y...........#",
            "#..........X.......#",
            "#..................#",
            "#..................#",
            "#...............#..#",
            "#..................#",
            "#..B.....#.........#",
            "#..................#",
            "#..................#",
            "#..................#",
            "#............#.....#",
            "#..............#...#",
            "#..................#",
            "#..................#",
            "#..................#",
            "####################"};

        System.out.println(p.count(omegalul)); // 18
    }
}