import java.util.*;
public class GraphGame {
    int n;
    HashMap<Integer,ArrayList<Integer>> graph;
    boolean[] losing;
    
    public GraphGame(int n) {
        this.n = n;
        graph = new HashMap<>();        
        for(int i = 1; i <=n; i++){
            graph.put(i,new ArrayList<>());
        }
    }

    public void addLink(int a, int b) {
        if(graph.get(a).contains(b)) return;
        graph.get(a).add(b);
    }

    public boolean winning(int x) {
        int[] losing = new int[n+1];
        ArrayList<Integer> unsettled = new ArrayList<>();
        
        for(int i : graph.keySet()){
            if(graph.get(i).size()==0){
                losing[i] = 2;
            } else {
                unsettled.add(i);
            }
        }
        
        while(true){
            boolean change = false;
            System.out.println(Arrays.toString(losing));
            for(int node : graph.keySet()){
                System.out.println(Arrays.toString(losing));
                if(unsettled.contains(node)){
                   losing[node] = 2;
                   boolean undecided = false;
                   for(int neighbour : graph.get(node)){
                       System.out.println(node+","+neighbour);
                       if(losing[neighbour]==2){
                           System.out.println("okay");
                           losing[node] = 1;
                           unsettled.remove(new Integer(node));
                           change = true;
                           undecided = false;
                           break;
                       } else if(losing[neighbour]==0){
                           undecided = true;
                       }
                   }
                   if(undecided){
                       losing[node] = 0;
                       change = true;
                   }
                }
            }
            if(!change) break;
        }
        
        return losing[x] == 1 ? true : false;
    }

    public static void main(String[] args) {
        GraphGame g = new GraphGame(10);
        g.addLink(8, 4);
        g.addLink(3, 10);
        g.addLink(4, 3);
//        System.out.println(g.winning(9));
        g.addLink(3, 7);
//        System.out.println(g.winning(6));
        g.addLink(9, 4);
        g.addLink(6, 8);
        g.addLink(2, 7);
//        System.out.println(g.winning(6));
        g.addLink(6, 8);
        g.addLink(4, 3);
        g.addLink(2, 8);
        g.addLink(10, 7);
        g.addLink(5, 6);
//        System.out.println(g.winning(10));
        g.addLink(1, 7);
//        System.out.println(g.winning(1));
//        System.out.println(g.winning(4));
        System.out.println(g.winning(5));
    }
}