// Write a java program to accept ‘N’ integers from a user. Store and display integers in sorted order having proper collection class. The collection should not accept duplicate elements.

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class slip17SortedIntegersWithoutDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers (N): ");
        int N = scanner.nextInt();

        Set<Integer> integerSet = new TreeSet<>();

        // Accept N integers from the user
        System.out.println("Enter " + N + " integers:");
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            integerSet.add(num); // Adding integers to TreeSet (duplicates will be automatically eliminated)
        }

        // Display sorted integers without duplicates
        System.out.println("Sorted integers without duplicates:");
        for (int num : integerSet) {
            System.out.println(num);
        }

        scanner.close();
    }
}
