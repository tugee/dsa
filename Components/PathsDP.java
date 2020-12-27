import java.util.*;

public class PathsDP {
    
    public static void main(String[] args){
        long[] dp = new long[51];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for(int i = 4; i <= 50; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(Arrays.toString(dp));
    }
    
}
