// Write a java program to accept ‘N’ Subject Names from a user store them into LinkedList Collection and Display them by using Iterator interface.


import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class slip21SubjectNamesLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept the value of N from the user
        System.out.print("Enter the number of subjects (N): ");
        int N = scanner.nextInt();

        LinkedList<String> subjectList = new LinkedList<>();

        // Accept N subject names from the user and add them to the LinkedList
        System.out.println("Enter " + N + " subject names:");
        for (int i = 0; i < N; i++) {
            String subject = scanner.next();
            subjectList.add(subject);
        }

        // Display subject names using Iterator
        System.out.println("Subject names:");
        Iterator<String> iterator = subjectList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        scanner.close();
    }
}
