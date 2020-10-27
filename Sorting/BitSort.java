public class BitSort {
    public long solve(String s) {
        int freeInd = s.length() - 1;
        long count = 0;
        for(int i = s.length() - 1 ; i>=0 ; i--){
            if(s.charAt(i)=='1'){
                count+=freeInd-i;
                freeInd--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BitSort b = new BitSort();
        System.out.println(b.solve("000100")); // 2
        System.out.println(b.solve("111000")); // 9
        System.out.println(b.solve("101010")); // 6
    }
}