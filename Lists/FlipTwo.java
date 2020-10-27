
import java.util.ArrayDeque;

public class FlipTwo {
    public int solve(int n, int k) {
        ArrayDeque<Integer> pino = new ArrayDeque<>();
        for(int i = 1; i<=n; i++){
            pino.add(i);
        }
        while(k>0){
            int temp = pino.pop();
            pino.addLast(pino.pop());
            pino.addLast(temp);
            k--;
        }
        return pino.getFirst();
    }
    
    public static void main(String[] args) {
        FlipTwo f = new FlipTwo();
        System.out.println(f.solve(4,3)); // 4
        System.out.println(f.solve(12,5)); // 11
        System.out.println(f.solve(99,555)); // 11
    }
}