import java.io.*;
import java.util.*;
public class Problem1_copy{
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        // System.out.println("Enter the text: ");
        // String text=sc.nextLine();
        // HashMap<String, Integer> hm=new HashMap<>();
        String filePath="FileHandling.txt";
        String outputPath="output.txt";
        try{
            //File creation
            // File objfile = new File("FileHandling.txt");
            // if(objfile.createNewFile()){
            //     System.out.println("File is Created"+" "+objfile.getName());
            // }
            // else{
            //     System.out.println("File already exists");
            // }


            //Writing into the file
            
            // BufferedWriter bw=new BufferedWriter(new FileWriter("FileHandling.txt",true));
            // bw.write(text);
            // bw.newLine();
            // bw.close();
            // System.out.println("File Written successfully");


            // Reading From File

            // BufferedReader br=new BufferedReader(new FileReader("FileHandling.txt"));
            // String line;
            // while((line=br.readLine())!=null){
            //     System.out.println(line);
            // }

            // br.close();



            //Count total words,sentances and characters (excluding spaces)

            // BufferedReader br=new BufferedReader(new FileReader("FileHandling.txt"));
            // String line=br.readLine();
            // String line;
            // String para="";
            // while((line=br.readLine())!=null){
            //     para+=line+" ";
            // }
            // int characters=0;
            // int sent=0;
            // int words=0;
            // para=para.trim();
            // for(int i=0;i<para.length();i++){
            //     char ch=para.charAt(i);
            //     if (ch!=' '){
            //         characters++;
            //     }
            //     if(ch=='.' || ch=='!' || ch=='?'){
            //         sent++;
            //     }
            //     if(ch==' '){
            //         words++;
            //     }
            // }
            // System.out.println(para);
            // System.out.println(characters);
            // System.out.println(sent);
            // System.out.println(words);
            

            //Frequent words
            // BufferedReader br=new BufferedReader(new FileReader(filePath));
            // String line;
            // while((line=br.readLine())!=null){
            //     line=line.toLowerCase();
                // String[] words=line.split(" ");

                // print all the words in the file
                // for(int i=0;i<words.length;i++){
                //     System.out.println(words[i]);
                // }

                // for(String word:words){
                //     if(!word.isEmpty()){
                //         hm.put(word,hm.getOrDefault(word,0)+1);
                //     }
                // }
            // }

            // Replacing multiple spaces with single space
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath));

            String line;
            StringBuilder sb = new StringBuilder();

            // Read file line by line
            while ((line = br.readLine()) != null) {

                // Remove extra spaces and keep only one space
                line = line.trim().replaceAll("\\s+", " ");

                sb.append(line).append("\n");
            }

            // Write cleaned content to output file
            bw.write(sb.toString());

            br.close();
            bw.close();

            System.out.println("File processed successfully. Output written to output.txt");

            String[] stt=sb.toString().split("(?<=[!.?])\\s+");
            System.out.println("Reversing");
            for(String s:stt){
                String[] stringWords=s.split(" ");
                StringBuilder rev=new StringBuilder();
                for(int i=stringWords.length-1;i>=0;i--){
                    rev.append(stringWords[i]);
                    rev.append(" ");
            }
        }

        }
        catch(Exception e){
            System.out.println("A File error occured");
        }

        //Assign it to list and sort in ascending order

        // List<Map.Entry<String,Integer>> list=new ArrayList<>(hm.entrySet());
        // list.sort((a,b)->b.getValue()-a.getValue());
        // System.out.println("Top 5 most frequently repeted words");
        // for(int i=0;i<5;i++){
        //     System.out.println(list.get(i).getKey()+"->"+list.get(i).getValue());
        // }

        //Reversing the words
        
        sc.close();
    }
}