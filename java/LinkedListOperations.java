// Write a Java program to create LinkedList of String objects and perform the following: 
// i. Add element at the end of the list 
// ii. Delete first element of the list 
// iii. Display the contents of list in reverse order
import java.util.LinkedList;

public class LinkedListOperations {
    public static void main(String[] args) {
        // Create a LinkedList of String objects
        LinkedList<String> linkedList = new LinkedList<>();

        // i. Add element at the end of the list
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Orange");

        // ii. Delete first element of the list
        if (!linkedList.isEmpty()) {
            linkedList.removeFirst();
        }

        // iii. Display the contents of list in reverse order
        System.out.println("Contents of the list in reverse order:");
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            System.out.println(linkedList.get(i));
        }
    }
}
