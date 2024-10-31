import java.io.*;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            InputStreamReader ber = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ber);
            System.out.println("Enter the 2 numbers to divide:");
            String a = br.readLine();
            String b = br.readLine();
            int c = Integer.parseInt(a);
            int d = Integer.parseInt(b);
            
            // Perform division inside try block
            float y = c / d;
            System.out.println("Result: " + y);
        } catch (ArithmeticException e) {
            // Handle specific exception for division by zero
            System.out.println("Error: The number cannot be divided by zero.");
        } catch (NumberFormatException e) {
            // Handle exception for invalid number formats
            System.out.println("Error: Please enter valid integers.");
        } catch (IOException e) {
            // Handle IOException
            System.out.println("Error: An I/O error occurred.");
        } finally {
            System.out.println("Final block executed.");
        }
    }
}
