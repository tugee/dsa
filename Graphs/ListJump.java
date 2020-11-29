
import java.util.*;
class Pair{
    int n;
    long d;
    public Pair(int n, long d){
        this.n = n;
        this.d = d;
    }
}
public class ListJump {
    
    public long calculate(int[] t) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < t.length; i++){
            ArrayList<Integer> targets = new ArrayList<>();
            if(i-t[i] >= 0){
                targets.add(i-t[i]);
            }
            if(i+t[i]<t.length){
                targets.add(i+t[i]);
            }
            graph.add(targets);
        }
        
        System.out.println(graph);
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        boolean[] visited = new boolean[t.length];
        long[] distances = new long[t.length];
        for(int i = 0; i < t.length; i++){
            distances[i] = -1;
        }
        distances[0] = 0;
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.poll();
            if(visited[curr]){
                continue;
            }
            visited[curr] = true;
            for(int edge : graph.get(curr)){
                long newDist = distances[curr] + t[curr];
                long current = distances[edge];
                if(newDist < current || current == -1){
                    distances[edge] = newDist;
                    q.add(edge);
                }
            }
        }
        System.out.println(Arrays.toString(distances));
        return distances[t.length-1] == Integer.MAX_VALUE ? -1: distances[t.length-1];
    }

    public static void main(String[] args) {
        ListJump l = new ListJump();
        System.out.println(l.calculate(new int[] {1,1,1,1})); // 3
        System.out.println(l.calculate(new int[] {3,2,1})); // -1
        System.out.println(l.calculate(new int[] {3,5,2,2,2,3,5})); // 10         
        System.out.println(l.calculate(new int[] {7,5,3,1,4,2,4,6,1})); // 32
    }
}