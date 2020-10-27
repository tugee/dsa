
import java.util.PriorityQueue;

public class TwoThree {
    public int smallest(int n) {
        if(n==0) return 1;
        PriorityQueue<Integer> jono = new PriorityQueue<>();
        jono.add(1);
        for(int i = 1; i <= n; i++){
            int min = jono.poll();
            jono.add(2*min);
            jono.add(3*min);
        }
        return jono.poll();
    }

    public static void main(String[] args) {
        TwoThree t = new TwoThree();
        System.out.println(t.smallest(1)); // 2
        System.out.println(t.smallest(5)); // 6
        System.out.println(t.smallest(123)); // 288
        System.out.println(t.smallest(55555)); // 663552
    }
}