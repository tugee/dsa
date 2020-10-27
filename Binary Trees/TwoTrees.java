import java.util.*;

public class TwoTrees {
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
        TwoTrees t = new TwoTrees();
        Node tree1 = new Node(null,
                              new Node(new Node(null,null),
                                       new Node(null,null)));
        Node tree2 = new Node(new Node(new Node(null,null),
                                       new Node(null,null)),
                              null);
        Node tree3 = new Node(null,
                              new Node(new Node(null,null),
                                       new Node(null,null)));
        System.out.println(t.same(tree1,tree2)); // false
        System.out.println(t.same(tree1,tree3)); // true
        System.out.println(t.same(tree2,tree3)); // false
    }
}