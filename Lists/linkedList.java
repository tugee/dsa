public class linkedList {
    public static int arvo;
    Node first; 
    Node last;
    
    class Node {
        int arvo;
        Node next;
        
        Node(int value){
            arvo = value;
            next = null;
        }
    }
    public void addLast(int value){
        Node nextNode = new Node(value);
        if(last==null){
            first = nextNode;
            last = nextNode;
        }
        System.out.println(last.arvo);
        last.next = nextNode;
        last = nextNode;
    }
    public void deleteFirst(){
        if(first == null){
            return;
        }
        first = first.next;
    }
    
    public void printList(){
        Node printNode = first;
        while(printNode != null){
            System.out.println(printNode.arvo);
            printNode = printNode.next;
        }
    }
    
    public static void main(String[] args) {
        linkedList lista = new linkedList();
        int n = 10000000;
        long start = System.nanoTime();
        for(int i = 1; i <=n;i++){
            lista.addLast(i);
        }
        long end = System.nanoTime();
        System.out.println((end-start)/1E9);
        
        start = System.nanoTime();
        for(int i = 1; i<=n;i++){
            lista.deleteFirst();
        }
        end = System.nanoTime();
        System.out.println((end-start)/1E9);
    }
    
}
