import java.util.*;

public class BestRoute {
    int n;
    int[][] cities;
    int[] distances;
    
    public BestRoute(int n) {
        this.n = n;
        cities = new int[n+1][n+1];
    }

    public void addRoad(int a, int b, int x) {
        if(cities[a][b]!=0 && cities[a][b]<x){
            return;
        }
        cities[a][b] = x;
        cities[b][a] = x;
    }

    public int findRoute(int a, int b) {
        distances = new int[n+1];
        for(int i = 0; i <= n; i++){
            distances[i] = 50000;
        }
        distances[a] = 0;
        while(true){
            boolean change = false;
            for(int start = 1; start <= n; start++){
                for(int end = 1; end <= n; end++){
                    if(cities[start][end]!=0){
                        int distance = distances[end];
                        int newDistance = distances[start]+cities[start][end];
                        System.out.println(start+","+end+" "+distance +" < "+newDistance);
                        if(newDistance < distance){
                            distances[end] = newDistance;
                            change = true;
                        }
                    }
                }
            }
            if(!change){
                break;
            }
        }
        System.out.println(Arrays.toString(distances));
        return Math.abs(distances[b]) >= 50000 ? -1: distances[b];
    }

    public static void main(String[] args) {
        BestRoute b = new BestRoute(5);
        b.addRoad(2, 3, 1);
        b.addRoad(1, 4, 5);
        b.addRoad(4, 5, 9);
        b.addRoad(1, 5, 7);
        b.addRoad(2, 5, 4);
        b.addRoad(3, 4, 2);
        b.addRoad(3, 5, 9);
        b.addRoad(2, 3, 3);
        System.out.println(b.findRoute(2, 3));
        b.addRoad(2, 4, 2);

    }
}