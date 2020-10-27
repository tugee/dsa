
import java.util.Arrays;

public class Intervals {
    public int count(int[] t) {
       int count = 1;
       Arrays.sort(t);
       System.out.println(Arrays.toString(t));
       for(int i = 1; i < t.length; i++){
           if(t[i-1]+1==t[i]){
               System.out.println((t[i-1] + 1) + "==" + t[i]);
           } else {
               count++;
           }
       }
       return count;
    }

    public static void main(String[] args) {
        Intervals i = new Intervals();
        System.out.println(i.count(new int[] {4,1,5,3})); // 2
        System.out.println(i.count(new int[] {4,2,1,3})); // 1
        System.out.println(i.count(new int[] {5,2,7,6,3,9})); // 3
    }
}