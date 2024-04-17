// Write a Java program to accept ‘n’ integers from the user and store them in a collection. Display them in the sorted order. The collection should not accept duplicate elements. (Use a suitable collection). Search for a particular element using predefined search method in the Collection framework.
import java.util.*;

public class slip6UniqueSortedIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();
        
        // Create a TreeSet to store unique integers in sorted order
        Set<Integer> integers = new TreeSet<>();
        
        // Accept 'n' integers from the user and store them in the TreeSet
        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            integers.add(num);
        }
        
        // Display integers in sorted order
        System.out.println("Integers in sorted order:");
        for (int num : integers) {
            System.out.println(num);
        }
        
        // Search for a particular element
        System.out.print("Enter the element to search: ");
        int searchElement = scanner.nextInt();
        if (integers.contains(searchElement)) {
            System.out.println("Element found in the collection.");
        } else {
            System.out.println("Element not found in the collection.");
        }
        
        scanner.close();
    }
}
