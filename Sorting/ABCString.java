
import java.util.Arrays;

public class ABCString {
    int[] coords; 
    int[] counts;
    
    private void coor(String s){
        for (int i = 0; i < s.length(); i++) {
            if (i <= counts[0] - 1) {
                if (s.charAt(i) == 'A') {
                    coords[0]++;
                }
                if (s.charAt(i) == 'B') {
                    coords[3]++;
                }
                if (s.charAt(i) == 'C') {
                    coords[6]++;
                }
            } else if (i <= counts[1] + counts[0] - 1) {
                if (s.charAt(i) == 'A') {
                    coords[1]++;
                }
                if (s.charAt(i) == 'B') {
                    coords[4]++;
                }
                if (s.charAt(i) == 'C') {
                    coords[7]++;
                }
            } else if (i <= counts[2] + counts[1] + counts[0] - 1) {
                if (s.charAt(i) == 'A') {
                    coords[2]++;
                }
                if (s.charAt(i) == 'B') {
                    coords[5]++;
                }
                if (s.charAt(i) == 'C') {
                    coords[8]++;
                }
            }
        }
    }
    public int solve(String s) {
        this.coords = new int[9];
        this.counts = new int[3];
        int moves = 0;
        for(int i = 0; i <s.length();i++){
            if(s.charAt(i)=='A'){
                counts[0]++;
            } else if(s.charAt(i)=='B'){
                counts[1]++;
            } else{
                counts[2]++;
            }
        }
        coor(s);
        int wrong = s.length()-coords[0]-coords[4]-coords[8];
        System.out.println(wrong);
        if(wrong==0){
            return 0;
        }
        System.out.println(Arrays.toString(counts));
        System.out.println(Arrays.toString(coords));
        int remainder = Math.abs(coords[1]-coords[3]);
        return Math.min(coords[1],coords[3])+Math.min(coords[2],coords[6])+Math.min(coords[5],coords[7])+remainder*2;
    }

    public static void main(String[] args) {
        ABCString a = new ABCString();
        System.out.println(a.solve("BCABBBCACCAAABCCBCCBBBBCCCCABCCABCCBCCCCABABAABBCBBBBCCABAAAAA")); // 4
        System.out.println(a.solve("CACABBBCAAABCAAACABABCCAAABACACCACCCBBAACBCBAAAAABCAACBBACBABACBBC")); // 4
        System.out.println(a.solve("CBBACBAACABAAAABBAACCCAABAABCACACBCCBCCABCCACACCBACBBAABBCACBCBACAAACBC")); // 4
        System.out.println(a.solve("BABBBABBBAACCBABCABCAAACABACCCBCAAABCCBCBBBCCACBBBAABCCBBAACACBBACACB")); // 3
        System.out.println(a.solve("BCCCCABCCCBBABBCBABBACAACCCCAAABCCCBBABABBAAABBBBACBCCBBBABBCCCBAACAAAAABB")); // 3
        System.out.println(a.solve("CAAAAABB"));
        System.out.println(a.solve("CCAABB")); // 4
        System.out.println(a.solve("CBACBA")); // 3
        System.out.println(a.solve("AAAA")); // 0
    }
}

