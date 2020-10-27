public class Subtrees {
    int max = 0;
    public int diff(Node node) {
        if(node==null) return 0;
        System.out.println(count(node.right)-count(node.left));
        max = Math.max(Math.abs(count(node.right)-count(node.left)),max);
        diff(node.right);
        diff(node.left);
        return max;
    }
    
    public int count(Node node) {
        if (node == null) return 0;
        return count(node.left)+count(node.right)+1;
    }


    public static void main(String[] args) {
        Subtrees s = new Subtrees();
        Node tree = new Node(null,
                             new Node(new Node(null,null),
                                      new Node(null,null)));
        Node tree2 = new Node(new Node(new Node(new Node(new Node(null, null), null), null), null), new Node(new Node(new Node(new Node(new Node(null, null), null), null), null), null));

        System.out.println(s.diff(tree)); // 3
        System.out.println(s.diff(tree2));
    }
}