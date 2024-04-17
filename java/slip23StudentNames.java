// Write a java program to accept ‘N’ student names through command line, store them into the appropriate Collection and display them by using Iterator and ListIterator interface.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class slip23StudentNames {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No student names provided.");
            return;
        }

        ArrayList<String> studentList = new ArrayList<>();

        // Add student names to the ArrayList
        for (String name : args) {
            studentList.add(name);
        }

        // Display student names using Iterator
        System.out.println("Student names using Iterator:");
        Iterator<String> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Display student names using ListIterator (in reverse order)
        System.out.println("\nStudent names using ListIterator (in reverse order):");
        ListIterator<String> listIterator = studentList.listIterator(studentList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}



// java StudentNames John Alice Bob