import java.util.Arrays;

public class Permutations {
    static int n = 9;
    static boolean[] included = new boolean[n];
    static int[] integers = new int[n];
    static int laskuri = 0;
    
    static void search(int k){
        if(k==n){
            laskuri++;
            if(laskuri==54321 || laskuri == 12345){
                System.out.println(Arrays.toString(integers));
            }
            
            return;
        } else {
            for(int i = 0; i < n; i++){
                if(!included[i]){
                    included[i] = true;
                    integers[k] = i+1;
                    search(k+1);
                    included[i] = false;
                }
            }
        }
    }
    public static void main(String[] args){
        search(0);
    }
}
