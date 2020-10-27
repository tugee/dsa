
import java.util.*;

public class hashAlgo {
    public static void main(String[] args){
        HashMap<Integer,Integer> hajautus = new HashMap<>();
        
        for(int i = 0; i < 1000000;i++){
            String asd = "";
            for(int j = 0; j < 20; j++){
                Random rnd = new Random();
                char c = (char) ('a' + rnd.nextInt(26));
                asd+=c;
            }
            hajautus.put(asd.hashCode(), hajautus.getOrDefault(asd.hashCode(), 0) + 1);
        }
        int max = 0;
        int unique = 0;
        for(Integer i : hajautus.keySet()){
            int asd = hajautus.get(i);
            if(asd==1) unique++;
            if(asd>max) max = asd;
        }
        System.out.println(hajautus.keySet().size());
        System.out.println(max+" "+unique);
    }
}
