// Write a java program to scroll the text from left to right continuously.


public class slip24TextScroll {
    public static void main(String[] args) throws InterruptedException {
        String text = "Hello, World!"; // Text to be scrolled
        int width = 20; // Width of the console window
        int scrollDelay = 200; // Delay in milliseconds between scrolls

        while (true) {
            for (int i = 0; i < width; i++) {
                // Print leading spaces
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }

                // Print the text
                System.out.print(text);

                // Print trailing spaces to fill the console window
                for (int j = 0; j < width - i - text.length(); j++) {
                    System.out.print(" ");
                }

                // Sleep to control the speed of scrolling
                Thread.sleep(scrollDelay);

                // Clear the console
                System.out.print("\r");
            }
        }
    }
}
