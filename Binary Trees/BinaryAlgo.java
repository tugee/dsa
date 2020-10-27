
public class BinaryAlgo {
   public static class Node {

        Node left, right;

        public Node(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }
    public static int korkeus(Node solmu){
        if(solmu == null){
            return -1;
        }
        return 1 + Math.max(korkeus(solmu.left),korkeus(solmu.right));
    }
    public static void main(String[] args){
        Node asd = new Node(new Node(null, null), new Node(new Node(new Node(null, new Node(null, new Node(null, null))), new Node(null, null)), new Node(null, null)));
        Node asd2 = new Node(new Node(null,new Node(null, new Node(new Node(null,null),new Node(null,new Node(null, new Node(null,new Node(null,null))))))),null);
        Node tree = new Node(
                new Node(new Node(null, null), new Node(null, null)),
                new Node(new Node(null, null), new Node(null, null))
        );
        System.out.println(korkeus(tree));
        System.out.println(korkeus(asd));
        System.out.println(korkeus(asd2));
    }
}
