import java.util.*;

public class Robot {
    public int count(String s) {
        Integer[] coord = new Integer[2];
        coord[0]=0;
        coord[1]=0;
        HashSet<String> map = new HashSet<>();
        map.add(Arrays.toString(coord));
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i)== 'L'){
                coord[0]++;
                map.add(Arrays.toString(coord));
            }
            if(s.charAt(i)== 'R'){
                coord[0]--;
                map.add(Arrays.toString(coord));
            }
            if (s.charAt(i) == 'U') {
                coord[1]++;
                map.add(Arrays.toString(coord));
            }
            if (s.charAt(i) == 'D') {
                coord[1]--;
                map.add(Arrays.toString(coord));
            }
        }
        return map.size();
    }
    
    public static void main(String[] args) {
        Robot r = new Robot();
        System.out.println(r.count("LL")); // 3
        System.out.println(r.count("UUDLRR")); // 5
        System.out.println(r.count("UDUDUDU")); // 2
    }
}