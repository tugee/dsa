
import java.util.HashMap;

public class OneChar {    
    public long count(String s) {;
        String temp = "" +s.charAt(0);
        long count = s.length();
        for(int i = 1; i < s.length(); i++){
            char holder = s.charAt(i);
            if(s.charAt(i-1)!=holder){
                if(temp.length()>=2){
                    count+=((temp.length()-1)*(long)temp.length())/2;
                    temp = "" + holder;
                } else {
                    temp = "" + holder;
                }
            } else {
                temp+=holder;
            }
        }
        if (temp.length() >= 2) {
            count += ((temp.length() - 1) * (long)temp.length()) / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        OneChar o = new OneChar();
        System.out.println(o.count("aaa")); // 6
        System.out.println(o.count("abbb")); // 11
        System.out.println(o.count("abcde")); // 5
    }
}
