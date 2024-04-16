// Write a Java program to create LinkedList of integer objects and perform the following:
// i. Add element at first position
// ii. Delete last element
// iii. Display the size of link list


import java.util.LinkedList;

public class slip29LinkedListOperations {
    public static void main(String[] args) {
        // Create a LinkedList of integer objects
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Add element at first position
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addFirst(30);

        // Display the elements in the LinkedList
        System.out.println("LinkedList after adding elements at first position: " + linkedList);

        // Delete last element
        if (!linkedList.isEmpty()) {
            linkedList.removeLast();
        }

        // Display the elements in the LinkedList after deleting the last element
        System.out.println("LinkedList after deleting last element: " + linkedList);

        // Display the size of the LinkedList
        System.out.println("Size of LinkedList: " + linkedList.size());
    }
}
