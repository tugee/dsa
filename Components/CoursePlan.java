import java.util.*;

public class CoursePlan {
    HashMap<String,ArrayList<String>> graph = new HashMap<>();
    HashMap<String, Integer> color;
    ArrayList<String> settled;
    boolean cycle;
    
    public void addCourse(String course) {
        graph.put(course,new ArrayList<>());
    }

    public void addRequisite(String course1, String course2) {
        graph.get(course1).add(course2);
    }

    public ArrayList<String> find() {
        color = new HashMap<>();
        settled = new ArrayList<>();
        cycle = false;
        
        for(String course : graph.keySet()){
            color.put(course,0);
        }
        
        for(String course : graph.keySet()){
            System.out.println(course);
            System.out.println(color.get(course));
            if(color.get(course)==0){
                dfs(course);
            }
        }
        Collections.reverse(settled);
        return cycle == false ? settled : null;
    }
    
    void dfs(String i){
        System.out.println(i + ", "+color.get(i)+",  "+(color.get(i) == 1));
        if(color.get(i) == 1){
            cycle = true;
            return;
        }
        
        if(color.get(i)==2){
            return;
        }
        color.put(i,1);
        
        if(graph.containsKey(i)){
            for(String neighbour : graph.get(i)){
                if(!color.containsKey(neighbour)) continue;
                dfs(neighbour);
            }
        }
        color.put(i,2);
        settled.add(i);
        
    }

    public static void main(String[] args) {
        CoursePlan c = new CoursePlan();
        c.addCourse("Ohpe");
        c.addCourse("Ohja");
        c.addCourse("Tira");
        c.addCourse("Jym");
        c.addRequisite("Ohpe","Ohja");
        c.addRequisite("Ohja","Tira");
        c.addRequisite("Jym","Tira");
        System.out.println(c.find()); // [Ohpe,Jym,Ohja,Tira]
        c.addRequisite("Tira","Tira");
        System.out.println(c.find()); // null
    }
}