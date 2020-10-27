import java.util.*;
public class Boxes {
    public int count(int[] t, int x) {
        Arrays.sort(t);
        int boxCount = 0;
        int j = 0;
        for(int i = t.length-1; i>=0; i--){
            System.out.println(t[j]+ "<" + t[i]);
            System.out.println(j+"jotain"+i);
            if(i<j){
                break;
            }
            if(t[j]+t[i]<=x){
                boxCount++;
                j++;
            } else {
                boxCount++;
            }
        }
        return boxCount;
    }

    public static void main(String[] args) {
        Boxes b = new Boxes();
        System.out.println(b.count(new int[]{5,4,3,2,1}, 5));
        System.out.println(b.count(new int[] {1,2,3,4}, 10)); // 2
        System.out.println(b.count(new int[] {4,4,4,4}, 4)); // 4
        System.out.println(b.count(new int[] {7,2,3,9}, 10)); // 3
    }
}
