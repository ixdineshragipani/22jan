// PROBLEM-5
// Write a Java program that reads student details from a text file, processes the data, and writes the results to another file.
 
// Each line in the input file contains:
// id,name,age
 
// The program should:
// Read the file line by line
// Clean and format the data
// Ignore duplicate student entries
// Handle invalid data without stopping the program
// Store and display processed data
// Write valid and invalid records to separate files
// Log important steps during execution
 
// Expected Behavior
// Extra spaces in names should be removed
// Student age must be 18 or above
// Invalid records should be skipped and recorded
// Duplicate students should be removed
// Final valid students should be printed and saved
// Use proper data types while reading numeric values
// Compare objects correctly when removing duplicates
// Ensure the program continues even if one record is invalid
// Use efficient string manipulation for formatting
// Do not use System.out.println for regular messages
 
// Must Use
// ✔ String and common string methods
// ✔ StringBuilder
// ✔ Wrapper classes
// ✔ Autoboxing / Unboxing
// ✔ Arrays (for input parsing)
// ✔ Collections framework
// ✔ List, Set, Map
// ✔ ArrayList, HashSet, HashMap
// ✔ Iteration techniques (for-each / iterator)
// ✔ Proper object comparison
// ✔ Exception handling using try-catch-finally
// ✔ throw and throws
// ✔ At least one custom exception
// ✔ File input/output
// ✔ Reading and writing files
// ✔ Logging (no System.out.println)
 
 
// Input Example (students.txt)
// 1, Ram ,22
// 2, Ravi,17
// 3, Raju ,22
// x, John,25
 
// Output Files
// valid.txt → valid student records
// invalid.txt → invalid or failed records




import java.io.*;
import java.util.*;

public class Problem5 {
    public static void main(String[] args) throws Exception{
        String inputFile="Student.txt";
        String validOutputFile="validStudent.txt";
        String invalidOutputFile="invalidStudent.txt";
        Set<Student> hs=new HashSet<>();
        StringBuilder valid=new StringBuilder();
        StringBuilder invalid=new StringBuilder();
        System.out.println("The processes is started");
        BufferedReader br=null;  //Reading file
        BufferedWriter bw=null;
        try{
            br=new BufferedReader(new FileReader(inputFile));
            String line;
            while((line=br.readLine())!=null){
                try{  //Cleaning the data
                    line=line.trim();
                    String[] parts=line.split(",");
                    if (parts.length != 3) {
                        throw new IllegalArgumentException("Incorrect format");
                    }
                    int id=Integer.parseInt(parts[0].trim());
                    String name=parts[1];
                    int age=Integer.parseInt(parts[2].trim());
                    if(age<18){
                        throw new InvalidAgeException("Age must be above 18");
                    }
                    Student stu=new Student(id,name,age);

                    //ignoring the duplicate records
                    // hs.add(stu);
                    if (hs.add(stu)){
                        valid.append(stu).append(System.lineSeparator());
                    }
                }catch(Exception e){
                    invalid.append(line).append(System.lineSeparator());
                    // e.printStackTrace();
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            // throw new RuntimeException("A file error occured");
            // System.out.println("This is 1st try exception");
        }
        finally{
            if(br!=null) br.close();
        }

        System.out.println(hs);
        //Write valid records
        try{
            bw=new BufferedWriter(new FileWriter(validOutputFile));
            bw.write(valid.toString());
            System.out.println("Valid records appended");
            System.out.println("Writing completed");
        }
        catch(Exception e){
            e.printStackTrace();
            // throw new RuntimeException("A file error occured");
            // System.out.println("this is try 2 exceptionn");

        }
        finally{
            if(bw!=null) bw.close();
        }
        //Write invalid records
        try{
            bw=new BufferedWriter(new FileWriter(invalidOutputFile));
            bw.write(invalid.toString());
            System.out.println("Invalid records appended");
            System.out.println("Writing invalid records Completed");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(bw!=null) bw.close();
        }


        
        // System.out.print("The list items");
        // System.out.println(list);
        //Displaying all the records
        System.out.println("Displaying all the outputs");
        for(Student s:hs){
            System.out.println(s);
        }
        System.out.println("Entire process completed");
    }
}

class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(String msg){
        super(msg);
    }
}

class Student{
    public int id;
    public String name;
    public int age;
    Student(int id, String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    @Override
    public boolean equals(Object obj){
        if (this==obj)return true;
        if(obj==null || getClass()!=obj.getClass())return false;
        Student other= (Student) obj;
        return this.id==other.id;
    }

    public String toString(){
        return "id: "+id+" "+"name: "+name+" "+"age: "+age; 
    }
}