// Write a java program to accept ‘N’ Integers from a user store them into LinkedList Collection and display only negative integers.


import java.util.LinkedList;
import java.util.Scanner;

public class slip19NegativeIntegersLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept the value of N from the user
        System.out.print("Enter the number of integers (N): ");
        int N = scanner.nextInt();

        LinkedList<Integer> integerList = new LinkedList<>();

        // Accept N integers from the user and add them to the LinkedList
        System.out.println("Enter " + N + " integers:");
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            integerList.add(num);
        }

        // Display only the negative integers from the LinkedList
        System.out.println("Negative integers:");
        for (int num : integerList) {
            if (num < 0) {
                System.out.println(num);
            }
        }

        scanner.close();
    }
}
