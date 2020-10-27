import java.lang.Math;
import java.util.Arrays;

public class Rectangles {
    public long area(int rec1[], int rec2[], int rec3[]) {
        int[] first = intersection(rec1,rec2);
        int[] second = intersection(rec2,rec3);
        int[] third = intersection(rec1,rec3);
        
        long area = arrayArea(rec1)+arrayArea(rec2)+arrayArea(rec3)-arrayArea(first)-arrayArea(second)-arrayArea(third);
        long intersection = arrayArea(intersection(first,second));
        return area+intersection;
    }
    
    public long arrayArea(int rec[]){
        return (long)(rec[2]-rec[0])*(rec[1]-rec[3]);
    }
    
    public int[] intersection(int rec1[], int rec2[]){
        int x1 = Math.max(rec1[0], rec2[0]);
        int y1 = Math.min(rec1[1], rec2[1]);
        
        int x2 = Math.min(rec1[2],rec2[2]);
        int y2 = Math.max(rec1[3],rec2[3]);
        
        if(x1>x2 || y2>y1){
            return new int[]{0,0,0,0};
        }
        
        return new int[]{x1,y1,x2,y2};
    }
    
    
    public static void main(String[] args) {
        Rectangles r = new Rectangles();
        int[] rec1 = {-1, 1, 1, -1};
        int[] rec2 = {0, 3, 2, 0};
        int[] rec3 = {0, 2, 3, -2};
        System.out.println(r.area(rec1,rec2,rec3));
        System.out.println(Arrays.toString(r.intersection(rec2, rec3)));
        System.out.println(Arrays.toString(r.intersection(rec1, rec3)));

    }
}