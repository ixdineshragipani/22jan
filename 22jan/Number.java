import java.util.*;
import java.io.*;
import java.lang.*;
public class Number {
    public String isPositive(int a){
        if (a>0){
            return "positive";
        }
        else if (a<0){
            return "Negative";
        }
        else{
            return "Zero";
        }
    }
    public String isEvenOdd(int a){
        if (a%2==0){
            return "Even";
        }
        else{
            return "odd";
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.println(new Number().isPositive(a));
        System.out.println(new Number().isEvenOdd(a));
    }
}
