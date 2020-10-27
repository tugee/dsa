
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Tasks {
    public class Element implements Comparable<Element>{
        String name;
        int priority;
        public Element(String name, int priority){
            this.name = name;
            this.priority = priority;
        }
        @Override
        public int compareTo(Element o) {
            if(o.priority == priority){
                return name.compareTo(o.name);
            }
            return o.priority-priority;
        }
        
    }
    PriorityQueue<Element> inside = new PriorityQueue<>();
    public void add(String name, int priority) {
        inside.add(new Element(name, priority));
    }

    public String next() {
        return inside.poll().name;
    }

    public static void main(String[] args) {
        Tasks t = new Tasks();
        t.add("siivous",10);
        t.add("ulkoilu",50);
        t.add("opiskelu",50);
        System.out.println(t.next()); // opiskelu
        t.add("treffit",100);
        System.out.println(t.next()); // treffit
        System.out.println(t.next()); // ulkoilu
        System.out.println("task10".compareTo("task14"));
    }
}