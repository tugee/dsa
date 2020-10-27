
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuukk
 */
public class ABCDiff {
    ArrayList<String> classList;

    public void createApu(int n, String sub) {
        if (sub.length() == n) {
            classList.add(sub);
        } else {
            for (int i = 65; i <= 67; i++) {
                char asd = (char) i;
                if(sub.length()>0 && sub.charAt(sub.length()-1)==asd) continue;
                String newSub = sub + asd;
                createApu(n, newSub);
            }
        }

    }

    public ArrayList<String> create(int n) {
        classList = new ArrayList<>();
        createApu(n, "");
        return classList;
    }

    public static void main(String[] args) {
        ABCDiff a = new ABCDiff();
        System.out.println(a.create(1)); // [A,B,C]
        System.out.println(a.create(2)); // [AB,AC,BA,BC,CA,CB]
        System.out.println(a.create(5).size()); // 48
    }
}
