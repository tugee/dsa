
public class fibo {
    public static int count = 0;
    public static long fibonacci(int n){
        count++;
        if(n<=1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    
    public static void main(String[] args) {
        long start = System.nanoTime();
        long fib = fibonacci(40);
        long end = System.nanoTime();
        System.out.println(fib);
        System.out.println(count);
        System.out.println((end - start) / 1E6);
    }
}
