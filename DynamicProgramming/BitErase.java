
import java.util.HashMap;

public class BitErase {

    public long count2(String s, HashMap<String,Long> map){
        
        HashMap<String, Long> dp = map;

        int n = s.length();
        
        dp.put(s,(long)0);
        dp.put("11",(long)1);
        dp.put("00",(long)1);
        
        for(int i = 1; i < n; i++){
            char current = s.charAt(i);
            if(current == s.charAt(i-1)){
                String removed = s.substring(0, i - 1) + s.substring(i + 1, s.length());
                if(dp.containsKey(removed)){
                    dp.put(s,dp.get(s)+dp.get(removed));
                } else{
                    dp.put(removed, count2(removed,dp));
                    dp.put(s, dp.get(s)+dp.get(removed));
                }
            }
        }
        return dp.get(s);
    }
    
    public long count(String s){
        HashMap<String,Long> dp = new HashMap<>();
        return count2(s,dp);
    }
    
    public static void main(String[] args) {
        BitErase b = new BitErase();
        System.out.println(b.count("1100")); // 2
        System.out.println(b.count("1001")); // 1
        System.out.println(b.count("100111")); // 5
        System.out.println(b.count("11001")); // 0
        System.out.println(b.count("001001110110000100001111101100")); // 113925
    }
}