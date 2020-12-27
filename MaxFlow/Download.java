import java.util.*;

public class Download {
    
    int[][] graph;
    boolean[] visited;
    int n;
    boolean found;
    
    ArrayDeque<Integer> path;
    public Download(int n) {
        graph = new int[n+1][n+1];
        this.n = n;
    }

    public void addLink(int a, int b, int x) {
        graph[a][b]+=x;
    }

    public int calculate(int a, int b) {
        int maxFlow = 0;
        int[][] temp = Arrays.stream(graph).map(int[]::clone).toArray(int[][]::new);;
        while(true){
            int max = flow(a,b);
            maxFlow+= max;
            if(!found){
                break;
            }
        }
        graph = temp;
        System.out.println(Arrays.deepToString(graph));
        return maxFlow; 
    }
    
    public int flow(int a,int b){
        path = new ArrayDeque<>();
        visited = new boolean[n+1];
        found = false;
        
        dfs(a,b);
        
        int minWeight = 1000000;
        int prev = 0;
        for(int n : path){
            if(prev != 0){
                minWeight = Math.min(minWeight, graph[prev][n]);
            }
            prev = n;
        }
        
        prev = 0;
        for(int n : path){
            if(prev != 0){
                graph[prev][n] -= minWeight;
                graph[n][prev] += minWeight;
            }
            prev = n;
        }
        return minWeight == 1000000 ? 0 : minWeight;
    }
    
    void dfs(int x,int z){
        if(visited[x]) return;
        visited[x] = true;
        System.out.println("currently at"+x);
        if(!found) path.addLast(x);
        if(x==z && !found) found = true;
        for(int i = 1; i <= n; i++){
            if(graph[x][i] > 0 ){
                
                dfs(i,z);
            }
        }
        if(!found) path.removeLast();
    }

    public static void main(String[] args) {
        Download d = new Download(5);
        System.out.println(d.calculate(3, 4));
        System.out.println(d.calculate(4, 5));
        d.addLink(5, 4, 1);
        System.out.println(d.calculate(5, 4));
        d.addLink(5, 1, 6);
        d.addLink(2, 1, 7);
        d.addLink(1, 4, 3);
        System.out.println(d.calculate(3, 5));
        System.out.println(d.calculate(2, 3));
        System.out.println(d.calculate(5, 4));
    }
}
