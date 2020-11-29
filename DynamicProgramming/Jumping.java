package DynamicProgramming;


import java.util.Arrays;

public class Jumping {
    public long count(int n, int a, int b) {
        long[] dp = new long[n+1];
        
        dp[a] = 1;
        dp[b] = 1;

        for(int i = Math.min(a,b); i <= n; i++){
            if(i>=a){
                dp[i] += dp[i-a];
            }
            if(i >= b){
                dp[i] += dp[i-b];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        Jumping j = new Jumping();
        System.out.println(j.count(3,1,3));
        System.out.println(j.count(4,1,2)); // 5
        System.out.println(j.count(10,2,5)); // 2
        System.out.println(j.count(10,6,7)); // 0
        System.out.println(j.count(30,3,5)); // 58
        System.out.println(j.count(50,2,3)); // 525456
        System.out.println(j.count(47,1,2));
    }
}