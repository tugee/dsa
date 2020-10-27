public class FindTree {
    int counter = 0;
    public int count(Node node1, Node node2) {
        if(node2==null) return 0;
        if(same(node1,node2)) counter++;
        count(node1,node2.left);
        count(node1,node2.right);
        return counter;
    }
    
    public boolean same(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 == null || (node1 == null && node2 != null)) {
            return false;
        }
        if (same(node1.left, node2.left) == true && same(node1.right, node2.right) == true) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        FindTree f = new FindTree();
        Node tree1 = new Node(new Node(null,null),
                              new Node(null,null));
        Node tree2 = new Node(null,
                              new Node(new Node(null,null),
                                       new Node(null,null)));
        System.out.println(f.count(tree1,tree2)); // 1
    }
    
    
}
