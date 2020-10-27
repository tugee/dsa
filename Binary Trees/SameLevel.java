public class SameLevel {
    int lvl = 1;
    public int count(Node node, int level) {
        return count2(node, 1, level);
    }
    public int count2(Node node, int current, int level){
        if(node == null) return 0;
        if(current==level) return 1;
        return count2(node.left,current+1,level)+count2(node.right,current+1,level);
    }

    public static void main(String[] args) {
        SameLevel s = new SameLevel();
        Node tree = new Node(null,
                             new Node(new Node(null,null),
                                      new Node(null,null)));
        System.out.println(s.count(tree,1)); // 1
        System.out.println(s.count(tree,2)); // 1
        System.out.println(s.count(tree,3)); // 2
        System.out.println(s.count(tree,4)); // 0
    }
}