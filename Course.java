import java.util.*;

public class Course {
    
    public long count(int x) {
        
        if(x > 56 || x < 35) return 0;
        
        long[] dp = new long[57];
        long[] dp2 = new long[57];
        
        dp[5] = 56;
        dp[6] = 28;
        dp[7] = 8;
        dp[8] = 1;
        
        for(int i = 2; i <= 7; i++){
            for(int j = i*5; j <= 8*i; j++){
//                System.out.println("Week "+i+" done " +j);
                dp2[j] = 56*dp[j-5]+28*dp[j-6]+8*dp[j-7]+dp[j-8];
//                System.out.println(Arrays.toString(dp2));
            }
            dp = dp2;
            dp2 = new long[57];
        }
        return dp[x];
    }

    public static void main(String[] args) {
        Course c = new Course();
        System.out.println(c.count(35)); // 1727094849536
        System.out.println(c.count(42)); // 2375030784000
        System.out.println(c.count(55)); // 56
        System.out.println(c.count(56)); // 1
        System.out.println(c.count(80)); // 0
    }
}