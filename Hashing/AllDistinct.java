
import java.util.*;

public class AllDistinct {
    public long count(int[] t) {
        long substrings = 0;
        HashMap<String,Integer> subSet = new HashMap<>();
        
        int start = 0;
        int end = 0;
        
        while(start < t.length){
            if(end < t.length && (!subSet.containsKey(""+t[end]) || subSet.get(""+t[end])==0)){
                String holder = "" + t[end];
                subSet.put(holder,subSet.getOrDefault(holder,0)+1);
                substrings += end - start + 1;
                end++;
            } else {
                String holder = "" + t[start];
                subSet.put(holder, subSet.get(holder)-1);
                start++;
            }
        }
        return substrings;
    }

    public static void main(String[] args) {
        AllDistinct a = new AllDistinct();
        System.out.println(a.count(new int[] {1,2,3,4,5})); // 15
        System.out.println(a.count(new int[] {1,1,1,1,1})); // 5
        System.out.println(a.count(new int[] {1,2,1,1,2})); // 8
        System.out.println(a.count(new int[]{3, 1, 2, 1, 1})); // 9
    }
}
