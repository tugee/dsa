public class StackSort {
    public boolean check(int[] t) {
        return false;
    }

    public static void main(String[] args) {
        StackSort s = new StackSort();
        System.out.println(s.check(new int[] {4,5,2,3,1})); // true 
        System.out.println(s.check(new int[] {2,3,4,5,1})); // false 
        System.out.println(s.check(new int[] {1,5,2,4,3})); // true 
    }
}