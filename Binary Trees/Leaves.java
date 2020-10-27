public class Leaves {
    int asd = 0;
    public int count(Node node) {
        if(node==null) return 0;
        if(node.left == null && node.right==null){
            return 1;
        }
        return count(node.left)+count(node.right);
    }

    public static void main(String[] args) {
        Leaves l = new Leaves();
        Node tree = new Node(null,
                             new Node(new Node(null,null),
                                      new Node(null,null)));
        System.out.println(l.count(tree)); // 2
    }
}
