package karat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DomainList {

    public static List<String>  getDomainCount(String [] domains){
        Map<String,Integer> dmap = new HashMap<>();
        for (String domain:domains) {
                Integer hits = Integer.parseInt(domain.substring(0,domain.indexOf(",")));
                String currentDomain = domain.substring(domain.indexOf(",")+1);

                while(!currentDomain.isEmpty()){
                    dmap.put(currentDomain,dmap.getOrDefault(currentDomain,0)+hits);
                    int domainIndex = currentDomain.indexOf(".");
                    currentDomain = currentDomain.substring(domainIndex+1);
                    if(domainIndex==-1){
                        currentDomain="";
                    }

                }

            dmap.forEach((key, value) -> System.out.println(key + " : " + value));



        }
        return null;
    }

    public static void main(String[] args) {

        String [] domains = {"400,map.google.com", "400,mail.google.com", "200,mail.yahoo.com","200,job.yahoo.com"};
        getDomainCount(domains);
    }
}
