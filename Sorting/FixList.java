import java.util.*;

public class FixList {
    public long changes(int[] t) {
        long count = 0;
        // have idea of where left, which  is gthe closest 
        long max = 0;
        for(int i = 0; i< t.length-1; i++){
            max = Math.max(t[i], max);
            if(max>t[i+1]){
                count+=(max-t[i+1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FixList f = new FixList();
        System.out.println(f.changes(new int[] {7, 1, 2, 5, 3, 6, 3}));
        System.out.println(f.changes(new int[] {3,2,5,1,7})); // 5
        System.out.println(f.changes(new int[] {1,2,3,4,5})); // 0
        System.out.println(f.changes(new int[] {3,3,1,4,2})); // 4
    }
}
