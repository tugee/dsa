
package DynamicProgramming;

public class FiboDP {
    static int n = 40;
    public static void main(String[] args){
        long start = System.nanoTime();
        int[] dp = new int[n];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        long end = System.nanoTime();
        System.out.println(dp[n-1]);
        System.out.println((double)(end-start)/1000000);
    }
    
}
