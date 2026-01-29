import java.io.*;
import java.util.*;
import java.lang.*;

public class Problem3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter user name");
        String userName=sc.next();
        System.out.println("Enter age");
        int age=sc.nextInt();
        System.out.println("Enter email");
        String email=sc.next();
        try{
            System.out.println("vaidation started");
            Validator.validateUserName(userName);
            Validator.validateAge(age);
            Validator.validateEmail(email);
            System.out.println("Validation completed");
        }
        catch (InvalidUserNameException e) {
            System.out.println("Username Error: " + e.getMessage());
        }
        catch (InvalidEmailException e) {
            System.out.println("Email Error: " + e.getMessage());
        }
        catch (InvalidAgeException e) {
            System.out.println("Age Error: " + e.getMessage());
        }
        finally{
            System.out.println("Validation completed");

        }
    }
}
class InvalidUserNameException extends Exception{
    public InvalidUserNameException(String msg){
        super(msg);
    }
}
class InvalidEmailException extends Exception{
    public InvalidEmailException(String msg){
        super(msg);
    }
}
class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(String msg){
        super(msg);
    }
}
class Validator{
    public static void validateUserName(String userName) throws InvalidUserNameException{
        if(userName==null || userName.length()<3 ){
            throw new InvalidUserNameException("Invalid username");
        }
    }
    //unchecked exception so no throws needed
    public static void validateAge(int age){
        if(age<18){
            throw new InvalidAgeException("Invalid age. Age must be above 18");
        }
    }
    public static void validateEmail(String email) throws InvalidEmailException{
        if(email==null || (!email.contains("@") && !email.contains("."))){
            throw new InvalidEmailException("Invalid email");
        }
    }
}
