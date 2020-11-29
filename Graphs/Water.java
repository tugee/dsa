import java.util.*;

public class Water {
    
    class Node implements Comparable<Node>{
        int jug1;
        int jug2;
        int total;
        
        public Node(int jug1, int jug2, int total){
            this.jug1 = jug1;
            this.jug2 = jug2;
            this.total = total;
        }
        
        @Override
        public boolean equals(Object o) {

            // If the object is compared with itself then return true   
            if (o == this) {
                return true;
            }

            // typecast o to Complex so that we can compare data members  
            Node c = (Node) o;

            // Compare the data members and return accordingly  
            return jug1 == c.jug1 && jug2 == c.jug2;
        }

        @Override
        public int compareTo(Node o) {
            return total-o.total;
        }
        
        
        
    }
    public int count(int a, int b, int x) {        
        if(x>a+b){
            return -1;
        }
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        HashSet<String> visited = new HashSet<>();
        
        Node first = new Node(0,0,0);        
        q.add(first);
        int total = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Node curr = q.poll();
//            System.out.println(curr.jug1+","+curr.jug2+" added "+ curr.total);
            
            if(visited.contains(curr.jug1 + "," + curr.jug2)){
                continue;
            }
            
            visited.add(curr.jug1+","+curr.jug2);
            
            if(curr.jug1 == x){
                return curr.total;
            }
            
            ArrayList<Node> status = new ArrayList<>();
            
            status.add(new Node(curr.jug1,b,(curr.total+(b-curr.jug2))));
            status.add(new Node(a,curr.jug2,(curr.total+(a-curr.jug1))));
            status.add(new Node(0, curr.jug2, (curr.total+curr.jug1)));
            status.add(new Node(curr.jug1, 0, (curr.total+curr.jug2)));
            
            if(curr.jug2 < a - curr.jug1){
                status.add(new Node(Math.min(a, curr.jug1 + curr.jug2), 0, (curr.total + curr.jug2)));
            } else {
                status.add(new Node(Math.min(a, curr.jug1 + curr.jug2), curr.jug2 - a + curr.jug1, (curr.total + (a-curr.jug1))));
            }
            
            if(curr.jug1 < b - curr.jug2 ){
                status.add(new Node(0, Math.min(b, curr.jug1 + curr.jug2), (curr.total + curr.jug1)));
            } else {
                status.add(new Node(curr.jug1-b+curr.jug2, Math.min(b, curr.jug1 + curr.jug2), (curr.total + (b-curr.jug2))));
            }
            
//            System.out.println(status.size());
            for(Node state : status){
//                System.out.println("Considering: " + state.jug1 + "," + state.jug2 + " total: " + state.total);

                if(visited.contains(state.jug1 + "," + state.jug2)){
                    continue;
                }
                q.add(state);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Water w = new Water();
        System.out.println(w.count(5,4,2)); // 22
        System.out.println(w.count(4,3,2)); // 16
        System.out.println(w.count(3,3,1)); // -1
        System.out.println(w.count(10,9,8)); // 46
        System.out.println(w.count(123,456,42)); // 10530
    }
}