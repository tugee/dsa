import java.util.*;
public class WordPairs {
    public long count(String[] t) {
        long count = 0;
        HashMap<String,Long> joo = new HashMap<>();
        for(String a : t){
            HashSet<String> asd = new HashSet<>();
            char[] kakka = a.toCharArray();
            Arrays.sort(kakka);
            for(char m : kakka){
                asd.add(""+m);
            }
            joo.put(asd.toString(),joo.getOrDefault(asd.toString(), 0L)+1);
        }
        for(String k : joo.keySet()){
            System.out.println(k+joo.get(k));
                count+=((long)joo.get(k)*(joo.get(k)-1))/(long)2;
                System.out.println(count);
        }
        return count;
    }

    public static void main(String[] args) {
        WordPairs w = new WordPairs();
        System.out.println(w.count(new String[] {"B", "QYJOQRCK", "WHTADJ", "LH", "FIKBEIZTBF", "JOZP", "DTWPF", "PZOJ", "JYCT", "XFWZWHXEIY", "LOVROWLKD", "WEDLLQ", "ZYGM", "ZACK", "UGH", "LROZNXVE", "JBL", "QDS", "NZHYTVLCL"})); // 3
//        System.out.println(w.count(new String[] {"A","B","C"})); // 0
//        System.out.println(w.count(new String[] {"KALA","ALA","LAKKA"})); // 1
    }
}