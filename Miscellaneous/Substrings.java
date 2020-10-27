
import java.util.HashSet;

public class Substrings {
    public int count(String s) {
        HashSet<String> sub = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            String substring = "";
            for(int j = i; j < s.length(); j++ ){
                substring += s.charAt(j);
                sub.add(substring);
            }
        // TODO
        }
    return sub.size();
    }
    public static void main(String[] args) {
        Substrings s = new Substrings();
        System.out.println(s.count("aaa")); // 3
        System.out.println(s.count("abc")); // 6
        System.out.println(s.count("saippuakauppias")); // 110
    }
}
