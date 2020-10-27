public class BitString {
    public int calculate(String s) {
        int changes = 0;
        for(int i = 0; i < s.length(); i++){
            if(i%2 == 1 && s.charAt(i)=='1' || (i%2==0 && s.charAt(i) == '0')){
                changes++;
            }
        }
        return Math.min(changes,s.length()-changes);
    }

    public static void main(String[] args) {
        BitString b = new BitString();
        System.out.println(b.calculate("1010")); // 0
        System.out.println(b.calculate("1111")); // 2
        System.out.println(b.calculate("10010001")); // 3
    }
}