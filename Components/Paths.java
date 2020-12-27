import java.util.*;

class Edge {

    int a, b;

    public Edge(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return "(" + a + "," + b + ")";
    }
}

public class Paths {
    ArrayList<Edge> graph;

    int last; 
    

    
    public ArrayList<Edge> create(int x) {
        graph = new ArrayList<>();        
        int nextNode = 1;
        int diff = x;
        int n = pow2(diff);
        generateFull(nextNode, n);
        diff -= Math.pow(2, n);
        
        last = n;
        
        nextNode += n+1;
        
        while(diff > 0){
            n = pow2(diff);
            System.out.println(n+","+diff);
            graph.add(new Edge(1,nextNode));
            graph.add(new Edge(nextNode,last-n+1));
            diff -= Math.pow(2,n);
            nextNode++;
        }
        
        return graph;
    }
    
    void generateFull(int i,int n){
        System.out.println("Power is:"+n);
        for(int j = i; j <= n+i; j++){
            for(int k = j+1; k <= n+i; k++){
                System.out.println(j+","+k);
                graph.add(new Edge(j,k));
            }
            graph.add(new Edge(j,100));
        }
    }
    
    int pow2(int x){
        int n = (int)(Math.log(x)/Math.log(2));
        return n;
    }
 
    public static void main(String[] args) {
        Paths p = new Paths();
        System.out.println(p.create(3));        
    }
}