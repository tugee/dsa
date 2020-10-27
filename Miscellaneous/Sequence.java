public class Sequence {
    public String generate(int n) {
       if(n==1) return "1";
       if(n==2) return "11";
       
       String say = "11";
       for(int times = 3; times <= n ; times++){
           say +="s";
           String temp = "";
           int count = 1;
           System.out.println(say.length());
           for (int i = 0; i < say.length() - 1; i++) {
               System.out.println(say.length()-1);
               char previous = say.charAt(i);
               char important = say.charAt(i + 1);
               System.out.println(previous+"=="+important);
               if (previous == important) {
                   count += 1;
               } else {
                   temp += count + "" + previous;
                   count = 1;
               }

           }

           say = temp;
       }
    return say;
    }

    public static void main(String[] args) {
        Sequence s = new Sequence();
        System.out.println(s.generate(1)); // 1
        System.out.println(s.generate(2)); // 11
        System.out.println(s.generate(3)); // 21
        System.out.println(s.generate(4)); // 1211
        System.out.println(s.generate(5)); // 111221
    }
}