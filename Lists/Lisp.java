
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Lisp {
    String operator;
    public long eval(String s) {
        String operator = "";
        int open = 0;
        int close = 1;
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i)=='*'||s.charAt(i)=='+'){
                operator = ""+s.charAt(i);
            } else if(s.charAt(i)=='('){
                open = i;
            } else if(s.charAt(i)==')'){
                close = i;
                break;
            }
        }
        if(open==0&& close == 1){
            return Long.valueOf(s);
        }
        String kasiteltava = s.substring(open,close);
        String[] kakka = kasiteltava.split("\\s+");
        long resultant = operator.equals("*") ? 1 : 0;
        for(int i = 1; i < kakka.length;i++){
           long operoitava = Long.valueOf(kakka[i]);
           if(operator.equals("*")){
               resultant *= operoitava;
           } else{
               resultant += operoitava;
           }
        }
        String seuraava = s.substring(0,open) +resultant+s.substring(close+1,s.length());
        return eval(seuraava);
    }

    public static void main(String[] args) {
        Lisp l = new Lisp();
        System.out.println(l.eval("(+ 1 2 3 4 5)")); // 15
        System.out.println(l.eval("(+ 5 (* 3 2) 7)")); // 18
        System.out.println(l.eval("(* (+ (+ 1 2) 3) (+ (* 4 5) 6 2))")); // 168
    }
}