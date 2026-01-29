import java.util.*;
import java.io.*;
import java.lang.*;
public class Problem {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int c=a;
        System.out.println("Numbers");
        if (c<0){
            System.out.println("Invalid input");
        }
        while(c>0){
            System.out.println(a);
            c--;
        }
        System.out.println("Even numbers");
        for(int j=0;j<a;j++){
            if(j%2==0){
                System.out.println(j);
            }
        }
        System.out.println("Sum of numbers");
        int sum=0;
        if(a>0){
            for(int l=1;l<a;l++){
                sum+=l;
            }
            System.out.println(sum);
        }
        else{
            System.out.println("Enter number greater than zero");
        }
    }
}
