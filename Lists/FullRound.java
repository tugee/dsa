
import java.util.ArrayDeque;
import java.util.ArrayList;

public class FullRound {
    public long count(int n) {
        if(n%2==0){
            return n;
        } else{
            long k =((n+1)/2)-1;
            return k*k+k;
        }
    }

    public static void main(String[] args) {
        FullRound f = new FullRound();
        System.out.println(f.count(2)); // 2
        System.out.println(f.count(5)); // 6
        System.out.println(f.count(31)); // 240
    }
}