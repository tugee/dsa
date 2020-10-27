
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuukk
 */
public class lomitusJarjestaminen {
    static int[] taulu = new int[100000];
    static int[] apu = new int[taulu.length];

    public static void sort(int a, int b){
        if(a==b){
            return;
        }
        int k = (a+b)/2;
        sort(a,k);
        sort(k+1,b);
        merge(a,k,k+1,b);
    }
    
    public static void merge(int a1, int b1, int a2, int b2){
        int a = a1; 
        int b = b2;
        for(int i=a; i<=b; i++){
            if(a2>b2 || a1 <= b1 && taulu[a1]<=taulu[a2]){
                apu[i] = taulu[a1];
                a1++;
            }
            else {
                apu[i] = taulu[a2];
                a2++;
            }
        }
        for(int i = a; i<=b;i++){
            taulu[i] = apu[i];
        }
        
    }
    
    public static void main(String[] args) {
        int arrLength = taulu.length;
        for (int i = 0; i < arrLength; i++) {
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
        sort(0,arrLength-1);
        long end = System.nanoTime();
        System.out.println((end - start) / 1E6);
        System.out.println(Arrays.toString(taulu));
    }
}
