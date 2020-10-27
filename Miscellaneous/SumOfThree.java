
import static java.lang.Math.round;
public class SumOfThree {
    public long count(int n) {
        long square = (long)(n - 3)*(n - 3);
        int round = square%12 >= 6 ? 1 : 0; 
        long kakka = square/12+round;
        return kakka;
    }

    public static void main(String[] args) {
        SumOfThree s = new SumOfThree();
        for(int i = 3; i < 30; i++){
            System.out.println(s.count(i)); // 2

        }
        System.out.println(s.count(417188422)); // 61
        System.out.println(s.count(1337)); // 148296
    }
}