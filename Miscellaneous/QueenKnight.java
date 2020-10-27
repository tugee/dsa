import java.util.stream.LongStream;

public class QueenKnight {
    public int count(int n) {
        if(n==1||n==2){
            return 0;
        }
        int squares = n*n;
        int count = (squares*(squares-1));
        System.out.println(count);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(valid(i+1,j+2,n)) count-=1;
                if(valid(i+1,j-2,n)) count-=1;
                if(valid(i-1,j+2,n)) count-=1;
                if(valid(i-1,j-2,n)) count-=1;
                if(valid(i+2,j+1,n)) count-=1;
                if(valid(i+2,j-1,n)) count-=1;
                if(valid(i-2,j+1,n)) count-=1;
                if(valid(i-2,j-1,n)) count-=1;
                count -= 2*(n-1);
                for(int dir = n; dir>0; dir--){
                        if(valid(i+dir,j+dir,n)) count -=1;
                        if(valid(i-dir,j+dir,n)) count -=1;
                        if(valid(i+dir,j-dir,n)) count -=1;
                        if(valid(i-dir,j-dir,n)) count -=1;
                }
            }
        }
        return count;
    }
    
    public boolean valid(int x, int y, int n){
        if(x>=0 && x<n && y>=0 && y<n){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        QueenKnight q = new QueenKnight();
        System.out.println(q.count(3)); // 0
        System.out.println(q.count(4)); // 40
        System.out.println(q.count(5)); // 184
        System.out.println(q.count(6)); // 184

    }
}
