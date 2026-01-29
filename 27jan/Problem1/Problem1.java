import java.io.*;

public class Problem1 {
    public static void main(String[] args) throws IOException {

        String filePath = "FileHandling.txt";
        String outputPath = "output.txt";

        try {
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

        } catch (Exception e) {
            System.out.println("A file error occurred");
            e.printStackTrace();
        }
    }
}
