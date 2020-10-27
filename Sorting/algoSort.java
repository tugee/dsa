
import java.util.Arrays;
import java.util.Random;

public class algoSort {
    

    public static void main(String[] args) {
        int[] taulu = new int[100000];
        int arrLength = taulu.length;
        
        for(int i = 0; i < arrLength; i++){
            taulu[i] = i;
        }
        
        Random r = new Random();
        for (int i = arrLength - 1; i > 0; i--) {

            // Pick a random index from 0 to i 
            int j = r.nextInt(i);

            // Swap arr[i] with the element at random index 
            int temp = taulu[i];
            taulu[i] = taulu[j];
            taulu[j] = temp;
        }
        
        System.out.println(Arrays.toString(taulu));
        
        long start = System.nanoTime();
        for (int i = 1; i < arrLength; i++) {
            int j = i - 1;
            while (j >= 0 && taulu[j] > taulu[j + 1]) {
                int temp = taulu[j];
                taulu[j] = taulu[j+1];
                taulu[j+1] = temp;
                j--;
            }
        }
        long end = System.nanoTime();
        System.out.println((end-start)/1E6);
        System.out.println(Arrays.toString(taulu));
    }

}
