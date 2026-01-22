import java.io.*;
import java.util.*;

public class Problem_4 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        String name=sc.next();
        int marks=sc.nextInt();
        Student stu=new Student();
        System.out.println(stu.isPassed(marks));
    }
}   
class Student{
    private int id;
    private String name;
    private int marks;
    public String isPassed(int marks){
        this.marks=marks;
        if (marks>40){
            return "Passed";
        }
        else{
            return "Failed";
        }
    }
}