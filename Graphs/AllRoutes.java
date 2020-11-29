import java.util.*;

public class AllRoutes {
    int n;
    int[][] cities;
    int[] distances;
    
    public AllRoutes(int n){
        this.n = n;
        cities = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i==j){
                    cities[i][j] = 0;
                } else{
                    cities[i][j] = 100000;
                }
            }
        }
    }

    public void addRoad(int a, int b, int x) {
        a--;
        b--;
        if(cities[a][b]!=0 && cities[a][b]<x){
            return;
        }
        cities[a][b] = x;
        cities[b][a] = x;
    }


    public int[][] getTable() {
        int[][] table = new int[n][n];
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    cities[i][j] = Math.min(cities[i][j],cities[i][k]+cities[k][j]);
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i==j){
                    cities[i][j] = 0;
                } else if(cities[i][j]==100000){
                    cities[i][j] = -1;
                }
            }
        }
        return cities;
    }

    public static void main(String[] args) {
        AllRoutes a = new AllRoutes(4);
        a.addRoad(1,2,2);
        a.addRoad(1,3,5);
        a.addRoad(2,3,1);
        System.out.println(Arrays.deepToString(a.getTable()));
        // [[0,2,3,-1],[2,0,1,-1],[3,1,0,-1],[-1,-1,-1,0]]
    }
}