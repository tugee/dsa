import java.util.*;

public class ABCList {
    ArrayList<String> classList;
    
    public void createApu(int n, String sub){
        if(sub.length() == n){
            classList.add(sub);
        } else {
            for (int i = 65; i <= 67; i++) {
                char asd = (char) i;
                String newSub = sub + asd;
                createApu(n,newSub);
            }
        }

    }
    
    public ArrayList<String> create(int n) {
        classList = new ArrayList<>();
        createApu(n,"");
        return classList;
    }

    public static void main(String[] args) {
        ABCList a = new ABCList();
        System.out.println(a.create(1)); // [A,B,C]
        System.out.println(a.create(2)); // [AA,AB,AC,BA,BB,BC,CA,CB,CC]
        System.out.println(a.create(5).size()); // 243
    }
}