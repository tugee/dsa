import java.util.*;
import java.util.stream.Collectors;

public class NewClass {
    
    public static List<String> typosquats(List<String> companyDomains, List<String> newDomains){
        HashMap<String,ArrayList<String>> registeredDomains = new HashMap<>();
        ArrayList<String> possibleSquats = new ArrayList<>();
        
        for(int i = 0; i < companyDomains.size(); i++){
            String[] urls = companyDomains.get(i).split("\\.",2);
            ArrayList<String> tlds = registeredDomains.getOrDefault(urls[0],new ArrayList<>());
            tlds.add(urls[1]);
            registeredDomains.put(urls[0],tlds);
        }

        for(int i = 0; i < newDomains.size();i++){
            String[] urls = newDomains.get(i).split("\\.",2);
            if(registeredDomains.keySet().contains(urls[0])){
                ArrayList tld = registeredDomains.get(urls[0]);
                if(!tld.contains(urls[1])){
                    possibleSquats.add(newDomains.get(i));
                }
            } else {
                String name = similarChar(urls[0]);
                System.out.println(name);
                
                for(String domainName : registeredDomains.keySet()){
                    String newDomainName = similarChar(domainName);
                    String dotSwap = name + urls[1].charAt(0);
                    
                    if(newDomainName.equals(name) && registeredDomains.get(domainName).contains(urls[1])){
                        possibleSquats.add(newDomains.get(i));
                        break;
                    } else if (newDomainName.equals(dotSwap)) {
                        possibleSquats.add(newDomains.get(i));
                        break;
                    } else if(newDomainName.length()==name.length() && registeredDomains.get(domainName).contains(urls[1])) {
                        int index = 0;
                        boolean swap = false;

                        for (int j = 0; j < name.length(); j++) {
                            
                            if (index == newDomainName.length() - 1) {
                                System.out.println("asd");
                                possibleSquats.add(newDomains.get(i));
                                break;
                            } if(name.charAt(j) == newDomainName.charAt(index)){
                                index++;
                            } else if (!swap && ((j != name.length() - 1) && newDomainName.charAt(index) == name.charAt(j + 1) && newDomainName.charAt(index + 1) == name.charAt(j))) {
                                System.out.println("we have a swap");
                                swap = true;
                                if (newDomainName.length() <= 3) {
                                    index++;
                                } else {
                                    index += 2;
                                    j++;
                                }
                            } else {
                                break;
                            }
                        }
                        
                    }
                    
                }
            }
        }
        return possibleSquats;
    }
    
    public static String similarChar(String s){
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
        NewClass asd = new NewClass();
        String[] dom = {"palantir.com", "nic.ci"};
        List<String> dom1 = Arrays.asList(dom);
        String[] regs = {"paiantir.com", "nic.cl", "palantirtechnologies.com", "nlc.biz"};
        List<String> regs1 = Arrays.asList(regs);
       
        String[] dom2 = {"palantir.com", "apple.com"};
        List<String> dom12 = Arrays.asList(dom2);
        String[] regs2 = {"plaantir.com", "aplantirtechnologies.com", "palanti.rbiz"};
        List<String> regs12 = Arrays.asList(regs2);
        System.out.println((asd.typosquats(dom1, regs1)).toString());
        System.out.println((asd.typosquats(dom12, regs12)).toString());
        long kappakeepo = System.nanoTime();
        
        System.out.println((kappakeepo-asad)/1000000);
    }
}
