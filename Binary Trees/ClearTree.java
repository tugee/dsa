public class ClearTree {
    long ans = 1;
    public long count(Node node) {
        if(node == null) return 1;
        int jaa = countLeaves(node);
        System.out.println(jaa);
        ans *= jaa;
        count(leafDelete(node));
        return ans;
    }
    
    public int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left)+countLeaves(node.right);
    }
    public Node leafDelete(Node node) 
    { 
        if (node == null) { 
            return null; 
        } 
        if (node.left == null && node.right == null) { 
            return null; 
        }
        
        node.left = leafDelete(node.left); 
        node.right = leafDelete(node.right); 
  
        return node; 
    } 

    public static void main(String[] args) {
        ClearTree c = new ClearTree();
//        Node tree = new Node(null,
//                             new Node(new Node(null,null),
//                                      new Node(null,null)));
       Node kakka = new Node(new Node(null, null), new Node(new Node(new Node(null, new Node(null, new Node(null, null))), new Node(null, null)), new Node(null, null)));

        System.out.println(c.count(kakka));
    }
}