
import java.util.Arrays;

//Basic knapsack implementation with no trickery.

public class Coins {
    public int count(int[] t) {
        int count = -1;
        int n = t.length;
        int max = 0;

        for(int i = 0; i < n; i++){
            max += t[i];
        }
        boolean[] sums = new boolean[max + 1];
        sums[0] = true;

        for(int i = 0; i < n; i++){
            for(int j = max; j >= 0; j--){
                if(sums[j]){
                    sums[j+t[i]] = true;
                }
            }
        }
        
        System.out.println(Arrays.toString(sums));
        
        for(int i = 0; i <= max; i++){
            if(sums[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Coins c = new Coins();
        System.out.println(c.count(new int[]{3,4,5})); // 7
        System.out.println(c.count(new int[]{1,1,2})); // 4
        System.out.println(c.count(new int[]{2,2,2,3,3,3})); // 13
        System.out.println(c.count(new int[]{42,5,5,100,1,3,3,7})); // 91
    }
}