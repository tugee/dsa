import java.util.*;

public class Solution {
    
    public List<String> typosquats(String[] domains,String[] registered){
        
        HashMap<String,ArrayList<String>> registeredDomains = new HashMap<>();
        
        for(int i = 0; i < domains.length;i++){
            String[] urls = domains[i].split("\\.",2);
            ArrayList<String> tlds = registeredDomains.getOrDefault(urls[0],new ArrayList<>());
            tlds.add(urls[1]);
            registeredDomains.put(similarChar(urls[0]),tlds);
        }       
        
        ArrayList<String> possibleSquats = new ArrayList<>();

        for(int i = 0; i < registered.length;i++){
            String[] urls = registered[i].split("\\.",2);
            System.out.println(urls[0]);
            if(registeredDomains.keySet().contains(urls[0])){
                ArrayList tld = registeredDomains.get(urls[0]);
                if(!tld.contains(urls[1])){
                    System.out.println("added" + urls[0]);
                    possibleSquats.add(registered[i]);
                }
            } else {
                for(String domainName : registeredDomains.keySet()){
                    System.out.println(domainName);
                    if(urls[0].contains(domainName)){
                        System.out.println("added" + urls[0]);
                        possibleSquats.add(registered[i]);
                        break;
                    } else {
                        String curr = similarChar(urls[0]);
                        String tld = urls[1];
                        String newDomainName = similarChar(domainName);
                        if(curr.contains(domainName)){
                            System.out.println("added" +curr);
                            possibleSquats.add(registered[i]);
                            break;
                        } else if (registeredDomains.get(curr) != null && registeredDomains.get(curr).contains(tld)) {
                            System.out.println("we now check for " + curr+" containing "+newDomainName);
                            int index = 0;
                            boolean swap = false;
                            for(int j = 0; j < curr.length(); j++){
                                System.out.println("Index is "+index+" j is "+j);
                                
                                if(index == newDomainName.length()-1 || (!swap && j == curr.length() - 1 && tld.charAt(0) == newDomainName.charAt(index + 1))){
                                    System.out.println("asd");
                                    possibleSquats.add(registered[i]);
                                    break;
                                }
                                
                                if(curr.charAt(j) == newDomainName.charAt(index)){
                                    index++;
                                } 
                                else if(!swap && ( (j != curr.length()-1) && newDomainName.charAt(index)==curr.charAt(j+1) && newDomainName.charAt(index+1)==curr.charAt(j))){
                                    System.out.println("we have a swap");
                                    swap = true;
                                    if(newDomainName.length()<=3){
                                        index++;
                                    } else{
                                        index+=2;
                                        j++;
                                    }
                                } else {
                                    index = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
        return possibleSquats;  
    };
    
    public String similarChar(String s){
        StringBuilder curr = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
           char c = s.charAt(i);
           if(c == '1' || c == 'i' || c == 'l' || c == '!'|| c == '|'){
               curr.append('i');
           } else if(c=='S' || c=='5' || c=='$'){
               curr.append('S');
           } else if(c=='o' || c=='0'){
               curr.append('o');
           } else if(c=='a' || c == '@'){
               curr.append('a');
           } else if(c=='e' || c == '3'){
               curr.append('e');
           } else {
               curr.append(c);
           }
        }
        return curr.toString();
    }
    
    public static void main(String[] args){
        long asad = System.nanoTime();
        Solution asd = new Solution();
        String[] dom = {"palantir.com", "nic.ci"};
        String[] regs = {"paiantir.com", "nic.cl", "palantirtechnologies.com", "nlc.biz"};
        
        System.out.println((asd.typosquats(dom, regs)).toString());
        long kappakeepo = System.nanoTime();
        
        System.out.println((kappakeepo-asad)/1000000);
    }
    

    
}
