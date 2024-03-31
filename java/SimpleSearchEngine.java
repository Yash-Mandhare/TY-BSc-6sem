// Write a Java program for a simple search engine. Accept a string to be searched. Search the string in all text files in the current folder. Use a separate thread for each file. The result should display the filename and line number where the string is found.

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleSearchEngine {
    public static void main(String[] args) {
        // Accept the string to be searched
        String searchString = "yoursearchstring"; // Replace "yoursearchstring" with the string you want to search

        // Get the current folder
        File folder = new File(".");
        File[] files = folder.listFiles();

        // Create a thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(files.length);

        // Iterate through each file in the current folder
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                // Create a thread to search the string in the file
                executorService.execute(new SearchTask(file, searchString));
            }
        }

        // Shut down the thread pool
        executorService.shutdown();
    }
}

class SearchTask implements Runnable {
    private File file;
    private String searchString;

    public SearchTask(File file, String searchString) {
        this.file = file;
        this.searchString = searchString;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.contains(searchString)) {
                    System.out.println("Found in file: " + file.getName() + " at line: " + lineNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
