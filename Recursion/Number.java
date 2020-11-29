package Recursion;

public class Number {
    public int count(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = i; j<=n;j++){
                dp[j] += dp[j-i];
            }
        }
        return dp[n]+1;
    }

    public static void main(String[] args) {
        Number n = new Number();
        System.out.println(n.count(4)); // 5
        System.out.println(n.count(5)); // 7
        System.out.println(n.count(8)); // 22
        System.out.println(n.count(42)); // 53174
    }
}