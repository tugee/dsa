package Recursion;

import java.util.*;

public class Anagrams {
    ArrayList<String> classList;
    public void createHelper(String original, String sub,boolean[] included){
        if(sub.length() ==  original.length() && !classList.contains(sub)){
            classList.add(sub);
        } else {
            for(int i = 0; i < original.length(); i++){
                if(!included[i]){
                    included[i] = true;
                    String newSub = sub + original.charAt(i);
                    createHelper(original,newSub,included);
                    included[i] = false;
                }
            }
        }
    }
    
    public ArrayList<String> create(String s) {
        classList = new ArrayList<>();
        boolean[] included = new boolean[s.length()];
        createHelper(s,"",included);
        Collections.sort(classList);
        return classList;
    }

    public static void main(String[] args) {
        Anagrams a = new Anagrams();
        System.out.println(a.create("ab")); // [ab,ba]
        System.out.println(a.create("abac")); // [aabc,aacb,abac,abca,acab,acba,baac,baca,bcaa,caab,caba,cbaa]
        System.out.println(a.create("aybabtdu").size()); // 1260
    }
}