package Recursion;


import java.util.Arrays;

public class Partition {
    boolean found = false;
    long totalSum;
    
    public boolean checkHelper(int[] t, int subsetLength, long includedSum){
        if(includedSum == 0) return true;
        if(subsetLength == 0 && includedSum != 0) return false;
        if(t[subsetLength - 1] > includedSum) return checkHelper(t,subsetLength-1, includedSum);
        return checkHelper(t,subsetLength-1, includedSum) || checkHelper(t,subsetLength-1, includedSum - t[subsetLength-1]);
    }
    
    public boolean check(int[] t) {
        boolean[] chosen = new boolean[t.length];
        found = false;
        totalSum = 0;
        for(int i = 0; i < t.length;i++){
            totalSum += t[i];
        }
        if(totalSum  % 2 != 0) return false;
        return checkHelper(t,t.length,totalSum / 2);
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        System.out.println(p.check(new int[] {3,4,5})); // false
        System.out.println(p.check(new int[] {16,8,4,4})); // true
        System.out.println(p.check(new int[] {9,4,8,7,6})); // true
        System.out.println(p.check(new int[] {1,2,3,4,5,6})); // false
        System.out.println(p.check(new int[] {1,2,3,4,5,6,7})); // true
        System.out.println(p.check(new int[] {4,4,4,6,6})); // true
    }
}