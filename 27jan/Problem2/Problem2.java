import java.io.*;
import java.util.*;
public class Problem2{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] names={"Raju","Ramu","Dinesh","Sravan","Dinesh","Raju","Shekar"};
        List<String> list = new ArrayList<>();  //Convert Array to ArrayList
        for(int i=0;i<names.length;i++){
            list.add(names[i]);
        }
        System.out.println(list); //Printing all the list elements

        //Remove duplicates using hashSet

        Set<String> hs=new HashSet<>();
        for(String name:list){
            hs.add(name);
        }
        System.out.println(hs);

        //Create hashmap for frequency count

        Map<String, Integer> hm=new HashMap<>();
        for (String name:list){
            hm.put(name,hm.getOrDefault(name,0)+1);
        }
        System.out.println(hm);

        //Multiple iterators
        Iterator<String> iter=hs.iterator(); //from hashset
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("Hashset to array print");
        for(int i=0;i<hs.size();i++){
            System.out.println(hs.toArray()[i]);//using hashset to array
        }
        //Enhaned for loop
        System.out.println("Enhanced for loop");
        for(String name:names){
            System.out.println(name);
        }
        
    }
}