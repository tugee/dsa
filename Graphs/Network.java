
import java.util.*;
public class Network {
    int[][] computers;
    boolean[] visited;
    int[] distance;
    
    public Network(int n) {
        computers = new int[n+1][n+1];
    }

    public void addLink(int a, int b) {
        computers[a][b] = 1;
        computers[b][a] = 1;
    }

    public int bestRoute(int a, int b) {
        this.visited = new boolean[computers.length];
        this.distance = new int[computers.length];
        Deque<Integer> q = new LinkedList<Integer>();
        visited[a] = true;
        distance[a] = 0;
        q.add(a);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 0; i < computers.length; i++){
                if(computers[node][i]==1 && !(visited[i])){
                    q.addLast(i);
                    visited[i] = true;
                    distance[i] = distance[node] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        return distance[b] == 0 ? -1 : distance[b];
    }

    public static void main(String[] args) {
        Network w = new Network(5);
        w.addLink(1,2);
        w.addLink(2,3);
        w.addLink(1,3);
        w.addLink(4,5);
        System.out.println(w.bestRoute(1,5)); // -1
        w.addLink(3,5);
        System.out.println(w.bestRoute(1,5)); // 2
    }
}