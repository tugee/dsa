
import java.util.HashMap;

public class Mode {
    HashMap<Integer, Integer> moro = new HashMap<>();
    int max = 1;
    int countMax = 0;
    public int add(int x) {
        moro.put(x,moro.getOrDefault(x, 0)+1);
        if(moro.get(x)>countMax){
            countMax=moro.get(x);
            max = x;
        }
        if(moro.get(x)==countMax){
            max = Math.min(x,max);
        }
        // TODO
        return max; 
    }

    public static void main(String[] args) {
        Mode m = new Mode();
        System.out.println(m.add(1)); // 1
        System.out.println(m.add(2)); // 1
        System.out.println(m.add(2)); // 2
        System.out.println(m.add(1)); // 1
        System.out.println(m.add(3)); // 1
        System.out.println(m.add(3)); // 1
        System.out.println(m.add(3)); // 3
    }
}