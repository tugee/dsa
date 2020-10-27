
import java.util.Arrays;

public class SplitList {
    public int count(int[] t) {
        
        int count = 0;
        int[] leftMax = new int[t.length];
        int[] rightMin = new int[t.length];
        // init leftMax
        leftMax[0] = t[0];
        for(int i = 1; i < t.length; i++){
            if(t[i]>leftMax[i-1]){
                leftMax[i] = t[i];
            } else {
                leftMax[i] = leftMax[i-1];
            }
        }
        rightMin[t.length-1] = t[t.length-1];
        for(int i = t.length - 2; i >= 0; i--){
            if (t[i] < rightMin[i + 1]) {
                rightMin[i] = t[i];
            } else {
                rightMin[i] = rightMin[i + 1];
            }
        }
        for(int i = 0; i < t.length - 1; i++){
            if(leftMax[i] < rightMin[i+1]){
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        SplitList s = new SplitList();
        System.out.println(s.count(new int[] {1,2,3,4,5})); // 4
        System.out.println(s.count(new int[] {5,4,3,2,1})); // 0
        System.out.println(s.count(new int[] {2,1,2,5,7,6,9})); // 3
    }
}