
import java.util.ArrayDeque;

public class Brackets {
    public int count(String s) {
        ArrayDeque<String> pino = new ArrayDeque<>();
        for(int i = 0; i < s.length();i++){
            String vertaus = ""+s.charAt(i);
            if(pino.isEmpty()){
                pino.add(""+s.charAt(i));
                continue;
            }
            if(vertaus.equals(")") && pino.getLast().equals("(")){
                pino.removeLast();
            } else {
                pino.add(""+s.charAt(i));
            }
        }
        return pino.size();
    }

    public static void main(String[] args) {
        Brackets b = new Brackets();
        System.out.println(b.count("())())()()(")); // 0
//        System.out.println(b.count("))))))")); // 6
//        System.out.println(b.count("((())(")); // 2
    }
}
