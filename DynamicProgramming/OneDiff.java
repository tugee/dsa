
package DynamicProgramming;

import java.util.Arrays;

public class OneDiff {
    public int find(int[] t) {
        int[] longest = new int[t.length];
        int maxValue = 1;
        for(int i = 0; i < t.length; i++){
            longest[i] = 1;
            for(int j = 0; j < i; j++){
                if((t[j]+1 == t[i] || t[j]-1==t[i]) && longest[j]+1> longest[i]){
                    longest[i] = longest[j] + 1;
                    if(longest[i] > maxValue){
                        maxValue = longest[i];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(longest));
        return maxValue;
    }

    public static void main(String[] args) {
        OneDiff o = new OneDiff();
        System.out.println(o.find(new int[] {1,2,3,4,5})); // 5
        System.out.println(o.find(new int[] {5,5,5,5,5})); // 1
        System.out.println(o.find(new int[] {5,2,3,8,2,4,1})); // 4
    }
}