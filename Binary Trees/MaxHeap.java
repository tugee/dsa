
import java.util.HashMap;

public class MaxHeap {

    public long count(int n) {
        int p = (int)(Math.log(n) / Math.log(2));
        return (long) ((long)(n+1)*p - 2*(Math.pow(2,p)-1));
    }

    public static void main(String[] args) {
        MaxHeap m = new MaxHeap();
        System.out.println(m.count(4)); // 4
        System.out.println(m.count(5)); // 10
        System.out.println(m.count(6)); // 10
        System.out.println(m.count(7)); // 10
        System.out.println(m.count(8)); // 10
        System.out.println(m.count(9)); // 10
        System.out.println(m.count(14)); // 10
        System.out.println(m.count(15)); // 10
        System.out.println(m.count(16)); // 10
        System.out.println(m.count(17)); // 10

        
    }
}