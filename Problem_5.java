import java.io.*;
import java.util.*;

public class Problem_5 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        // int id=sc.nextInt();
        // String name=sc.next();
        // int salary=sc.nextInt();
        // String company_name=sc.next();
        Employee obj1=new Employee(100,"Dinesh",21000,"Innovatechs");
        Employee obj2=new Employee(101,"Raju",12000,"IBM");
        System.out.println(obj1.displayEmployeeDetails());
        System.out.println(obj2.displayEmployeeDetails());
    }
}
class Employee{
    private int id;
    private String name;
    private int salary;
    private static String company_name;
    Employee (int id,String name,int salary,String company_name){
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.company_name=company_name;
    }
    public int calculateAnnualSalary(int salary){
        this.salary=salary;
        int annual_salary=salary*12;
        return annual_salary;
    }
    
    public String displayEmployeeDetails(){
        return "ID: "+id+" "+"name: "+name+" "+"Annual Salary:"+calculateAnnualSalary(this.salary);
    }
}