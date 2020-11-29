
package Recursion;
// We place k-1 rectangles.
// If we need to place 2 rectanlges, recursion must realize to save space.
// needs to check whether even qualifies as proper cover. Or is this solved in a generative manner?
public class Cover {
    int counts = 0;
    int m;
    int n;
    
    public int counthelp(int x, int y, int r){
        if(r==1) return 1;
        
        if(x == m && y == n){
            return 1;
            
        } else if (x == m){
            x = 0;
            y++;
            
        } else if (y == n){
            x++;
            y = 0;
            
        }
        System.out.println(x + "," + y + "," + r);
        int subcounts = 0;
        for(int i = x; i <= m; i++){
            subcounts += counthelp(i,y,r-1);
        }
        return subcounts;
    }
    
    public int count(int n, int m, int k){
        this.m = m;
        this.n = n;
        
        return counthelp(0,0,k);
    }
    

    public static void main(String[] args) {
        Cover c = new Cover();
//        System.out.println(c.count(2,2,4)); // 8
//        System.out.println(c.count(2,3,3)); // 13
//        System.out.println(c.count(4,4,1)); // 1
//        System.out.println(c.count(4,3,10)); // 3146
//        System.out.println(c.count(4,4,16)); // 70878
    }
}
