// Write a java program to accept a String from a user and display each vowel from a String after every 3 seconds.

import java.util.Scanner;

public class slip23DisplayVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept a string from the user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Convert the string to lowercase for case-insensitive comparison
        input = input.toLowerCase();

        // Iterate over each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (isVowel(ch)) {
                // If the character is a vowel, display it
                System.out.println("Vowel: " + ch);
                try {
                    // Pause for 3 seconds
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        scanner.close();
    }

    // Function to check if a character is a vowel
    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
