/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuukk
 */
public class algoritmi {
    
    public static void main(String[] args) {
        int count = 0;
        int n = 100000;
        int[] a = new int[n+1];
        long start = System.nanoTime();
        for(int i = 2; i <= n; i++){
            if(a[i]==0){
                count++;
            }
            for(int j = 2*i; j <= n; j+=i){
                a[j]=1;
            }
        }
        long end = System.nanoTime();
        System.out.println((end-start)/1E6);
        System.out.println(count);

    }
}

