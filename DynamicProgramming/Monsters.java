

import java.util.Arrays;

public class Monsters {
    
    public static void print2D(int mat[][]) {
        // Loop through all rows 
        for (int[] row : mat) // converting each row as string 
        // and then printing in a separate line 
        {
            System.out.println(Arrays.toString(row));
        }
    }

    public int count(String[] r) {
        int n = r.length;
        int[][] routes = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            routes[0][i] = 100;
            routes[i][0] = 100;
        }
        int monsters = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if (r[i-1].charAt(j-1) == '#') {
                    if(i==n && j == n){
                        return -1;
                    }
                    routes[i][j] = 100;
                } if(r[i-1].charAt(j-1)=='@'){
                    if (i == 1 && j == 1) {
                        routes[i][j] = 1;
                        continue;
                    }
                    routes[i][j]++;
                    routes[i][j] += Math.abs(Math.min(routes[i - 1][j], routes[i][j - 1]));

                } else if(r[i-1].charAt(j-1)=='.') {
                    if(i==1 && j == 1){
                        routes[i][j] = 0;
                        continue;
                    }
                    routes[i][j] = Math.abs(Math.min(routes[i-1][j],routes[i][j-1]));
                }
            }
        }
        print2D(routes);
        return Math.abs(routes[n][n]) >= 100 ? -1: routes[n][n];
    }

    public static void main(String[] args) {
        Monsters m = new Monsters();
        String[] r = {".##@.",
                      "#@.##",
                      ".#@#.",
                      "@##@.",
                      "@#@@@"};
        
        String[] a = {"@@@.#",
                      ".#@@#",
                      "#..@@",
                      "@@@@@",
                      "@@@@."};
        
        String[] c = {"@@@..",
                      "@@@@@",
                      ".@@@@",
                      "@....",
                      "@.@.@"};
        System.out.println(m.count(r)); // 2
        System.out.println(m.count(a)); // 2
        System.out.println(m.count(c)); // 2


    }
}