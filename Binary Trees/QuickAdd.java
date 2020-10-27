
import java.util.*;
class Addable implements Comparable<Addable>{
    int number;
    int count;
    
    public Addable(int number, int count){
        this.number = number;
        this.count = count;
    }
    
    @Override
    public int compareTo(Addable o) {
        return number-o.number;
    }
    
}
public class QuickAdd {
    PriorityQueue<Addable> asd = new PriorityQueue<>();
    
    
    
    public void add(int k, int x) {
        asd.add(new Addable(x,k));
    }

    public long remove(int k) {
        long sum = 0;
        while(k > 0){
            
            int minCount = asd.peek().count;
            int min = asd.peek().number;
            if(k>minCount){
                sum+=(long)min*minCount;
                asd.poll();
            } else if (k < minCount) {
                sum+=(long)min*k;
                asd.poll();
                asd.add(new Addable(min,minCount-k));
                break;
            } else {
                sum+=(long)min*k;
                asd.poll();
                break;
            }
            k -= minCount;
        }
        return sum;
    }

    public static void main(String[] args) {
        QuickAdd q = new QuickAdd();
        q.add(5,3);
        System.out.println(q.remove(2)); // 6
        q.add(8,1);
        System.out.println(q.remove(4)); // 4
        System.out.println(q.remove(7)); // 13
        q.add(1000000000,123);
        System.out.println(q.remove(1000000000)); // 123000000000
    }
}