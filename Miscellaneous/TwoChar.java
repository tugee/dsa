
import java.util.HashMap;
import java.util.Map;

public class TwoChar {

    public long count2(String s) {
        long counter = 0;
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i - 1) != s.charAt(i)) {
                counter = 0;
            }
            counter++;
            result += counter;
        }
        return result-s.length();
    }
    
    public long count (String s) {
        
        long start = 0;
        long count = 0;
        
        Map<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String holder = "" + s.charAt(i);
            
            if(indexMap.containsKey(holder)){
                indexMap.remove(holder);
            }
            indexMap.put(holder,i);
            
            if(indexMap.size() > 2){
                long min = Long.MAX_VALUE;
                String minKey = "";
                for(String key : indexMap.keySet()){
                    if(indexMap.get(key)<min){
                        minKey = key;
                        min = indexMap.get(key);
                    }
                }
                System.out.println(min);
                indexMap.remove(minKey);
                start = min + 1;
            }

            count += i - start + 1;
        }
        return count-s.length()-count2(s);
    }

    public static void main(String[] args) {
        TwoChar t = new TwoChar();
        System.out.println(t.count("pqpqs")); // 0
        System.out.println(t.count("abab")); // 6
        System.out.println(t.count("aabacba")); // 8
    }
}