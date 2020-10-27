import java.util.HashMap;
public class BothSame {
    public long count(String s) {
        long count = s.length();
        HashMap<String,Long> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char holder = s.charAt(i);
            map.put(""+holder, map.getOrDefault(""+holder,(long)0)+1);
        }
        for(String values : map.keySet()){
            long add = map.get(values);
            if(add==2){
                count++; 
            } else if(add >2){
                count+=((add)*(long)(add-1))/2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BothSame b = new BothSame();
        System.out.println(b.count("aaa")); // 6
        System.out.println(b.count("abcd")); // 4
        System.out.println(b.count("ababca")); // 10
    }
}