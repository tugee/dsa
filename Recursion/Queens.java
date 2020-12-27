public class Queens {
    
    static int laskuri = 0;
    static int n = 11;
    static int[] table = new int[n];
    
    static void search(int y){
        if(y==n){
            laskuri++;
        } else {
            for(int i = 0; i < n; i++){
                if(validPlacement(y,i)){
                    table[y] = i;
                    search(y+1);
                }
            }
        }
    }
    static boolean validPlacement(int y, int x){
        for(int i = 0; i < y; i++){
            if(table[i] == x){
                return false;
            }
            if(Math.abs(i-y)==Math.abs(table[i]-x)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        search(0);
        System.out.println(laskuri);
    }
}
