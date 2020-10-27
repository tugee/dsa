import java.util.*;

public class Anagrams {
    public ArrayList<String> create(String s) {
        // TODO
    }

    public static void main(String[] args) {
        Anagrams a = new Anagrams();
        System.out.println(a.create("ab")); // [ab,ba]
        System.out.println(a.create("abac")); // [aabc,aacb,abac,abca,acab,acba,baac,baca,bcaa,caab,caba,cbaa]
        System.out.println(a.create("aybabtu").size()); // 1260
    }
}