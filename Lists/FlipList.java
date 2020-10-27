public class FlipList {
    boolean flipped = false;
    Node last;
    Node first;
    int count = 0;
    class Node {
        Node previous;
        Node next;
        int value;
        
        public Node(int value){
            this.previous = null;
            this.next = null;
            this.value = value;
        }
        
        public Node(int value, Node previous){
            this.previous = previous;
            this.next = null;
            this.value = value;
        }
        
    }
    public void pushLast(int x) {
        if(last == null || first == null){
            Node newNode = new Node(x);
            first = newNode;
            last = newNode;
            count++;
            return;
        } 
        if(flipped){
            Node newNode = new Node(x);
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
            count++;
        } else {
            Node newNode = new Node(x, last);
            last.next = newNode;
            last = newNode;
            count++;
        }
    }

    public void pushFirst(int x) {
        if(first == null|| last == null){
            Node newNode = new Node(x);
            first = newNode;
            last = newNode;
            count++;
            return;
        }
        if(flipped){
            Node newNode = new Node(x,last);
            last.next = newNode;
            last = newNode;
            count++;
        } else {
            Node newNode = new Node(x);
            newNode.next = first;
            first.previous = newNode;
            first = newNode;  
            count++;
        }
    }

    public int popLast() {
        if (last == null) {
            return -1;
        }
        if(flipped){
            int temp = first.value;
            if(count >=2) first.next.previous = null;
            first = first.next;
            count--;
            return temp;
        } else {
            int temp = last.value;
            if(count >=2) last.previous.next = null;
            last = last.previous;
            count--;
            return temp;
        }
    }

    public int popFirst() {
        if(first == null){
            return -1;
        }
        if(flipped){
            int temp = last.value;
            if(count >=2) last.previous.next = null;
            last = last.previous;
            count--;
            return temp;
        } else {
            int temp = first.value;
            if(count >=2) first.next.previous = null;
            first = first.next;
            count--;
            return temp;
        }
    }

    public void flip() {
        flipped = !flipped;
    }
    
    public void printList(){
        Node printNode = first;
        while(printNode != null){
            System.out.println(printNode.value);
            printNode = printNode.next;
        }
    }

    public static void main(String[] args) {
        FlipList f = new FlipList();
        f.pushLast(19);
        System.out.println(f.popFirst());
        f.pushLast(7);
        f.pushLast(2);
        System.out.println(f.popLast());
        System.out.println(f.popFirst());
        f.pushLast(10);
        System.out.println(f.popFirst());

    }
}