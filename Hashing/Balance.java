
import java.util.*;

public class Balance {
    public long count(String s) {
        long ans = 0;
        int n = s.length();
        HashMap<String,Integer> map = new HashMap<>();
        map.put("[0, 0]",1);
        int nA = 0, nB = 0, nC = 0;
        
        for(int i = 0; i < n; i++){
            String holder = "" + s.charAt(i);
            System.out.println(nA+", "+nB+", "+nC);
            
            if(holder.equals("A")){
                nA++;
            }else if(holder.equals("B")){
                nB++;
            } 
            else{
                nC++;
            }
            
            Integer[] kakka = {(nA-nB),(nA-nC)};
            
            String asd = Arrays.toString(kakka);
            
            System.out.println(map.getOrDefault(asd,0));
            ans += map.getOrDefault(asd,0);
            
            map.put(asd,map.getOrDefault(asd,0)+1);
        
        }
        return ans;
    }

    public static void main(String[] args) {
        Balance b = new Balance();
        System.out.println(b.count("CBACBA")); // 5
//        System.out.println(b.count("AAABBC")); // 0
    }
}