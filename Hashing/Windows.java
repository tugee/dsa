import java.util.*;

public class Windows {
    public int[] count(int[] t, int k) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int[] result = new int[t.length-k+1];
        
        int nCount = 0;
        int increment = 0;
        int smallest = 0;
        int end = 0;
        
        for(int i = 0; i <= t.length; i++){
            if(nCount == k){
                result[increment++] = map.size();
                ArrayList<Integer> altered = map.get(t[smallest]);
                if (altered.isEmpty() || altered.size()==1) {
                    map.remove(t[smallest]);
                } else {
                    altered.remove(0);
                    map.put(t[smallest], altered);
                }
                smallest++;
                nCount--;
            }
            if(i==t.length){
                break;
            }
            ArrayList<Integer> puttable = map.getOrDefault(t[end], new ArrayList<>());
            puttable.add(end);
            map.put(t[end],puttable);
            end++;
            nCount++;
        }
        
        return result;
        // TODO
    }

    public static void main(String[] args) {
        Windows w = new Windows();
        System.out.println(Arrays.toString(w.count(new int[] {1,1,2,2}, 2))); // [1,2,1]
        System.out.println(Arrays.toString(w.count(new int[] {1,1,1,1}, 4))); // [1]
        System.out.println(Arrays.toString(w.count(new int[] {1,2,3,2,2,2}, 3))); // [3,2,2,1]
    }
}