
import java.util.ArrayDeque;
import java.util.ArrayList;


public class lists {
    public static long test1(int n){
        ArrayList<Integer> hidas = new ArrayList<>();
        
        long start = System.nanoTime();
        for (int i = 1; i <= n; i++) {
            hidas.add(i);
        }
        while (!hidas.isEmpty()) {
//            hidas.remove(hidas.size() - 1);
              hidas.remove(0);
        }
        long end = System.nanoTime();
        return (end-start);
    }
    
    public static long test2(int n){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        long start = System.nanoTime();
        for(int i = 1; i<=n; i++){
            stack.addLast(i);
        }
        for(int i = 1; i<=n; i++){
//            stack.removeLast();
            stack.removeFirst();
        }
        long end = System.nanoTime();
        return end-start;
    }
    
    public static void main(String[] args) {
        System.out.println(test1(10000)/1E6);
        System.out.println(test2(10000)/1E6);
    }
}
