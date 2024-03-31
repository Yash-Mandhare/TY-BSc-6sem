// Write a Java program to display all the alphabets between ‘A’ to ‘Z’ after every 2 seconds.

public class AlphabetDisplay {
    public static void main(String[] args) {
        char currentChar = 'A';
        
        // Loop through the alphabets from 'A' to 'Z'
        while (currentChar <= 'Z') {
            // Display the current alphabet
            System.out.print(currentChar + " ");
            
            // Increment to the next alphabet
            currentChar++;
            
            try {
                // Pause execution for 2 seconds
                Thread.sleep(20); // 2000 milliseconds = 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
