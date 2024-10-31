import java.io.*;

public class FileReadWriteExample {
    public static void main(String[] args) {
        // Specify the input and output file paths
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Declare resources within the try-with-resources block to auto-close
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Read each line from the input file and write it to the output file
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File read and written successfully.");

        } catch (FileNotFoundException e) {
            System.err.println("The specified file was not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
