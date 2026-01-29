import java.util.*;
import java.io.*;
import java.lang.*;
public class Problem_3 {
    public int add(int a, int b){
        return a+b;
    }
    public boolean isEven(int a){
        if((a^1)==(a+1)){ //a%2==0 also we can use
            return true; //Even
        }
        else{
            return false; //Odd
        }
    }
    public int findFactorial(int a){
        if(a==1){
            return 1;
        }
        else{
            return a*findFactorial(a-1);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        Problem_3 p3=new Problem_3();
        System.out.println(p3.add(a,b));
        System.out.println(p3.isEven(a));
        System.out.println(p3.findFactorial(a));
        System.out.println(0);
        System.out.println(0);
        System.out.println(0);
        sc.close();
    }
}
