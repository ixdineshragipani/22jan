
import java.io.*;
import java.util.*;
public class Problem4 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<Number> list=new ArrayList<>();
        System.out.println("Enter numeric values (type 'exit' to stop):");
        while(true){
            String input=sc.nextLine();
            if(input.equalsIgnoreCase("exit")){
                break;
            }
            try{
                if(input.contains(".")){
                    Double d=Double.parseDouble(input);
                    list.add(d);
                }
                else{
                    Integer i=Integer.parseInt(input);
                    list.add(i);
                }
            }
            catch(NumberFormatException e){
                e.printStackTrace();
            }
            // finally{
            //     System.out.println("This is finally block");
            // }
        }
        int intSum=0;
        double doubleSum=0.0;
        int floatCount=0;
        for(Number n:list){
            if(n instanceof Integer){
                intSum+=n.intValue(); //this is unboxing: Integer -> int
            }
            else if(n instanceof Double){
                doubleSum+=n.doubleValue(); // this is unboxing: Double -> double
                floatCount++;
            }
        }
        System.out.println("Sum of integers: "+intSum);
        if(doubleSum>0){
            System.out.println("Average of doubles: "+doubleSum/floatCount);
        }
        else{
            System.out.println("Double sum is not exists");
        }
    }
}